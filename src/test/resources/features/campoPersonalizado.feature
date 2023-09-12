Feature: Cadastrar campos personalizados

  Background:
    Given acessou o site Mantis
    And fez o login
    And seleciono o Gerenciar no Menu
    When seleciono no Menu Gerenciar Campos Personalizados

  @teste
  Scenario Outline: Cadastrar o campo personalizado
    And informo o nome do "<campoPersonalizado>"
    When seleciono para adicionar o campo
    Then confirmo a criacao do campo

    Examples:
      |campoPersonalizado           |
      |Teste de campo Personalizado |


  @teste
  Scenario Outline: Editar o campo personalizado
    When seleciono para alterar o campo
    And seleciono o "<acessoDeLeitura>","<acessoDeEscrita>"
    Then confirmo a edicao do campo

    Examples:
      | acessoDeLeitura | acessoDeEscrita|
      | visualizador   | visualizador    |


  @teste
  Scenario Outline: Vincular o campo personalizado
    And seleciono a tarefa para vincular
    When seleciono o projeto para vincular em "<projetos>"
    Then seleciono para vincular o campo personalizado

    Examples:
      | projetos           |
      | Criacao de Projeto |


  @teste
  Scenario: Excluir o campo personalizado
    And seleciono o campo personaliado para excluir
    When clico para apagar campo personalizado
    And confirmo para excluir o campo
    Then visualizo a mensagem de sucesso