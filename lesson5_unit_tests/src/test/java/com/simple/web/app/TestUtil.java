package com.simple.web.app;

import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.entity.UserWord;
import com.simple.web.app.util.CustomStatistic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestUtil {
    public static List<CustomStatistic> getStatistic() {
        CustomStatistic statistic = new CustomStatistic();
        statistic.setId(1L);
        statistic.setWord("Hello");
        statistic.setUniqueLettersCount(5);

        CustomStatistic statistic1 = new CustomStatistic();
        statistic1.setId(2L);
        statistic1.setWord("World");
        statistic1.setUniqueLettersCount(3);

        CustomStatistic statistic2 = new CustomStatistic();
        statistic2.setId(3L);
        statistic2.setWord("Earth");
        statistic2.setUniqueLettersCount(2);

        List<CustomStatistic> customStatistics = new ArrayList<>();
        customStatistics.add(statistic);
        customStatistics.add(statistic1);
        customStatistics.add(statistic2);

        customStatistics.sort(new SortCustomStat());
        return customStatistics;
    }

    public static String getText() {
        return "Hello" + " " + "World" + " " + "Earth";
    }

    public static List<UserWord> getEntities() {
        UserWord userWord = new UserWord();
        userWord.setId(1L);
        userWord.setWord("Hello");

        UserWord userWord2 = new UserWord();
        userWord2.setId(2L);
        userWord2.setWord("World");

        UserWord userWord3 = new UserWord();
        userWord3.setId(3L);
        userWord3.setWord("Earth");

        List<UserWord> list = new ArrayList<>();
        list.add(userWord);
        list.add(userWord2);
        list.add(userWord3);
        return list;
    }

    public static List<UserWordDto> getDtos() {
        UserWordDto userWordDto = new UserWordDto();
        userWordDto.setId(1L);
        userWordDto.setWord("Hello");

        UserWordDto userWordDto2 = new UserWordDto();
        userWordDto2.setId(2L);
        userWordDto2.setWord("World");

        UserWordDto userWordDto3 = new UserWordDto();
        userWordDto3.setId(3L);
        userWordDto3.setWord("Earth");

        List<UserWordDto> list = new ArrayList<>();
        list.add(userWordDto);
        list.add(userWordDto2);
        list.add(userWordDto3);
        return list;
    }

    public static List<UserWordDto> getDtosNoId() {
        UserWordDto userWordDto = new UserWordDto();
        userWordDto.setId(null);
        userWordDto.setWord("Hello");

        UserWordDto userWordDto2 = new UserWordDto();
        userWordDto2.setId(null);
        userWordDto2.setWord("World");

        UserWordDto userWordDto3 = new UserWordDto();
        userWordDto3.setId(null);
        userWordDto3.setWord("Earth");

        List<UserWordDto> list = new ArrayList<>();
        list.add(userWordDto);
        list.add(userWordDto2);
        list.add(userWordDto3);
        return list;
    }

    public static List<UserWord> getEntitiesNoId() {
        UserWord userWord = new UserWord();
        userWord.setId(null);
        userWord.setWord("Hello");

        UserWord userWord2 = new UserWord();
        userWord2.setId(null);
        userWord2.setWord("World");

        UserWord userWord3 = new UserWord();
        userWord3.setId(null);
        userWord3.setWord("Earth");

        List<UserWord> list = new ArrayList<>();
        list.add(userWord);
        list.add(userWord2);
        list.add(userWord3);
        return list;
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
