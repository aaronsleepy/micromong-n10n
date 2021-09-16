package org.socurites.micromong.n10n.domain.n10n;

public interface NotificationService {
    void send(NotificationCommand command);
}
