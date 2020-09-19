package com.hyunji.study.model;

import com.hyunji.study.utils.ResponseMessage;
import com.hyunji.study.utils.StatusCode;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Data
@AllArgsConstructor
@Builder
public class DefaultResponse<T> {

    private int statusCode;
    private String responseMessage;
    private T data;

    public DefaultResponse(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> DefaultResponse<T> res(final int statusCode, final String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    public static<T> DefaultResponse<T> res(final int statusCode, final String responseMessage, final T t) {
        return DefaultResponse.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }

    public static final DefaultResponse FAIL_DEFAULT_RES = new DefaultResponse(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);
}
