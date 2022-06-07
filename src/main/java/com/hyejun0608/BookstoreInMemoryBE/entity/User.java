package com.hyejun0608.BookstoreInMemoryBE.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String id;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;

    @Builder
    public User(int userId, String id, String password, String name) {
        this.userId = userId;
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
