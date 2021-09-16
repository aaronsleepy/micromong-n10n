package org.socurites.micromong.n10n.domain.n10n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.socurites.micromong.n10n.common.exception.InvalidParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NotificationServiceImplTests {
    @Autowired
    private NotificationServiceImpl notificationService;

    @Test
    public void sendEmailSuccess() {
        final NotificationType supportedType = NotificationType.EMAIL;
        final String receiver = "you@hotmail.com";

        NotificationCommand command = NotificationCommand.builder()
                .type(supportedType)
                .sender("kmong-official@kmong.com")
                .receiver(receiver)
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        notificationService.send(command);
    }

    @Test
    public void sendEmailFailsBecauseBodyIsEmpty() {
        final NotificationType supportedType = NotificationType.EMAIL;
        final String receiver = "you@hotmail.com";
        final String nullBody = null;

        NotificationCommand command = NotificationCommand.builder()
                .type(supportedType)
                .sender("kmong-official@kmong.com")
                .receiver(receiver)
                .body(nullBody)
                .title("You got email")
                .build();

        assertThatExceptionOfType(InvalidParamException.class)
                .isThrownBy(() -> {
                    notificationService.send(command);
                });
    }
}
