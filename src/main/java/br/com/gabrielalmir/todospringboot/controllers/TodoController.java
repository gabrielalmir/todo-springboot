package br.com.gabrielalmir.todospringboot.controllers;

import br.com.gabrielalmir.todospringboot.dtos.CreateTodoDto;
import br.com.gabrielalmir.todospringboot.dtos.TodoDto;
import br.com.gabrielalmir.todospringboot.dtos.UpdateTodoDto;
import br.com.gabrielalmir.todospringboot.entities.Todo;
import br.com.gabrielalmir.todospringboot.services.TodoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<List<Todo>> create(@RequestBody @Valid CreateTodoDto todo) {
        var todos = todoService.create(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todos);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> list() {
        var todos = todoService.list();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> find(@PathVariable("id") Long id) {
        var todo = todoService.find(id);
        return ResponseEntity.ok(new TodoDto(todo.getTitle(), todo.isDone()));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<List<Todo>> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateTodoDto todo) {
        var todos = todoService.update(id, todo);
        return ResponseEntity.ok(todos);
    }
    
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<List<Todo>> delete(@PathVariable("id") Long id) {
        var todos = todoService.delete(id);
        return ResponseEntity.ok(todos);
    }
}
