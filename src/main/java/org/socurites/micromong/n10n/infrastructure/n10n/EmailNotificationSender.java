package org.socurites.micromong.n10n.infrastructure.n10n;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socurites.micromong.n10n.domain.n10n.EmailNotification;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationSender;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;
import org.socurites.micromong.n10n.domain.n10n.validator.NotificationValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EmailNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationCommand command) {
        EmailNotification notification = EmailNotification.builder()
                .sender(command.getSender())
                .receiver(command.getReceiver())
                .body(command.getBody())
                .title(command.getTitle())
                .build();

        // TODO: send to SMTP
        log.info(String.format("sendEmail to %s", notification.getReceiver()));
    }

    @Override
    public boolean support(NotificationType type) {
        return NotificationType.EMAIL == type;
    }
}
