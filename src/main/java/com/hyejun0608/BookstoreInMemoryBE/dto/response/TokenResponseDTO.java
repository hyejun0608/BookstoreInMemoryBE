package com.hyejun0608.BookstoreInMemoryBE.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TokenResponseDTO {

    private final String accessToken;
}
