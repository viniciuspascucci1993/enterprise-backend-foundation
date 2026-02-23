package com.enterprise.foundation.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_platform_health_app")
public class PlatformHealthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SERVICE_NAME_APP")
    private String serviceName;
    private String status;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    public PlatformHealthEntity() { }

    public PlatformHealthEntity(Long id, String serviceName, String status, OffsetDateTime createdAt) {
        this.id = id;
        this.serviceName = serviceName;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
