package org.socurites.micromong.n10n.domain.n10n.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.socurites.micromong.n10n.domain.n10n.NotificationCommand;
import org.socurites.micromong.n10n.domain.n10n.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmailReceiverValidatorTests {
    @Autowired
    private EmailReceiverValidator receiverValidator;

    @Test
    public void isValidEmail() {
        final String receiver = "you@hotmail.com";

        NotificationCommand command = NotificationCommand.builder()
                .type(NotificationType.EMAIL)
                .sender("kmong-official@kmong.com")
                .receiver(receiver)
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        assertThat(receiverValidator.validate(command)).isTrue();
    }

    @Test
    public void isNotValidEmail() {
        final String receiver = "010-111-1234";

        NotificationCommand command = NotificationCommand.builder()
                .type(NotificationType.EMAIL)
                .sender("kmong-official@kmong.com")
                .receiver(receiver)
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        assertThat(receiverValidator.validate(command)).isFalse();
    }

    @Test
    public void supportsOnlySuccess() {
        final NotificationType supportedType = NotificationType.EMAIL;

        NotificationCommand command = NotificationCommand.builder()
                .type(supportedType)
                .sender("kmong-official@kmong.com")
                .receiver("you@hotmail.com")
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        assertThat(receiverValidator.support(command.getType())).isTrue();
    }

    @Test
    public void supportsOnlyFail() {
        final NotificationType notSupportedType = NotificationType.SMS;

        NotificationCommand command = NotificationCommand.builder()
                .type(notSupportedType)
                .sender("kmong-official@kmong.com")
                .receiver("you@hotmail.com")
                .body("Thank you for joining kmong...")
                .title("You got email")
                .build();

        assertThat(receiverValidator.support(command.getType())).isFalse();
    }
}
