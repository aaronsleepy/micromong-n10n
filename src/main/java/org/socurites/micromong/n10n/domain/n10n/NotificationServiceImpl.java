package org.socurites.micromong.n10n.domain.n10n;

import lombok.RequiredArgsConstructor;
import org.socurites.micromong.n10n.common.exception.InvalidParamException;
import org.socurites.micromong.n10n.domain.n10n.validator.NotificationValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final List<NotificationSender> notificationSenders;
    private final List<NotificationValidator> validators;

    @Override
    public void send(NotificationCommand command) {
        if (false == isValid(command)) {
            throw new InvalidParamException("Not valid notification request");
        }

        NotificationSender notificationSender = routingSender(command);

        notificationSender.send(command);
    }

    private boolean isValid(NotificationCommand command) {
        return validators.stream()
                .filter(notificationValidator -> notificationValidator.support(command.getType()))
                .allMatch(notificationValidator -> notificationValidator.validate(command));
    }

    private NotificationSender routingSender(NotificationCommand command) {
        return notificationSenders.stream()
                .filter(notificationSender -> notificationSender.support(command.getType()))
                .findFirst()
                .orElseThrow(InvalidParamException::new);
    }
}
