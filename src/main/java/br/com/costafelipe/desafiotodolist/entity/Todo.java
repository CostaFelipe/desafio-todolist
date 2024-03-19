package br.com.costafelipe.desafiotodolist.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String nome;
  private String descricao;
  private boolean realizado;
  private int prioridade;
  private LocalDateTime dataCriacao;
  private LocalDateTime dataUpdate;
  private Category category;

  public Todo(String nome, String descricao, boolean realizado, int prioridade, Category category) {
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
    this.category = category;
  }

  public Todo() {

  }

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public boolean getRealizado() {
    return realizado;
  }

  public void setRealizado(boolean realizado) {
    this.realizado = realizado;
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
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }



}
