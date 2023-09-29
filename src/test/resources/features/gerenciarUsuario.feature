@gerenciarUsuario

Feature:  Gerenciar Usuario

  Background:
    Given acesso a tela de login
    And informar usuario
    And tocar no parâmetro confirmar
    And informar senha
    And tocar no parâmetro confirmar
    And acessar Gerenciar no Menu
    And acessar menu Gerenciar usuarios

  @teste
  Scenario: criar um novo usuario
    When selecionar o parâmetro 'criar nova conta'
    And preenche o campo nome de usuario
    And preenche o campo nome verdadeiro
    And preenche o campo email
    And preenche o campo nivel de acesso
    And tocar no parâmetro Criar Usuario
    Then o sistema deve criar o usuário com sucesso

  @teste
  Scenario: criar um novo usuario_sem informar campo obrigatório
    When selecionar o parâmetro 'criar nova conta'
    And preenche o campo nome verdadeiro
    And preenche o campo email
    And preenche o campo nivel de acesso
    And tocar no parâmetro Criar Usuario
    Then o sistema deve exibir mensagem erro

  @teste
  Scenario: criar um novo usuario_nome igual
    When selecionar o parâmetro 'criar nova conta'
    And preenche o campo nome de usuario com um nome já existente
    And preenche o campo nome verdadeiro
    And preenche o campo email
    And preenche o campo nivel de acesso
    And tocar no parâmetro Criar Usuario
    Then o sistema deve exibir mensagem erro

  @teste
  Scenario Outline: Editar usuario
    And selecionar o Nome de Usuario
    When atualizar o "<editarNivelAcesso>"
    And tocar no parâmetro Atualizar Usuário
    Then o sistema atualizou o usuario

    Examples:
      | editarNivelAcesso |
      | gerente           |

  @teste
  Scenario: Redefinir a senha
    And selecionar o Nome de Usuario
    When seleciono para redefinir a senha
    Then o sistema orienta sobre a redefinicao

  @teste
  Scenario: Representar Usuario
    And selecionar o Nome de Usuario
    When seleciono para representar o usuario
    Then o sistema solicita a confirmacao

  @teste
  Scenario: Excluir usuario
    When selecionar o Nome de Usuario
    Then confirmar a exclusao do usuario
    And o sistema exibe a mensagem confirmando


