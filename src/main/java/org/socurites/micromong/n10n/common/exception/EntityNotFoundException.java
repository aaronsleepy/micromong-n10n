package org.socurites.micromong.n10n.common.exception;


import org.socurites.micromong.n10n.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException() {
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }

    public EntityNotFoundException(String message) {
        super(ErrorCode.COMMON_INVALID_PARAMETER, message);
    }
}
