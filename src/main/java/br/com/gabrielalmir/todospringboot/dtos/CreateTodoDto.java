package br.com.gabrielalmir.todospringboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateTodoDto(
        @NotBlank
        String title
) {
}
