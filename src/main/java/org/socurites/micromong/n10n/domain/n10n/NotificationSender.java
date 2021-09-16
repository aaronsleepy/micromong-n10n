package org.socurites.micromong.n10n.domain.n10n;

public interface NotificationSender {
    void send(NotificationCommand command);

    boolean support(NotificationType type);
}
