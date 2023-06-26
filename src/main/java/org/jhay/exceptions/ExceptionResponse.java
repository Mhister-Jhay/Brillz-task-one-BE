package org.jhay.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExceptionResponse {
    private String message;
    private Integer statusCode;
    private String requestPath;
    private LocalDate errorTime;
}
