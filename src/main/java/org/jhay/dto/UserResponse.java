package org.jhay.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String accessToken;
    private String username;
}
