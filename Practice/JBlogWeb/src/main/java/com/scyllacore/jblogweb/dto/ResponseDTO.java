package com.scyllacore.jblogweb.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO<T> {
    private int status;

    private T data;
}
