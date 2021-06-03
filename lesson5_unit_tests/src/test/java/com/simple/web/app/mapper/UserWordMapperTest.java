package com.simple.web.app.mapper;

import com.simple.web.app.TestUtil;
import com.simple.web.app.dto.UserWordDto;
import com.simple.web.app.entity.UserWord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserWordMapperTest {

    @InjectMocks
    private UserWordMapperImpl mapper;

    @Test
    void mapDtosToEntities() {

        List<UserWord> expected = TestUtil.getEntities();

        List<UserWord> result = mapper.mapDtosToEntities(TestUtil.getDtos());

        assertEquals(expected, result);
    }

    @Test
    void mapEntitiesToDtos() {

        List<UserWordDto> expected = TestUtil.getDtos();

        List<UserWordDto> result = mapper.mapEntitiesToDtos(TestUtil.getEntities());

        assertEquals(expected, result);
    }
}