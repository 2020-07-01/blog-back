package com.support;

/**
 * @ClassName : CommonResultCode
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
public enum CommonResultCode implements ResultCode {
    /**
     *
     */
    SUCCESS("000", "操作成功!"),
    SYSTEM_ERROR("999", "系统错误");

    private final String code;

    private final String desc;

    CommonResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
