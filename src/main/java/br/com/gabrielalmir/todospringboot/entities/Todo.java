package br.com.gabrielalmir.todospringboot.entities;

import br.com.gabrielalmir.todospringboot.dtos.CreateTodoDto;
import br.com.gabrielalmir.todospringboot.dtos.UpdateTodoDto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="todos")
public class Todo {
    public Todo(CreateTodoDto todo) {
        this.title = todo.title();
        this.done = false;
        this.creationDateTime = new Date();
    }

    public Todo() {}

    public void update(UpdateTodoDto todo) {
        this.title = todo.title();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean done;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
}
