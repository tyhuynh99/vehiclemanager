package com.example.vehiclemanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> extends BaseResponse {
    private int count;
    private List<T> items;

    @Builder
    public ListResponse(String href, String method, int count, List<T> items) {
        super(href, method);
        this.count = count;
        this.items = items;
    }
}
