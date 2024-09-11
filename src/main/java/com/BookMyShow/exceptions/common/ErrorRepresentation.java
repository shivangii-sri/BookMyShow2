package com.BookMyShow.exceptions.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.CollectionUtils.isEmpty;

@EqualsAndHashCode
@Data
@AllArgsConstructor
public class ErrorRepresentation {

    private final ErrorDetail error;

    public ErrorRepresentation(AppException ex,String path,String appName){
        ErrorCode errorCode=ex.getError();

        this.error=new ErrorDetail(errorCode.getCode(),errorCode.getStatus(),
                errorCode.getMessage(),path,appName,ex.getData());
    }


    @EqualsAndHashCode
    @Getter
    public static class ErrorDetail{

        private final String code;

        private final int status;

        private final String message;

        private final String path;

        private final String appName;

        private final Map<String,Object> data=new HashMap<>();

        private Instant timestamp;

        public ErrorDetail(String code, int status, String message, String path,
                         String appName, Map<String,Object> data){
            this.code=code;
            this.status=status;
            this.message=message;
            this.path=path;
            this.timestamp=getTimestamp();
            this.appName=appName;
            if(isEmpty(data)){
                this.data.putAll(data);
            }

        }

        public ErrorDetail(ErrorCode errorCode,String path, String appName, Map<String,Object> data){
            this(errorCode.getCode(),errorCode.getStatus(),errorCode.getMessage(),path,appName,data);
        }

        public ErrorDetail(ErrorCode errorCode,String path, String appName){
            this(errorCode.getCode(),errorCode.getStatus(),errorCode.getMessage(),path,appName,null);
        }

        public ErrorDetail(String code,int status,String message,String path, String appName){
            this(code,status,message,path,appName,null);
        }

        public void setTimestamp(Instant timestamp){
            this.timestamp=timestamp;
        }
    }
}
