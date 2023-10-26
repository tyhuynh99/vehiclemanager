package com.example.vehiclemanager.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ListResponse<T> {
    private String href;
    private int count;
    private List<T> items;
}
