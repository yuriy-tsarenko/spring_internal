package com.simple.web.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWordDto {
    private Long id;
    private String word;

    public Map<String, Object> getFieldMap() {
        return Map.of("id", id, "word", word);
    }
}
