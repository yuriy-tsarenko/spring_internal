package com.simple.web.app.service;

import com.simple.web.app.TestUtil;
import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.mapper.UserWordMapper;
import com.simple.web.app.repository.UserWordRepository;
import com.simple.web.app.util.CustomStatistic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserWordServiceImplTest {

    @Mock
    private UserWordMapper mapper;
    @Mock
    private UserWordRepository repository;

    @InjectMocks
    private UserWordServiceImpl service;

    @Test
    void getAllFromDb() {
        List<UserWordDto> expected = TestUtil.getDtos();

        when(repository.findAll()).thenReturn(TestUtil.getEntities());
        when(mapper.mapEntitiesToDtos(repository.findAll())).thenReturn(TestUtil.getDtos());

        List<UserWordDto> result = service.getAllFromDb();

        assertEquals(expected, result);

        verify(mapper).mapEntitiesToDtos(TestUtil.getEntities());
    }

    @Test
    void saveWordsToDb() {

        List<CustomStatistic> expected = TestUtil.getStatistic();

        when(mapper.mapEntitiesToDtos(TestUtil.getEntities())).thenReturn(TestUtil.getDtos());
        when(repository.saveAll(TestUtil.getEntities())).thenReturn(TestUtil.getEntities());

        List<CustomStatistic> result = service.saveWordsToDb(TestUtil.getText());

        assertEquals(result, expected);

        verify(repository).saveAll(TestUtil.getEntities());
    }

    @Test
    void getWordsFromText() {
        List<UserWordDto> expected = TestUtil.getDtosNoId();

        List<UserWordDto> result = service.getWordsFromText(TestUtil.getText());

        assertEquals(result, expected);
    }

    @Test
    void generateStatistic() {
        List<CustomStatistic> expected = TestUtil.getStatistic();

        List<CustomStatistic> result = service.generateStatistic(TestUtil.getDtos());

        assertEquals(result, expected);
    }
}