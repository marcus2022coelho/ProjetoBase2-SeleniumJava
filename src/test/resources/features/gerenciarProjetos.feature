@gerenciar_projeto @mantis
Feature: Gerenciar projetos do Mantis

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acessar Gerenciar no Menu
    And acessar Gerenciar Projetos

  @teste
  Scenario Outline: Criar um novo projeto no Mantis
    And acessar Criar novo Projeto
    When preencher os campos a seguir "<nomeDoProjeto>","<Estado>","<Visibilidade>","<Descricao>"
    Then o projeto foi criado

    Examples:
      | nomeDoProjeto                              | Estado          | Visibilidade | Descricao                                          |
      | Desafio de Criacao de Projeto automatizado | desenvolvimento | privado      | Projeto criado para o desafio do mapa de carreiras |

  @teste
  Scenario Outline: Editar projeto
    And selecionar o Projeto
    When atualizar os campos necessarios "<nomeProjetoEdit>","<Estado>","<Visibilidade>","<campoDescricaoEdit>"
    Then o sistema atualizou o projeto

    Examples:
      | nomeProjetoEdit             | Estado   | Visibilidade | campoDescricaoEdit                  |
      | Desafio do Mantis de Edicao | obsoleto | privado      | Desafio automacao do Mantis Editado |

  #criar um IF para caso não exista projeto criado para a primeira posicao
  @teste
  Scenario: Excluir projeto
    And seleciono o projeto para excluir
    When seleciono apagar o projeto
    Then o sistema exclui o projeto

  @teste
  Scenario Outline: Cadastrar o projeto com mesmo nome
    And tocar em criar novo projeto
    When preencher os campos a seguir "<nomeProjetoIgual>","<Estado>","<Visibilidade>","<Descricao>"
    And  Tocar no parâmetro salvar
    Then o sistema exibe a mensagem de erro

    Examples:
      | nomeProjetoIgual                   | Estado          | Visibilidade | Descricao                          |
      | Cadastrar o projeto com mesmo nome | desenvolvimento | privado      | Cadastrar o projeto com mesmo nome |

