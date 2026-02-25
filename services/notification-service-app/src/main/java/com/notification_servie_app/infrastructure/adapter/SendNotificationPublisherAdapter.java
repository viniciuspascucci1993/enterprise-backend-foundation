package com.notification_servie_app.infrastructure.adapter;

import com.notification_servie_app.application.port.output.NotificationPublisherOutPort;
import com.notification_servie_app.domain.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendNotificationPublisherAdapter implements NotificationPublisherOutPort {
    @Override
    public void publish(Notification notification) {

        log.info("[SendNotificationPublisherAdapter] - Publishing notification | type={} | message={}",
                notification.getType(), notification.getMessage());
    }
}
