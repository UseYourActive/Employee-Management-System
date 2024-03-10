package com.ems.logger_service.persistence.entities;

import com.ems.logger_service.persistence.enums.Type;

import java.time.OffsetDateTime;

public record ChronologyFilter(String email,
                               Type type,
                               OffsetDateTime createdAfter,
                               OffsetDateTime createdBefore,
                               int page,
                               int pageSize) {
}
