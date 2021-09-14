package org.socurites.micromong.n10n.common.exception;


import org.socurites.micromong.n10n.common.response.ErrorCode;

public class IllegalStatusException extends BaseException {

    public IllegalStatusException() {
        super(ErrorCode.COMMON_ILLEGAL_STATUS);
    }

    public IllegalStatusException(String message) {
        super(ErrorCode.COMMON_ILLEGAL_STATUS, message);
    }
}
