package com.enterprise.foundation.interfaces.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformHealthResponse {

    private Long id;
    private String serviceName;
    private String status;
    private OffsetDateTime createdAt;
}
