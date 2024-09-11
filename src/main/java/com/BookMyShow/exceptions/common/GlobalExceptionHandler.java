package com.BookMyShow.exceptions.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@ControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler {

    private final Environment environment;

    @Autowired
    public GlobalExceptionHandler(Environment environment){
        this.environment=environment;
    }

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorRepresentation> handleAppException(AppException ex,
                                                                  HttpServletRequest request){

        ErrorRepresentation errorRepresentation=createErrorRepresentation(ex,request);
        return new ResponseEntity<>(errorRepresentation, HttpStatusCode.valueOf(ex.getError().getStatus()));

    }

    public ErrorRepresentation createErrorRepresentation(AppException ex,
                                                         HttpServletRequest request){
        return createErrorRepresentation(ex,request.getRequestURI());
    }

    public ErrorRepresentation createErrorRepresentation(AppException ex,
                                                         String uri){
        return new ErrorRepresentation(new ErrorRepresentation.ErrorDetail(ex.getError(),uri,appName(),ex.getData()));
    }

    protected String appName(){
        String[] activeProfiles=environment.getActiveProfiles();
        if(!Arrays.asList(activeProfiles).contains("prod")){
            return environment.getProperty("spring.application.name");
        }
        return null;
    }
}
