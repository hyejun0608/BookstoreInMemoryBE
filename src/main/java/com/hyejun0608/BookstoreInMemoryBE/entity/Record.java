package com.hyejun0608.BookstoreInMemoryBE.entity;

/* 테이블과 매핑되는 테이블 구조화 클래스 */

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Record {

    /* 번호 (pk) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    /* 제목 */
    @Column(nullable = false)
    private String title;

    /* 저자 */
    @Column(nullable = false)
    private String author;

    /* 내용 */
    @Column(nullable = false)
    private String content;

    /* 읽은 횟수 */
    @Column(nullable = false)
    private int count;

    /* 유저 id (fk) */
    @Column(nullable = false)
    private int user_userId;

    @Builder
    public  Record(int id, String title, String author, String content, int count, int user_userId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.count = count;
        this.user_userId = user_userId;
    }
}
