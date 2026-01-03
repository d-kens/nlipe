package com.peid.common.utils;

import com.peid.common.dto.PaginationRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtils {
    public static Pageable getPageable(PaginationRequest request) {

        int page = (request.getPage() != null && request.getPage() > 0) ? request.getPage() - 1 : 0;

        return PageRequest.of(
                page,
                request.getSize(),
                request.getDirection(),
                request.getSortField()
        );
    }
}