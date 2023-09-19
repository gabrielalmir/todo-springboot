package br.com.gabrielalmir.todospringboot.repositories;

import br.com.gabrielalmir.todospringboot.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
