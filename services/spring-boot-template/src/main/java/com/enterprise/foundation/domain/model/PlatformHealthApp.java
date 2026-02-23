package com.enterprise.foundation.domain.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

public class PlatformHealthApp {

    private Long id;
    private String serviceName;
    private String status;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public PlatformHealthApp() { }

    public PlatformHealthApp(String serviceName,
                             String status) {
        this.serviceName = serviceName;
        this.status = status;
    }

    public PlatformHealthApp(Long id,
                          String serviceName,
                          String status,
                          OffsetDateTime createdAt) {
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
