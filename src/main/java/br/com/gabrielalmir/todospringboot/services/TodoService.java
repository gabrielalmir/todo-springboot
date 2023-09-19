package br.com.gabrielalmir.todospringboot.services;

import br.com.gabrielalmir.todospringboot.dtos.CreateTodoDto;
import br.com.gabrielalmir.todospringboot.dtos.TodoDto;
import br.com.gabrielalmir.todospringboot.dtos.UpdateTodoDto;
import br.com.gabrielalmir.todospringboot.entities.Todo;
import br.com.gabrielalmir.todospringboot.repositories.TodoRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(CreateTodoDto todo) {
        var newTodo = new Todo(todo);
        todoRepository.save(newTodo);
        return list();
    }

    public Todo find(Long id) {
        var todo = todoRepository.getReferenceById(id);
        return todo;
    }

    public List<Todo> list() {
        var sortedTodos = Sort.by("creationDateTime").descending();
        return todoRepository.findAll(sortedTodos);
    }
    public List<Todo> update(Long id, UpdateTodoDto updateTodoDto) {
        var todo = todoRepository.findById(id);

        if (todo.isPresent()) {
            var todoEntity = todo.get();
            todoEntity.update(updateTodoDto);
            todoRepository.save(todoEntity);
        }

        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
