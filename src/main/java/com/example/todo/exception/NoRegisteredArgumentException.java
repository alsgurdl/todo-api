package com.example.todo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoRegisteredArgumentException extends RuntimeException{
//기본생성자와 에러메세지를 받는 생성자


    public NoRegisteredArgumentException(String message) {
        super(message);
    }
}
