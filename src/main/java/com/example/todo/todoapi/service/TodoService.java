package com.example.todo.todoapi.service;

import com.example.todo.todoapi.dto.TodoCreateRequestDTO;
import com.example.todo.todoapi.repository.TodoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter

public class TodoService {
    private final TodoRepository todoRepository;
    public static void create(TodoCreateRequestDTO requestDTO) {

    }
}
