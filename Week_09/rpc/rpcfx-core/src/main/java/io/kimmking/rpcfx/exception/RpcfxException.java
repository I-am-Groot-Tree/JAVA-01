package io.kimmking.rpcfx.exception;

/**
 * Rpc异常类
 * @author shuren.shi
 */
public class RpcfxException extends BaseException {


    public RpcfxException() {
    }

    public RpcfxException(String message) {
        super(message);
    }

    public RpcfxException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcfxException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public RpcfxException(String errorCode, String errorMessage, Throwable cause) {
        super(errorCode, errorMessage, cause);
    }
}
