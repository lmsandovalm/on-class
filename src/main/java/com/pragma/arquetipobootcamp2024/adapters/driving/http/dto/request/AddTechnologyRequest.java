package com.pragma.arquetipobootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddTechnologyRequest {
    private final String name;
    private final String description;
}
