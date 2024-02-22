package br.com.costafelipe.desafiotodolist.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import br.com.costafelipe.desafiotodolist.entity.Todo;
import br.com.costafelipe.desafiotodolist.repository.TodoRepository;
import br.com.costafelipe.desafiotodolist.service.TodoService;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

  @Mock
  TodoRepository todoRepository;

  @InjectMocks
  TodoService todoService;

  List<Todo> todos;

  UUID uuid = UUID.randomUUID();

  @BeforeEach
  void setUp() {

    this.todos = new ArrayList<>();

    Todo t1 = new Todo();
    t1.setId(uuid);
    t1.setNome("Teste 1");
    t1.setDescricao("teste e teste e teste");
    t1.setPrioridade(1);
    t1.setRealizado(false);
    ;
    t1.setDataCriacao(LocalDateTime.now());

    Todo t2 = new Todo();
    t2.setId(uuid);
    t2.setNome("Teste 2");
    t2.setDescricao("teste 2 e teste 2 e teste 2");
    t2.setPrioridade(2);
    t2.setRealizado(true);
    ;
    t2.setDataCriacao(LocalDateTime.now());

    this.todos.add(t1);
    this.todos.add(t2);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void testFindAllSucess() {
    //given
    given(this.todoRepository.findAll()).willReturn(this.todos);

    //when
    List<Todo> actualTodos = todoService.list();

    //then
    assertThat(actualTodos.size()).isEqualTo(this.todos.size());
    verify(todoRepository, times(1)).findAll();
  }

}
