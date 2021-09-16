package org.socurites.micromong.n10n.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AbstractEntity {
    protected LocalDateTime createdAt;

    protected LocalDateTime updateAt;
}
