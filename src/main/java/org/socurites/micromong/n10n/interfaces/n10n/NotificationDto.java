package org.socurites.micromong.n10n.interfaces.n10n;

import lombok.Builder;
import lombok.Getter;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;

import javax.validation.constraints.NotEmpty;

public class NotificationDto {
    @Builder
    @Getter
    public static class SendRequest {
        @NotEmpty(message = "type is required")
        private String type;

        @NotEmpty(message = "sender is required")
        private String sender;

        @NotEmpty(message = "receiver is required")
        private String receiver;

        @NotEmpty(message = "body is required")
        private String body;

        private String title;

        public NotificationCommand toCommand() {
            return NotificationCommand.builder()
                    .type(NotificationType.valueOf(type.toUpperCase()))
                    .sender(sender)
                    .receiver(receiver)
                    .body(body)
                    .title(title)
                    .build();
        }
    }
}
