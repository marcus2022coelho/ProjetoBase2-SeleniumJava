@tarefa @pegajosa @marcar @desmarcar @pesquisa
Feature: Terfas pegajosas

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acesso ao menu Ver Tarefas

  @teste
  Scenario: Marcar a tarefa como pegajosa
    When selecionar o numero da tarefa
    And marcar a tarefa como pegajosa
    Then o sistema deve exibir em histórico da tarefa a ação realizada

  @teste
  Scenario: Desmarcar a tarefa como pegajosa
    When selecionar o numero da tarefa
    And desmarcar a tarefa como pegajosa
    Then o sistema deve exibir em histórico da tarefa a ação realizada