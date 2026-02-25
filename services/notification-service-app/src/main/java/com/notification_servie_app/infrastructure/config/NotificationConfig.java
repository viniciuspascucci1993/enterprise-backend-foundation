package com.notification_servie_app.infrastructure.config;

import com.notification_servie_app.application.port.input.SendNotificationInputPort;
import com.notification_servie_app.application.port.output.NotificationPublisherOutPort;
import com.notification_servie_app.application.usecase.SendNotificationUseCase;
import com.notification_servie_app.interfaces.mapper.NotificationMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public SendNotificationInputPort sendNotificationInputPort(
            NotificationPublisherOutPort notificationPublisherOutPort) {
        return new SendNotificationUseCase(notificationPublisherOutPort);
    }

    @Bean
    public NotificationMapper notificationMapper() {
        return new NotificationMapper();
    }
}
