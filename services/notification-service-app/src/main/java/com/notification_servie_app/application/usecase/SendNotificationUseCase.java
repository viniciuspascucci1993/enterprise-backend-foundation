package com.notification_servie_app.application.usecase;

import com.notification_servie_app.application.port.input.SendNotificationInputPort;
import com.notification_servie_app.application.port.output.NotificationPublisherOutPort;
import com.notification_servie_app.domain.model.Notification;

public class SendNotificationUseCase implements SendNotificationInputPort {

    private final NotificationPublisherOutPort notificationPublisherOutPort;

    public SendNotificationUseCase(NotificationPublisherOutPort notificationPublisherOutPort) {
        this.notificationPublisherOutPort = notificationPublisherOutPort;
    }

    @Override
    public void send(Notification notification) {
        notificationPublisherOutPort.publish(notification);
    }
}
