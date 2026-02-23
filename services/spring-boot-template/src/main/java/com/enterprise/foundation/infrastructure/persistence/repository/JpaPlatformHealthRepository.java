package com.enterprise.foundation.infrastructure.persistence.repository;

import com.enterprise.foundation.domain.model.PlatformHealthApp;
import com.enterprise.foundation.infrastructure.persistence.entity.PlatformHealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPlatformHealthRepository extends JpaRepository<PlatformHealthEntity, Long> {

    Optional<PlatformHealthApp> findByServiceName(String serviceName);
}
