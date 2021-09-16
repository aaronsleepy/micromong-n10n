package org.socurites.micromong.n10n.infrastructure.n10n;

import lombok.extern.slf4j.Slf4j;
import org.socurites.micromong.n10n.domain.n10n.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KakaoNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationCommand command) {
        KakaoNotification notification = KakaoNotification.builder()
                .sender(command.getSender())
                .receiver(command.getReceiver())
                .body(command.getBody())
                .build();

        // TODO: send to SMTP
        log.info(String.format("sendKakao to %s", notification.getReceiver()));
    }

    @Override
    public boolean support(NotificationType type) {
        return NotificationType.KAKAO == type;
    }
}
