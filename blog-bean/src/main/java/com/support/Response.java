package com.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName : Response
 * @Author : yq
 * @Date: 2021-07-26
 * @Description :
 */
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private boolean isSuccess = false;

    private String code;

    private String message;

    private String suggestion;

    private T result;

    public static <T> Response<T> create(boolean isSuccess, String code, String message, String suggestion, T t) {
        return new Response<T>().setSuccess(isSuccess).setCode(code).setMessage(message).setSuggestion(suggestion).setResult(t);
    }

    public static <T> Response<T> success() {
        return create(true, CommonResultCode.SUCCESS.getCode(), null, null, null);
    }

    public static <T> Response<T> success(T t) {
        return create(true, CommonResultCode.SUCCESS.getCode(), null, null, t);
    }

    public static <T> Response<T> failed() {
        return create(false, CommonResultCode.ERROR.getCode(), null, null, null);
    }

    public static <T> Response<T> paramError() {
        return create(false, CommonResultCode.PARAM_ERROR.getCode(), CommonResultCode.PARAM_ERROR.getDesc(), null, null);
    }

    public static <T> Response<T> systemError() {
        return create(false, CommonResultCode.SYSTEM_ERROR.getCode(), CommonResultCode.SYSTEM_ERROR.getDesc(), null, null);
    }

    public static <T> Response<T> failed(String message) {
        return create(false, CommonResultCode.ERROR.getCode(), message, null, null);
    }

}
