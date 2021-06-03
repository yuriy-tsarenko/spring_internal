package com.simple.web.app.service;

import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.mapper.UserWordMapper;
import com.simple.web.app.repository.UserWordRepository;
import com.simple.web.app.util.CustomStatistic;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Data
public class UserWordServiceImpl implements UserWordService {

    private static final Logger log = Logger.getLogger(UserWordServiceImpl.class);

    private final UserWordMapper mapper;
    private final UserWordRepository repository;

    @Override
    public List<UserWordDto> getAllFromDb() {
        List<UserWordDto> list = mapper.mapEntitiesToDtos(repository.findAll());
        list.sort(new SortWordsById());
        return list;
    }

    @Override
    public List<CustomStatistic> saveWordsToDb(String text) {
        if (text != null && !text.isEmpty()) {
            List<UserWordDto> words = getWordsFromText(text);
            repository.saveAll(mapper.mapDtosToEntities(words));
            log.info("data successfully saved!!! " + "total amount: " + words.size());
            List<CustomStatistic> customStatistics = generateStatistic(getAllFromDb());
            return customStatistics;
        }
        log.error("app haven't received any data " + "total amount: " + 0);
        return null;
    }

    @Override
    public List<UserWordDto> getWordsFromText(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .filter(x -> x.length() > 1)
                .map(String::trim)
                .filter(x -> x.length() < 25)
                .map(x -> new UserWordDto(null, x))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomStatistic> generateStatistic(List<UserWordDto> list) {
        if (list.size() != 0) {
            Set<Character> characters = new HashSet<>();
            AtomicLong id = new AtomicLong(1L);
            List<CustomStatistic> statistic = list.stream()
                    .map(UserWordDto::getWord)
                    .distinct()
                    .map(x -> new CustomStatistic(id.getAndIncrement(), x, null))
                    .collect(Collectors.toList());

            for (CustomStatistic customStatistic : statistic) {
                char[] chars = customStatistic.getWord().toLowerCase().toCharArray();
                int uniqueCount = chars.length;

                for (char item : chars) {
                    if (characters.contains(item)) {
                        uniqueCount--;
                    }
                }

                for (char item : chars) {
                    characters.add(item);
                }

                customStatistic.setUniqueLettersCount(uniqueCount);
            }
            log.info("statistic data generated!!! " + " total amount of el.: " + statistic.size());
            statistic.sort(new SortCustomStat());
            return statistic;
        } else {
            log.warn("no data to generate statistic!!!");
            return null;
        }
    }

    static class SortWordsById implements Comparator<UserWordDto> {
        @Override
        public int compare(UserWordDto userWordDto1, UserWordDto userWordDto2) {
            return userWordDto1.getId().compareTo(userWordDto2.getId());
        }
    }

    static class SortCustomStat implements Comparator<CustomStatistic> {
        @Override
        public int compare(CustomStatistic statistic1, CustomStatistic statistic2) {
            return statistic2.getUniqueLettersCount().compareTo(statistic1.getUniqueLettersCount());
        }
    }
}
