package com.pivetta.projetohexagonal.adapters.in.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardError {

    private Long timestamp;
    private Integer status;
    private String message;
    private String path;
}
