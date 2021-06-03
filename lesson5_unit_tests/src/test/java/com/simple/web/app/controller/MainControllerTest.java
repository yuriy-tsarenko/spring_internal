package com.simple.web.app.controller;

import com.simple.web.app.TestUtil;
import com.simple.web.app.service.UserWordServiceImpl;
import com.simple.web.app.util.CustomStatistic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private UserWordServiceImpl service;

    @InjectMocks
    private MainController mainController;

    @Test
    void saveWordsToDb() {
        List<CustomStatistic> expected = TestUtil.getStatistic();

        when(service.saveWordsToDb(TestUtil.getText())).thenReturn(TestUtil.getStatistic());

        List<CustomStatistic> result = mainController.saveWords(TestUtil.getText());

        assertEquals(expected, result);

        verify(service).saveWordsToDb(TestUtil.getText());
    }
}