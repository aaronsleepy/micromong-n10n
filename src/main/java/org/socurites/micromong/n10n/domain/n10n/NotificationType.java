package org.socurites.micromong.n10n.domain.n10n;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NotificationType {
    EMAIL("EMAIL"),
    KAKAO("KAKAO"),
    SMS("SMS")
    ;

    private final String type;
}
