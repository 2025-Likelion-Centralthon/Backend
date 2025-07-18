package com.example.Centralthon.global.response;

import com.example.Centralthon.global.response.code.BaseResponseCode;
import com.example.Centralthon.global.response.code.SuccessResponseCode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({"inSuccess","timestamp","code","httpStatus","message","data"})
public class SuccessResponse<T> extends BaseResponse {
    private final int httpStatus;
    private final T data;

    @Builder
    public SuccessResponse(T data, BaseResponseCode baseResponseCode) {
        super(true, baseResponseCode.getCode(), baseResponseCode.getMessage());
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    // 201 Created 응답
    public static <T> SuccessResponse<T> created(T data) {
        return new SuccessResponse<>(data, SuccessResponseCode.SUCCESS_CREATED);
    }

    public static <T> SuccessResponse<T> from(T data){
        return new SuccessResponse<>(data, SuccessResponseCode.SUCCESS_OK);
    }

    public static SuccessResponse<?> empty(){
        return new SuccessResponse<>(null, SuccessResponseCode.SUCCESS_OK);
    }

    public static <T> SuccessResponse<T> of(T data, BaseResponseCode baseResponseCode){
        return new SuccessResponse<>(data, baseResponseCode);
    }

    public static <T> SuccessResponse<T> from(BaseResponseCode baseResponseCode){
        return new SuccessResponse<>(null, baseResponseCode);
    }
}
