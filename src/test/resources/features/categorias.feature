@categoria
Feature: cadastrar categorias

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acessar Gerenciar no Menu
    And acessar Gerenciar Projetos

  @teste
  Scenario Outline: Adicionar a categoria
    And informo o "<nomeDaCategoria>"
    When adiciono a categoria
    Then confirmo a criacao na lista

    Examples:
      | nomeDaCategoria |
      | testeMarcus2    |


  @teste
  Scenario Outline: Adicionar e alterar a categoria
    And preencho o nome da categoria
    When seleciono para alterar a categoria
    And edito o campo "<atribuidoA>"
    Then atualizo a categoria

    Examples:
      | atribuidoA    |
      | administrator |

  @teste
  Scenario: Adicionar a categoria sem informar o titulo
    When seleciono para adicionar a categoria
    Then o sistema exibe a mensagem de campo vazio