package org.jhay.controller;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jhay.dto.ApiResponse;
import org.jhay.dto.UserRequest;
import org.jhay.dto.UserResponse;
import org.jhay.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Validated
@Slf4j
public class UserController {
    private final UserService userService;

    @CrossOrigin(origins = "http://localhost:5175")
    @PostMapping("/validateInputs")
    public ApiResponse<UserResponse> validateUserRequest(@Valid @RequestBody UserRequest request){
        log.info("User request is {}",request);
        return new ApiResponse<>(userService.validateUserEntries(request));
    }

    @CrossOrigin(origins = "http://localhost:5175")
    @GetMapping("/validateToken")
    public ApiResponse<String> validateToken(
            HttpServletRequest request,
            @RequestParam String username) {
        String token = request.getHeader("Authorization");
        return new ApiResponse<>(userService.validateUserToken(token, username));
    }
}
