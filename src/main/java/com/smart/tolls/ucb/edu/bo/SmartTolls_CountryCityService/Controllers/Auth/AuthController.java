package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers.Auth;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.config.AuthService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.dto.AuthResponseDto;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.dto.LoginDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){

        //01 - Receive the token from AuthService
        String token = authService.login(loginDto);

        //02 - Set the token as a response using JwtAuthResponse Dto class
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        //03 - Return the response to the user
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }

}
