package com.notification_servie_app.interfaces.mapper;

import com.notification_servie_app.domain.model.Notification;
import com.notification_servie_app.interfaces.request.NotificationRequest;
import com.notification_servie_app.interfaces.response.NotificationResponse;

public class NotificationMapper {

    public Notification toDomain(NotificationRequest request) {

        return new Notification(
                request.getType(),
                request.getMessage()
        );
    }

    public NotificationResponse toResponse(Notification notification) {

        return new NotificationResponse(
                notification.getType().name(),
                notification.getMessage()
        );
    }
}
