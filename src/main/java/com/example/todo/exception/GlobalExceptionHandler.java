package com.example.todo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@ControllerAdvice
//restcontroller에서 발생되는 예외를 전역적으로 처리할 수 있게 하는 아노테이션
//예외 상황에 따라 응답을 rest 방식으러 클라이언트에게 전달 할수 있다
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({RuntimeException.class, NoRegisteredArgumentException.class})
public ResponseEntity<?> handleRuntimeException(RuntimeException e){
    return ResponseEntity.badRequest().body(e.getMessage());
}

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<?> handleRuntimeException(IllegalAccessException e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleRuntimeException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
