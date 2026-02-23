package com.enterprise.foundation.application.usecase;

import com.enterprise.foundation.domain.model.PlatformHealthApp;
import com.enterprise.foundation.domain.port.PlatformHealthRepositoryPort;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformHealthUseCase {

    private final PlatformHealthRepositoryPort platformHealthRepositoryPort;
    private final Counter healthCreatedCounter;

    private final Counter getAllCounter;
    private final Counter recordsReturnedCounter;
    private final Timer getAllTimer;

    public PlatformHealthUseCase(PlatformHealthRepositoryPort platformHealthRepositoryPort,
                                 MeterRegistry meterRegistry) {
        this.platformHealthRepositoryPort = platformHealthRepositoryPort;
        this.getAllCounter =
                meterRegistry.counter("platform.health.get_all.total");
        this.recordsReturnedCounter =
                meterRegistry.counter("platform.health.records.returned.total");
        this.getAllTimer =
                meterRegistry.timer("platform.health.get_all.execution.time");
        this.healthCreatedCounter =
                meterRegistry.counter("platform.health.created.total");

    }

    public PlatformHealthApp create(String serviceName, String status) {

        PlatformHealthApp platformHealthApp =
                new PlatformHealthApp(serviceName, status);

        PlatformHealthApp saved =
                platformHealthRepositoryPort.save(platformHealthApp);

        healthCreatedCounter.increment();

        return saved;
    }

    public List<PlatformHealthApp> list() {

        return getAllTimer.record(() -> {
            getAllCounter.increment();

            List<PlatformHealthApp> result = platformHealthRepositoryPort.findAll();
            recordsReturnedCounter.increment(result.size());

            return result;
        });
    }

    public PlatformHealthApp updateStatus(String serviceName, String status) {

        Optional<PlatformHealthApp> existing =
                platformHealthRepositoryPort.findByServiceName(serviceName);

        if (existing.isPresent()) {
            PlatformHealthApp app = existing.get();
            app.setStatus(status);
            return platformHealthRepositoryPort.save(app);
        }

        return platformHealthRepositoryPort
                .save(new PlatformHealthApp(serviceName, status));
    }
}
