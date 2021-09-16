package org.socurites.micromong.n10n.domain.n10n.validator;

import org.socurites.micromong.n10n.common.exception.InvalidParamException;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

@Component
public class EmailReceiverValidator implements NotificationValidator {
    private static final String PATTERN_EMAIL = "^(.+)@(.+)$";
    private Pattern pattern;

    @PostConstruct
    private void init() {
        pattern = Pattern.compile(PATTERN_EMAIL);
    }

    @Override
    public boolean support(NotificationType type) {
        return NotificationType.EMAIL == type;
    }

    @Override
    public boolean validate(NotificationCommand command) {
        return pattern.matcher(command.getReceiver()).matches();
    }
}
