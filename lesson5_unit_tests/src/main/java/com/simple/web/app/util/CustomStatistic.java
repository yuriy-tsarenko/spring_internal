package com.simple.web.app.util;

import com.simple.web.app.dto.UserWordDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomStatistic {
    private Long id;
    private String word;
    private Integer uniqueLettersCount;
}
