package io.kimmking.rpcfx.exception;

import io.kimmking.rpcfx.enums.RpcErrorEnum;
import lombok.Getter;

/**
 * @ClassName BaseException
 * @description
 */
public class BaseException extends Exception {

    @Getter
    String errorCode;

    @Getter
    String errorMessage;

    public BaseException() {

    }

    public BaseException(String message) {
        super(message);
        this.errorCode = RpcErrorEnum.FAIL.getCode();
        this.errorMessage = message;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = RpcErrorEnum.FAIL.getCode();
        this.errorMessage = message;
    }

    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(String errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
