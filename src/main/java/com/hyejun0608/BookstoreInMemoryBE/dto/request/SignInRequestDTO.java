package com.hyejun0608.BookstoreInMemoryBE.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInRequestDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
