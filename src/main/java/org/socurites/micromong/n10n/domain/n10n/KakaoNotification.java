package org.socurites.micromong.n10n.domain.n10n;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.socurites.micromong.n10n.common.exception.InvalidParamException;

@Getter
public class KakaoNotification extends Notification {
    @Builder
    public KakaoNotification(String sender, String receiver, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
    }
}
