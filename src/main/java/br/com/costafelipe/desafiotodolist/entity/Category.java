package br.com.costafelipe.desafiotodolist.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  private List<Todo> todos = new ArrayList<>();

  private LocalDateTime dataCriacao;
  private LocalDateTime dataUpdate;

  public Category(String name, List<Todo> todos) {
    this.name = name;
    this.todos = todos;
  }

  public void addTodo(Todo todo) {
    todos.add(todo);
  }

  public void removeTodo(Todo todo) {
    todos.remove(todo);
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public LocalDateTime getDataUpdate() {
    return dataUpdate;
  }

  public void setDataUpdate(LocalDateTime dataUpdate) {
    this.dataUpdate = dataUpdate;
  }

}
