package br.com.costafelipe.desafiotodolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.costafelipe.desafiotodolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID>{

}
