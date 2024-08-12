package com.bgnc.service;

import com.bgnc.document.UserProfile;
import com.bgnc.dto.request.CreateUserRequestDto;
import com.bgnc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserRepository userRepository;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        userRepository.save(UserProfile.builder().
                authId(createUserRequestDto.getAuthId())
                        .userName(createUserRequestDto.getUsername())
                        .email(createUserRequestDto.getEmail()).
                build());
    }

    public List<UserProfile> getAll() {
        return userRepository.findAll();
    }
}
