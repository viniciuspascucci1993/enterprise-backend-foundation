package com.enterprise.foundation.interfaces.rest;

import com.enterprise.foundation.application.usecase.PlatformHealthUseCase;
import com.enterprise.foundation.interfaces.request.PlatformHealthRequest;
import com.enterprise.foundation.interfaces.response.PlatformHealthResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/platform-health-check")
public class PlatformHealthController {

    private final PlatformHealthUseCase platformHealthUseCase;

    public PlatformHealthController(PlatformHealthUseCase platformHealthUseCase) {
        this.platformHealthUseCase = platformHealthUseCase;
    }

    @PostMapping
    public PlatformHealthResponse create(@RequestBody PlatformHealthRequest request) {
        var domain = platformHealthUseCase.create(
                request.getServiceName(),
                request.getStatus()
        );

        return new PlatformHealthResponse(
                domain.getId(),
                domain.getServiceName(),
                domain.getStatus(),
                domain.getCreatedAt()
        );
    }

    @GetMapping
    public List<PlatformHealthResponse> list() {

        return platformHealthUseCase.list()
                .stream()
                .map(domain -> new PlatformHealthResponse(
                        domain.getId(),
                        domain.getServiceName(),
                        domain.getStatus(),
                        domain.getCreatedAt()
                ))
                .toList();
    }
}
