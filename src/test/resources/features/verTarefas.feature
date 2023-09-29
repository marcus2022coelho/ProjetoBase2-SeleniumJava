@ver_tarefas
Feature: Realizar filtros na tarefas

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acesso ao menu Ver Tarefas


  @teste
  Scenario: Apagar a tarefa
    And seleciono a tarefa a ser apagada
    When seleciono para apagar a tarefa
    And o sistema confirma para apagar a tarefa
    Then a tarefa foi excluida


  @teste
  Scenario: Clonar a tarefa
    And seleciono a tarefa a ser clonada
    When seleciono para copiar tarefa
    And confirmo para copiar a tarefa
    Then salvo a tarefa clone

  @teste
  Scenario Outline: Enviar um lembrete de tarefa a um usuario
    And selecionar a tarefa para enviar lembrete
    And tocar no parâmetro enviar um lembrete
    And selecionar um usuário
    And preencho o campo "<textoLembrete>"
    And seleciono para Enviar
    Then o sistema conclui o envio do lembrete

    Examples:
      | textoLembrete                 |
      | Lembrete para fechar a tarefa |
      | Lembrete para apagar tarefa   |

  @teste
  Scenario Outline: Ver tarefa_Enviar um lembrete_Sem informar Campo obrigatorio
    And selecionar a tarefa para enviar lembrete
    And tocar no parâmetro enviar um lembrete
    And preencho o campo "<textoLembrete>"
    And seleciono para Enviar
    Then o sistema exibe mensagem de erro na tela e não envia o lembrete

    Examples:
      | textoLembrete                 |
      | Lembrete para fechar a tarefa |
      #| Lembrete para apagar tarefa   |

  @teste
  Scenario Outline: Pesquisar a tarefa
    And filtro pelos campos "<relator>","<atribuidoA>","<prioridade>"
    When realizo a pesquisa
    Then o sistma retornou os registros

    Examples:
      | relator    | atribuidoA | prioridade |
      | [qualquer] | [qualquer] | [qualquer] |
  #    | [qualquer] | [qualquer] | nenhuma    |

  @teste
  Scenario Outline: Salvar filtro de pesquisa já realizada
    And filtro pelos campos "<relator>","<atribuidoA>","<prioridade>"
    When clico para salvar o filtro
    And preencho o nome do Filtro
    Then o sistema salva o filtro

    Examples:
      | relator    | atribuidoA | prioridade |
      | [qualquer] | [qualquer] | [qualquer] |

  @teste
  Scenario Outline: Salvar filtro_Voltar
    And filtro pelos campos "<relator>","<atribuidoA>","<prioridade>"
    And clico para salvar o filtro
    When tocar no parâmetro voltar
    Then o sistema deve retornar para a tela anterior

    Examples:
      | relator    | atribuidoA | prioridade |
      | [qualquer] | [qualquer] | [qualquer] |

  @teste
  Scenario Outline: Realizar a pesquisa com o filtro salvo
    When seleciono o "<nomeDoFiltro>" que foi salvo
    Then o sistema realiza o filtro

    Examples:
      | nomeDoFiltro |
      | Filtro Teste |

  @teste
  Scenario: Imprimir tarefas
    When seleciono para imprimir tarefas
    Then o sistema retorna as tarefas

   @teste
   Scenario: Ver tarefas_Mover
     And selecionar a tarefa
     When selecionar o parâmetro mover
     And selecionar o usuario a qual a tarefa será movida
     And tocar no parâmetro mover tarefas
     Then o sistema realiza a acao de mover a tarefa

  @teste
  Scenario: Ver tarefas_atribuir
    And selecionar a tarefa
    When selecionar o parâmetro atribuir
    And selecionar o usuario a qual a tarefa será atribuida
    And tocar no parâmetro Atribuir Tarefas
    Then o sistema realiza a ação de atribuir a tarefa

  @teste
  Scenario: Ver tarefas_fechar
    And selecionar a tarefa
    When selecionar o parâmetro fechar
    And adicionar uma anotacao
    When tocar no parâmetro Fechar tarefa
    Then o sistema deve fechar a tarefa

  @teste
  Scenario: Ver tarefas_Resolver
    And selecionar a tarefa
    When selecionar o parâmetro resolver
    And escolher resolução das tarefas
    And adicionar uma anotacao
    And tocar no parâmetro Resolver tarefa
    Then o sistema deve atualizar o estado da tarefa

  @teste
  Scenario: Ver tarefas_fixar/desfixar
    And selecionar a tarefa
    When selecionar o parâmetro fixar/desfixar
    And tocar no parâmetro Marcar/Desmarcar Pegajosos
    Then o sistema realiza a ação

  @teste
  Scenario: Ver tarefas_atualizarPrioridade
    And selecionar a tarefa
    When selecionar o parâmetro atualizar prioridade
    And selecionar a nova prioridade
    And tocar no parâmetro atualizar prioridade
    Then o sistema atualiza a prioridade da tarefa

  @teste
  Scenario: Ver tarefas_atualizarGravidade
    And selecionar a tarefa
    When selecionar o parâmetro atualizar gravidade
    And selecionar a nova gravidade
    And tocar no parâmetro atualizar gravidade
    Then o sistema atualiza a gravidade da tarefa

  @teste
  Scenario: Ver tarefas_atualizarStatus
    And selecionar a tarefa
    When selecionar o parâmetro atualizar status
    And selecionar o novo status
    And incluir uma anotação
    And tocar no parâmetro Atualizar Status
    Then o sistema atualiza o status da tarefa

  @teste
  Scenario: Ver tarefas_atualizarCategoria
    And selecionar a tarefa
    And selecionar o parâmetro atualizar categoria
    And tocar no parâmetro OK
    And selecionar nova categoria
    When selecionar "Atualizar Categoria"
    Then o sistema atualiza a categoria da tarefa

  @teste
  Scenario: Ver tarefas_atualizarVisibilidade
    And selecionar a tarefa
    When selecionar o parâmetro atualizar visibilidade
    And tocar no parâmetro OK
    And selecionar nova visibilidade
    And selecionar "Atualizar Visibilidade"
    Then o sistema atualiza a visibilidade da tarefa

  @teste
  Scenario: Ver tarefas_adicionarAnotacao
    And selecionar a tarefa
    When selecionar o parâmetro adicionar anotacao
    And tocar no parâmetro OK
    And adicionar uma anotacao
    And selecionar "Adicionar Anotação"
    Then o sistema atualiza a tarefa
