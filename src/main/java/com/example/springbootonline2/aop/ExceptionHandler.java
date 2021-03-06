package com.example.springbootonline2.aop;

import com.example.springbootonline2.exception.UnprocessableException;
import com.example.springbootonline2.model.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UnprocessableException.class)
    @ResponseBody
   public ResponseEntity handleUnprocessableException(UnprocessableException e) {
       MessageInfo messageInfo = new MessageInfo();
       messageInfo.setMessage(e.getMessage());
       messageInfo.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());

       return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
               .body(messageInfo);
    }

}
