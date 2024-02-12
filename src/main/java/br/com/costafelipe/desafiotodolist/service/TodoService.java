package br.com.costafelipe.desafiotodolist.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

  public List<Todo> create(Todo todo) {
    todo.setDataCriacao(LocalDateTime.now());
    todoRepository.save(todo);
    return list();
  }

  public List<Todo> update(Todo todo) {
    todo.setDataUpdate(LocalDateTime.now());
    todoRepository.save(todo);
    return list();
  }

  public List<Todo> delete(UUID id) {
    if (id == null) {
      return null;
    }
    todoRepository.deleteById(id);
    return list();
  }

  public List<Todo> list() {
    return todoRepository.findAll();
  }

  public Optional<Todo> findById(UUID id) {
    if (id == null) {
      return null;
    }
    return todoRepository.findById(id);
  }
}
