package org.socurites.micromong.n10n.domain.n10n;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EmailNotification extends Notification {
    private String title;

    @Builder
    public EmailNotification(String sender, String receiver, String body, String title) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
        this.title = title;
    }
}
