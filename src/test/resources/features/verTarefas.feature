@ver_tarefas
Feature: Realizar filtros na tarefas, notificar os usuarios com lembretes

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
    And selecionar a tarefa
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
    And selecionar a tarefa
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
    And preencho o "<nomeDoFiltro>"
    Then o sistema salva o filtro

    Examples:
      | relator    | atribuidoA | prioridade | nomeDoFiltro |
      | [qualquer] | [qualquer] | [qualquer] | Filtro Teste |

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