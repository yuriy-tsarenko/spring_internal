package com.simple.web.app.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomResponseBody {
    private String type;
    private String status;
    private String data;
}
