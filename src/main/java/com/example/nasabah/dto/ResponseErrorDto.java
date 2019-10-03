package com.example.nasabah.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErrorDto {

    private String error;
    private Throwable exception;
}
