package com.enterprise.foundation.domain.port;

import com.enterprise.foundation.domain.model.PlatformHealthApp;

import java.util.List;
import java.util.Optional;

public interface PlatformHealthRepositoryPort {

    PlatformHealthApp save(PlatformHealthApp health);

    List<PlatformHealthApp> findAll();

    Optional<PlatformHealthApp> findByServiceName(String serviceName);
}
