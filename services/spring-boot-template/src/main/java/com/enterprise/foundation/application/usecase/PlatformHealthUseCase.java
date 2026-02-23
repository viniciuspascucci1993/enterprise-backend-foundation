package com.enterprise.foundation.application.usecase;

import com.enterprise.foundation.domain.model.PlatformHealthApp;
import com.enterprise.foundation.domain.port.PlatformHealthRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformHealthUseCase {

    private final PlatformHealthRepositoryPort platformHealthRepositoryPort;

    public PlatformHealthUseCase(PlatformHealthRepositoryPort platformHealthRepositoryPort) {
        this.platformHealthRepositoryPort = platformHealthRepositoryPort;
    }

    public PlatformHealthApp create(String serviceName, String status) {

        PlatformHealthApp platformHealthApp =
                new PlatformHealthApp(serviceName, status);

        return platformHealthRepositoryPort.save(platformHealthApp);
    }

    public List<PlatformHealthApp> list() {
        return platformHealthRepositoryPort.findAll();
    }
}
