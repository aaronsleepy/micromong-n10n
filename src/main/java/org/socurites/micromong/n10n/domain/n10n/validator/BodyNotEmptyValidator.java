package org.socurites.micromong.n10n.domain.n10n.validator;

import org.apache.commons.lang3.StringUtils;
import org.socurites.micromong.n10n.common.exception.InvalidParamException;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;
import org.springframework.stereotype.Component;

@Component
public class BodyNotEmptyValidator implements NotificationValidator {

    @Override
    public boolean support(NotificationType type) {
        return true;
    }

    @Override
    public boolean validate(NotificationCommand command) {
        return StringUtils.isNotEmpty(command.getBody());
    }
}
