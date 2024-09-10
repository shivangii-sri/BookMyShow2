package com.BookMyShow.exceptions.errorCodes;

import com.BookMyShow.exceptions.common.ErrorCode;

public enum CommonErrorCode implements ErrorCode {
    RECORD_NOT_FOUND(404,"Record not found");

    private final int status;

    private String message;


    CommonErrorCode(int status,String message){
        this.status=status;
        this.message=message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
