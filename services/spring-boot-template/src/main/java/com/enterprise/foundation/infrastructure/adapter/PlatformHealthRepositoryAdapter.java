package com.enterprise.foundation.infrastructure.adapter;

import com.enterprise.foundation.domain.model.PlatformHealthApp;
import com.enterprise.foundation.domain.port.PlatformHealthRepositoryPort;
import com.enterprise.foundation.infrastructure.persistence.entity.PlatformHealthEntity;
import com.enterprise.foundation.infrastructure.persistence.repository.JpaPlatformHealthRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlatformHealthRepositoryAdapter implements PlatformHealthRepositoryPort {

    private final JpaPlatformHealthRepository jpaPlatformHealthRepository;

    public PlatformHealthRepositoryAdapter(JpaPlatformHealthRepository jpaPlatformHealthRepository) {
        this.jpaPlatformHealthRepository = jpaPlatformHealthRepository;
    }

    @Override
    public PlatformHealthApp save(PlatformHealthApp health) {
        PlatformHealthEntity entity = new PlatformHealthEntity();
        entity.setServiceName(health.getServiceName());
        entity.setStatus(health.getStatus());
        entity.setCreatedAt(health.getCreatedAt());

        PlatformHealthEntity saved = jpaPlatformHealthRepository.save(entity);

        return new PlatformHealthApp(
                saved.getId(),
                saved.getServiceName(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }

    @Override
    public List<PlatformHealthApp> findAll() {
        return jpaPlatformHealthRepository.findAll()
                .stream()
                .map(e -> new PlatformHealthApp(
                        e.getId(),
                        e.getServiceName(),
                        e.getStatus(),
                        e.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlatformHealthApp> findByServiceName(String serviceName) {
        return jpaPlatformHealthRepository
                .findByServiceName(serviceName)
                .map(entity -> new PlatformHealthApp(
                        entity.getId(),
                        entity.getServiceName(),
                        entity.getStatus(),
                        entity.getCreatedAt()
                ));
    }
}
