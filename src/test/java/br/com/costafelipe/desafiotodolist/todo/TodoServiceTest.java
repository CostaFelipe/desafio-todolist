package br.com.costafelipe.desafiotodolist.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    t1.setDataCriacao(LocalDateTime.now());

    Todo t2 = new Todo();
    t2.setId(uuid);
    t2.setNome("Teste 2");
    t2.setDescricao("teste 2 e teste 2 e teste 2");
    t2.setPrioridade(2);
    t2.setRealizado(true);
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

  @Test
  void testFindById() {
    //given
    Todo t = new Todo();
    t.setId(UUID.fromString("2c3d8c6d-a8a3-461b-babd-d206226f7bc3"));
    t.setNome("Teste 1");
    t.setDescricao("teste e teste e teste");
    t.setPrioridade(1);
    t.setRealizado(false);
    t.setDataCriacao(LocalDateTime.now());


    given(todoRepository.findById(t.getId())).willReturn(Optional.of(t));

    //then
    Todo returnTodo = todoService.findById(UUID.fromString("2c3d8c6d-a8a3-461b-babd-d206226f7bc3")).get();

    //when
    assertThat(returnTodo.getId()).isEqualTo(t.getId());
    assertThat(returnTodo.getNome()).isEqualTo(t.getNome());
    assertThat(returnTodo.getDescricao()).isEqualTo(t.getDescricao());
    assertThat(returnTodo.getPrioridade()).isEqualTo(t.getPrioridade());
    assertThat(returnTodo.getRealizado()).isEqualTo(t.getRealizado());
    assertThat(returnTodo.getDataCriacao()).isEqualTo(t.getDataCriacao());

    verify(todoRepository, times(1)).findById(t.getId());
  }

  @Test
  void TestSaveSucess() {
    //given
    Todo newTodo = new Todo();
    newTodo.setNome("Teste 1");
    newTodo.setDescricao("teste e teste e teste");
    newTodo.setPrioridade(1);
    newTodo.setRealizado(false);
    newTodo.setDataCriacao(LocalDateTime.now());

    given(todoRepository.save(newTodo)).willReturn(newTodo);

    //when
    Todo saveTodo = todoService.create(newTodo);

    //then
    assertThat(saveTodo.getId()).isEqualTo(newTodo.getId());
    assertThat(saveTodo.getNome()).isEqualTo(newTodo.getNome());
    assertThat(saveTodo.getDescricao()).isEqualTo(newTodo.getDescricao());
    assertThat(saveTodo.getPrioridade()).isEqualTo(newTodo.getPrioridade());
    assertThat(saveTodo.getRealizado()).isEqualTo(newTodo.getRealizado());
    assertThat(saveTodo.getDataCriacao()).isEqualTo(newTodo.getDataCriacao());

    verify(todoRepository, times(1)).save(newTodo);

  }

}
