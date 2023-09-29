@criarTarefa
Feature: Criar uma nova tarefa

  Background:

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acesso ao menu Criar Tarefas


  @teste
  Scenario Outline: criar uma tarefa
    And preencher todos os campos a seguir "<categoria>","<frequencia>","<gravidade>","<prioridade>","<atribuir>","<resumo>","<descricao>","<passosReproduzir>","<informacoesAdicionais>","<visibilidade>"
    When tocar em criar nova tarefa
    Then o sistema deve criar a nova tarefa
    Examples:
      | categoria | frequencia | gravidade | prioridade | atribuir      | resumo           | descricao        | passosReproduzir | informacoesAdicionais | visibilidade |
      | General   | sempre     | pequeno   | normal     | administrator | Tarefa automacao | tarefa automacao | teste            | teste                 | publico      |

  @teste
  Scenario Outline: criar uma tarefa sem os campos obrigatorios
    And preencher os campos a seguir "<frequencia>","<gravidade>","<prioridade>","<atribuir>","<resumo>","<descricao>","<passosReproduzir>","<informacoesAdicionais>","<visibilidade>"
    When tocar em criar nova tarefa
    Then o sistema exibirá mensagem informativa e não salvará a tarefa
    Examples:
      | frequencia | gravidade | prioridade | atribuir      | resumo           | descricao        | passosReproduzir | informacoesAdicionais | visibilidade |
      | sempre     | pequeno   | normal     | administrator | Tarefa automacao | tarefa automacao | teste            | teste                 | publico      |
