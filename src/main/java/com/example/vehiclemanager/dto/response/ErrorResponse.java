package com.example.vehiclemanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    private String error;

    @Builder
    public ErrorResponse(String href, String method, String error) {
        super(href, method);
        this.error = error;
    }
}
