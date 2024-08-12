package com.bgnc.controller;

import com.bgnc.document.UserProfile;
import com.bgnc.dto.request.CreateUserRequestDto;
import com.bgnc.service.UserProfileService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.bgnc.config.RestApis.*;

import java.util.List;

@RestController
@RequestMapping(USERPROFILER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userProfileService.createUser(createUserRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(){
        return ResponseEntity.ok(userProfileService.getAll());
    }
}
