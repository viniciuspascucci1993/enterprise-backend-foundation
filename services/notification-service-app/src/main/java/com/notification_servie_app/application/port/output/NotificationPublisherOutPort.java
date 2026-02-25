package com.notification_servie_app.application.port.output;

import com.notification_servie_app.domain.model.Notification;

public interface NotificationPublisherOutPort {

    void publish(Notification notification);
}
