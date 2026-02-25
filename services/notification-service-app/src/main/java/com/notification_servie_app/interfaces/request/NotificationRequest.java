package com.notification_servie_app.interfaces.request;

import com.notification_servie_app.domain.enums.NotificationTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    @NotNull
    private NotificationTypeEnum type;

    @NotBlank
    @Size(max = 2500)
    private String message;
}
