package com.scyllacore.jblogweb.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder; // import 순서 맞출 것. 컨벤션에 따라 코드를 적는 순서에 맞췄다


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
}
