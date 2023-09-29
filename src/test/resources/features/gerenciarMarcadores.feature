@gerenciarMarcador
Feature: Manter os marcadores cadastradas para os projetos

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acessar Gerenciar no Menu
    And seleciono para Gerenciar os Marcadores

  @teste
  Scenario Outline: Criar o marcador
    When tocar no parâmetro Criar Marcador
    And informo o "<nomeDoMarcador>","<descricaoDoMarcador>"
    Then confirmo a criacao do marcador

    Examples:
      | nomeDoMarcador      | descricaoDoMarcador          |
      | Criacao do Marcador | Teste de criacao do marcador |

  @teste
  Scenario: Editar o marcador
    And seleciono o marcador
    When seleciono para atualizar o marcador
    And atualizo a descrição do marcador
    Then seleciono para concluir a atualizacao


  @teste
  Scenario: Visualizar Tarefas relacionadas ao marcador
    And seleciono o marcador
    When seleciono para visualizar as tarefas
    Then sistema redireciona o usuario para a tela de visualizar tarefas

  @teste
  Scenario: Excluir marcador
    And seleciono o marcador para excluir
    When seleciono para excluir
    Then confirmo a exclusao
    And valido a exclusao do marcador



