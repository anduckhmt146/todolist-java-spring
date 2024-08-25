package com.zalopay.todolist.controller;

import com.zalopay.todolist.dto.ApiResponse;
import com.zalopay.todolist.model.Todo;
import com.zalopay.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ApiResponse<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ApiResponse<>(HttpStatus.OK.value(), todos, null);
    }

    @GetMapping("/{id}")
    public ApiResponse<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (todo.isPresent()) {
            return new ApiResponse<>(HttpStatus.OK.value(), todo.get(), null);
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), null, "Todo not found");
        }
    }

    @PostMapping
    public ApiResponse<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return new ApiResponse<>(HttpStatus.CREATED.value(), createdTodo, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        return new ApiResponse<>(HttpStatus.OK.value(), updatedTodo, null);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), null, null);
    }
}
