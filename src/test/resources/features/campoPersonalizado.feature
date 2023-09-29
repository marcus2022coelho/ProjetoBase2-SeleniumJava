Feature: Cadastrar campos personalizados

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acessar Gerenciar no Menu
    And acessar Gerenciar Projetos
    And acesso ao menu Gerencir Campos Personalizados


  @teste
  Scenario: Cadastrar o campo personalizado
    And informo o nome do campo Personalizado
    When seleciono para adicionar o campo
    Then confirmo a criacao do campo

  @teste
  Scenario: Cadastrar o campo personalizado_Nome ja existente
    And informo o nome do campo personalizado duplicado
    When seleciono para adicionar o campo repetido
    Then sistema retorna mensagem informando que o campo não pode ser repetido

  @teste
  Scenario Outline: Editar o campo personalizado
    When seleciono para alterar o campo
    And seleciono o "<acessoDeLeitura>","<acessoDeEscrita>"
    Then confirmo a edicao do campo

    Examples:
      | acessoDeLeitura | acessoDeEscrita|
      | visualizador   | visualizador    |

  @teste
  Scenario: Vincular o campo personalizado
    And seleciono a tarefa para vincular
    When seleciono o projeto para vincular
    Then seleciono para vincular o campo personalizado


  @teste
  Scenario: Excluir o campo personalizado
    And seleciono o campo personaliado para excluir
    When clico para apagar campo personalizado
    And confirmo para excluir o campo
    Then visualizo a mensagem de sucesso