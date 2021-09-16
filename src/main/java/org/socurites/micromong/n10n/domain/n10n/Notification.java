package org.socurites.micromong.n10n.domain.n10n;

import lombok.Getter;
import org.socurites.micromong.n10n.domain.AbstractEntity;

@Getter
public abstract class Notification extends AbstractEntity {
    protected String sender;
    protected String receiver;
    protected String body;
}
