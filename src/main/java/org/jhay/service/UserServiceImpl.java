package org.jhay.service;

import lombok.RequiredArgsConstructor;
import org.jhay.dto.UserRequest;
import org.jhay.dto.UserResponse;
import org.jhay.jwt.JwtAuthenticationService;
import org.jhay.model.User;
import org.jhay.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtAuthenticationService authService;

    @Override
    public UserResponse validateUserEntries(UserRequest request){
        User user = userRepository.save(User.builder()
                        .username(request.getUsername())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .dateOfBirth(request.getDateOfBirth())
                        .build());
        String token = authService.generateToken(user.getUsername());
        return UserResponse.builder()
                .accessToken(token)
                .username(user.getUsername())
                .build();
    }
    @Override
    public String validateUserToken(String token, String username){
        if(authService.isTokenValid(token,username)){
            return "verification pass";
        }else{
            return "verification fails";
        }
    }
}
