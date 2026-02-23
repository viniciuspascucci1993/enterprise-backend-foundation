package com.enterprise.foundation.infrastructure.persistence.repository;

import com.enterprise.foundation.infrastructure.persistence.entity.PlatformHealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPlatformHealthRepository extends JpaRepository<PlatformHealthEntity, Long> { }
