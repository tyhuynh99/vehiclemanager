package com.example.vehiclemanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectResponse<T> extends BaseResponse {
    private T data;

    @Builder
    public ObjectResponse(String href, String method, T data) {
        super(href, method);
        this.data = data;
    }
}
