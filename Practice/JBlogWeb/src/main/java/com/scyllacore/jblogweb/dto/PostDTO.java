package com.scyllacore.jblogweb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @NotNull(message = "Title을 전달받지 못했습니다.")
    @NotBlank(message = "제목을 채워주세요.")
    private String title;

    @NotNull(message = "Content를 전달받지 못했습니다.")
    @NotBlank(message = "내용을 채워주세요.")
    private String content;
}
