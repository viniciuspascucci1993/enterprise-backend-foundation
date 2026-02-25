package com.notification_servie_app.interfaces.rest;

import com.notification_servie_app.application.port.input.SendNotificationInputPort;
import com.notification_servie_app.domain.model.Notification;
import com.notification_servie_app.interfaces.mapper.NotificationMapper;
import com.notification_servie_app.interfaces.request.NotificationRequest;
import com.notification_servie_app.interfaces.response.NotificationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final SendNotificationInputPort sendNotificationInputPort;
    private final NotificationMapper mapper;

    public NotificationController(SendNotificationInputPort sendNotificationInputPort,
                                  NotificationMapper mapper) {
        this.sendNotificationInputPort = sendNotificationInputPort;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> sendMessage(@Valid @RequestBody NotificationRequest request) {

        Notification domain = mapper.toDomain(request);

        sendNotificationInputPort.send(domain);

        return ResponseEntity.ok(
                mapper.toResponse(domain)
        );
    }
}
