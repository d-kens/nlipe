package com.peid.api.common.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
public class PaginationRequest {
    private Integer page;
    private Integer size;
    private String sortField;
    private Sort.Direction direction;
}