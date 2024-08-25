package com.anduckhmt146.todolist.repository;

import com.anduckhmt146.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
