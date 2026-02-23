package com.enterprise.foundation.interfaces.listener;

import com.enterprise.foundation.application.usecase.PlatformHealthUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PlatformHealthStartupListener {

    private final PlatformHealthUseCase platformHealthUseCase;
    private final HealthEndpoint healthEndpoint;

    public PlatformHealthStartupListener(PlatformHealthUseCase platformHealthUseCase,
                                         HealthEndpoint healthEndpoint) {
        this.platformHealthUseCase = platformHealthUseCase;
        this.healthEndpoint = healthEndpoint;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void registerOnStartup() {

        var health = healthEndpoint.health();

        String status = health.getStatus().getCode();

        platformHealthUseCase.create("foundation-app", status);

        log.info("Application registered as: {}", status);

    }

    @Scheduled(fixedRate = 30000)
    public void monitorHealth() {
        var health = healthEndpoint.health();
        platformHealthUseCase.updateStatus("foundation-app", health.getStatus().getCode());
    }
}
