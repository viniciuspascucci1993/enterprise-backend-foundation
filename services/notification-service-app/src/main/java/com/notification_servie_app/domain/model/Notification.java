package com.notification_servie_app.domain.model;

import com.notification_servie_app.domain.enums.NotificationTypeEnum;
import com.notification_servie_app.domain.exception.DomainException;

public class Notification {

    private NotificationTypeEnum type;
    private String message;

    public Notification() { }

    public Notification(NotificationTypeEnum type, String message) {

        if (type == null) {
            throw new DomainException("Notification type must not be empty");
        }

        if (message == null || message.isBlank()) {
            throw new DomainException("Notification message must not be empty");
        }

        if (message.length() > 2500) {
            throw new DomainException("Notification message exceeds maximum length");
        }

        this.type = type;
        this.message = message;
    }


    public NotificationTypeEnum getType() {
        return type;
    }

    public void setType(NotificationTypeEnum type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
