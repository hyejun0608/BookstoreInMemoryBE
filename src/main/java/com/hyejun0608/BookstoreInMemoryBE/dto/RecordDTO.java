package com.hyejun0608.BookstoreInMemoryBE.dto;

import lombok.Getter;

@Getter
public class RecordDTO {
    private int id; // 번호 (pk)
    private String title; // 제목
    private String author; // 저자
    private String content; // 내용
    private int count; // 읽은 횟수
    private int user_userId; // 유저 id (fk)
}
