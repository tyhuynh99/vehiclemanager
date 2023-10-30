package com.example.vehiclemanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    private String error;
    private List<String> errors;

    @Builder
    public ErrorResponse(String href, String method, String error, List<String> errors) {
        super(href, method);
        this.error = error;
        this.errors = errors;
    }
}
