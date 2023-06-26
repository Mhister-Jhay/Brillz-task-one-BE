package org.jhay.service;

import org.jhay.dto.UserRequest;
import org.jhay.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse validateUserEntries(UserRequest request);

    String validateUserToken(String token, String username);
}
