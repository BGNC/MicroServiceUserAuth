package com.bgnc.service;

import com.bgnc.dto.request.CreateUserRequestDto;
import com.bgnc.dto.request.LoginResponseDto;
import com.bgnc.dto.request.RegisterRequestDto;
import com.bgnc.entity.Auth;
import com.bgnc.manager.UserProfileManager;
import com.bgnc.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;


    public Auth register(RegisterRequestDto dto) {
        Auth auth = authRepository.save(Auth.builder().
                userName(dto.getUserName()).
                email(dto.getEmail()).
                password(dto.getPassword()).
                build());

        userProfileManager.createUser(CreateUserRequestDto.builder().
                        authId(auth.getId()).
                        email(auth.getEmail()).
                        email(auth.getEmail()).
                build());

        return auth;

    }

    public Boolean login(LoginResponseDto loginResponseDto) {
        return authRepository.
                existsByUserNameAndPassword(loginResponseDto.getUserName(),
                        loginResponseDto.getPassword());

    }
}
