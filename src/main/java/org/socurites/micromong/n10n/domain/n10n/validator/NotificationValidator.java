package org.socurites.micromong.n10n.domain.n10n.validator;

import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;

public interface NotificationValidator {
    boolean support(NotificationType type);

    boolean validate(NotificationCommand command);
}
