package com.simple.web.app.controller;

import com.simple.web.app.service.UserWordServiceImpl;
import com.simple.web.app.util.CustomStatistic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(MainController.BASE_PATH)
@RequiredArgsConstructor
public class MainController {

    public static final String BASE_PATH = "/word";
    private final UserWordServiceImpl service;

    @PostMapping("/save")
    public List<CustomStatistic> saveWords(@RequestParam String text) {
        return service.saveWordsToDb(text);
    }
}
