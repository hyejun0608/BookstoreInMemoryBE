package com.hyejun0608.BookstoreInMemoryBE.service;

import com.hyejun0608.BookstoreInMemoryBE.dto.request.SignInRequestDTO;
import com.hyejun0608.BookstoreInMemoryBE.dto.response.TokenResponseDTO;
import com.hyejun0608.BookstoreInMemoryBE.entity.User;
import com.hyejun0608.BookstoreInMemoryBE.entity.UserRepository;
import com.hyejun0608.BookstoreInMemoryBE.exception.PasswordNotMatchedException;
import com.hyejun0608.BookstoreInMemoryBE.exception.UserNotAccessibleException;
import com.hyejun0608.BookstoreInMemoryBE.exception.UserNotAuthenticatedException;
import com.hyejun0608.BookstoreInMemoryBE.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder encoder;

    @Component
    public class AuthenticationFacade {

        public String getUserId() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null) {
                throw UserNotAuthenticatedException.EXCEPTION;
            }
            return authentication.getName();
        }
    }

    public TokenResponseDTO login(SignInRequestDTO request) {
        User user = userRepository.findById(request.getId());

        if(!encoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchedException.EXCEPTION;
        }

        return TokenResponseDTO.builder()
                .accessToken(jwtTokenProvider.getAccessToken(user.getId()))
                .build();

    }

    public void logout() {
        User user = userRepository.findById(AuthenticationFacade.getUserId())
                .orElseThrow(() -> UserNotAccessibleException.EXCEPTION);
    }
}
