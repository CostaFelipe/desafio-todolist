package br.com.costafelipe.desafiotodolist.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.costafelipe.desafiotodolist.entity.Todo;
import br.com.costafelipe.desafiotodolist.repository.TodoRepository;

@Service
public class TodoService {
  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Todo create(Todo todo) {
    todo.setDataCriacao(LocalDateTime.now());
    return todoRepository.save(todo);
  }

  public List<Todo> update(Todo todo) {
    todo.setDataUpdate(LocalDateTime.now());
    todoRepository.save(todo);
    return list();
  }

  public List<Todo> delete(UUID id) {
    todoRepository.deleteById(id);
    return list();
  }

  public List<Todo> list() {
    return todoRepository.findAll();
  }

  public Todo findById(UUID id) {
    return todoRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Author with id: " + id + " could not be found"));
  }
}
