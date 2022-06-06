package com.hyejun0608.BookstoreInMemoryBE.dto.request;

/* 기록 테이블의 구조화 역할을 함 */

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RecordRequestDTO {

    /* 제목 */
    @NotBlank
    private String title;

    /* 저자 */
    @NotBlank
    private String author;

    /* 내용 */
    @NotBlank
    private String content;

    /* 읽은 횟수 */
    @NotNull
    @Positive
    private int count;
}
