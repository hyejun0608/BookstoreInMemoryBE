package com.hyejun0608.BookstoreInMemoryBE.dto.response;

/* 기록 테이블의 구조화 역할을 함 */

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecordResponseDTO {

    /* 번호 (pk) */
    private int id;

    /* 제목 */
    private String title;

    /* 저자 */
    private String author;

    /* 내용 */
    private String content;

    /* 읽은 횟수 */
    private int count;

}
