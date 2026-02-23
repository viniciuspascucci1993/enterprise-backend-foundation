package com.enterprise.foundation.interfaces.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformHealthRequest {

    private String serviceName;
    private String status;
}
