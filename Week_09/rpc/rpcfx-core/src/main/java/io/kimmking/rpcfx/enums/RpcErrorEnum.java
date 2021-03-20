package io.kimmking.rpcfx.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName RpcErrorEnum
 * @description Rpc异常枚举类
 */
public enum RpcErrorEnum {
    OK("200", "服务调用成功"),
    FAIL("7001", "系统内部错误");

    @Getter
    @Setter
    String code;

    @Getter
    @Setter
    String message;

    RpcErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
