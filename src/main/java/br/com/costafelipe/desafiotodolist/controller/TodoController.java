package br.com.costafelipe.desafiotodolist.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.costafelipe.desafiotodolist.dto.TodoDto;
import br.com.costafelipe.desafiotodolist.entity.Todo;
import br.com.costafelipe.desafiotodolist.service.TodoService;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @PostMapping
  public ResponseEntity<Todo> create(@RequestBody TodoDto todoDto) {
    var todo = new Todo();
    BeanUtils.copyProperties(todoDto, todo);
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
  }

  @PutMapping
  public ResponseEntity<List<Todo>> update(TodoDto todoDto) {
    var todo = new Todo();
    BeanUtils.copyProperties(todoDto, todo);
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.update(todo));
  }

  @DeleteMapping("/{id}")
  List<Todo> delete(@PathVariable("id") UUID id) {
    return todoService.delete(id);
  }

  @GetMapping("/{id}")
  Todo getTodo(@PathVariable("id") UUID id) {
    return todoService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<Todo>> list() {
    List<Todo> todoList = todoService.list();
    return ResponseEntity.ok().body(todoList);
  }

}
