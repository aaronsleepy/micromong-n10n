package org.socurites.micromong.n10n.application.n10n;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationFacade {
    private final NotificationService notificationService;

    public void send(NotificationCommand command) {
        notificationService.send(command);

        // TODO: 발송 이력 로깅. 어딘가에
    }
}
