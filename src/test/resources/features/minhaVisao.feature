Feature: minhaVisao

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acesso ao menu minhaVisao

  Scenario Outline: MinhaVisao_VerTarefas
    When tocar no parâmetro "<Campo>"
    Then o sistema redireciona o usuario para a tela de tarefas
    Examples:
      | Campo                    |
      | Atribuídos a Mim         |
      | Não Atribuídos           |
      | Relatados por Mim        |
      | Resolvidos               |
      | Modificados Recentemente |
      | Monitorados por Mim      |
