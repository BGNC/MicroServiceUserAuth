package com.bgnc.controller;

import com.bgnc.dto.request.LoginResponseDto;
import com.bgnc.dto.request.RegisterRequestDto;
import com.bgnc.entity.Auth;
import com.bgnc.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.bgnc.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;


    /*
    * Register works correctly
    * */
    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register (@RequestBody RegisterRequestDto dto) {
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new RuntimeException("Password does not match");


        return ResponseEntity.ok(authService.register(dto));

    }


    /*
     * Login works correctly
     * */

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login (@RequestBody LoginResponseDto loginResponseDto) {
        return ResponseEntity.ok(authService.login(loginResponseDto));

    }
}
