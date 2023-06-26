package org.jhay.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ApiResponse <T>{
    private T data;
    private String message;
    private LocalDate time;

    public ApiResponse(T data){
        this.data = data;
        this.message = "Request Processed Successfully";
        this.time = LocalDate.now();
    }

}
