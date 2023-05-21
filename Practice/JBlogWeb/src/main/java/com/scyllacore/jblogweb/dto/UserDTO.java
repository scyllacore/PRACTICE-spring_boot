package com.scyllacore.jblogweb.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull(message = "username이 전달되지 않았습니다.")
    @NotBlank(message = "username을 입력해주세요")
    @Size(min = 1, max = 20, message = "username을 1~20글자 사이로 입력해주세요.")
    private String userName;

    @NotNull(message = "password가 전달되지 않았습니다.")
    @NotBlank(message = "password를 입력해주세요")
    @Size(min = 8, max = 30, message = "password 8~30자 사이로 입력해주세요.")
    private String password;

    @NotNull(message = "email이 전달되지 않았습니다.")
    @NotBlank(message = "email을 입력해주세요")
    @Email(message = "email형식이 잘못되었습니다.")
    private String email;
}
