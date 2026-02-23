package com.enterprise.foundation.domain.port;

import com.enterprise.foundation.domain.model.PlatformHealthApp;

import java.util.List;

public interface PlatformHealthRepositoryPort {

    PlatformHealthApp save(PlatformHealthApp health);

    List<PlatformHealthApp> findAll();
}
