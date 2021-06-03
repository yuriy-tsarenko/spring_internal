package com.simple.web.app.service;

import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.util.CustomStatistic;

import java.util.List;

public interface UserWordService {

    List<UserWordDto> getAllFromDb();

    List<CustomStatistic> saveWordsToDb(String text);

    List<UserWordDto> getWordsFromText(String text);

    List<CustomStatistic> generateStatistic(List<UserWordDto> list);

}
