package com.study.atm.vo;

import java.io.Serializable;


/**
 * @author wuliqing
 */
public class OpenResponse<T> implements Serializable {

    /**
     * 返回码 0：成功，其他为错误
     */
    private int code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 正确时返回的数据
     */
    private T data;

    public static final int SUCCESS = 0;


    public boolean isSuccess() {
        return code == 0;
    }


    public static OpenResponse error(int errorCode,String msg){
        OpenResponse openResponse = new OpenResponse();
        openResponse.setCode(errorCode);
        openResponse.setMessage(msg);
        return openResponse;
    }

    public static OpenResponse success(Object data){
        OpenResponse openResponse = new OpenResponse();
        openResponse.setCode(SUCCESS);
        openResponse.setData(data);
        return openResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
