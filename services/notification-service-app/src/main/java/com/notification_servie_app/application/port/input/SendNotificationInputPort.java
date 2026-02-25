package com.notification_servie_app.application.port.input;

import com.notification_servie_app.domain.model.Notification;

public interface SendNotificationInputPort {

    void send(Notification notification);
}
