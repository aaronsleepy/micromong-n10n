package org.socurites.micromong.n10n.domain.n10n;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class NotificationCommand {
    private NotificationType type;
    private String sender;
    private String receiver;
    private String body;
    private String title;
}
