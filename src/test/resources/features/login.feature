Feature: LoginMantis

  @regressao
  Scenario: Realizar Login_LoginSucesso
     Given acesso a tela de login
    When informar usuario 'administrator'
    And tocar no parâmetro confirmar
    And informar senha 'abc123'
    And tocar no parâmetro confirmar
    Then o sistema deve realizar o login e exibir a tela do mantis com o usuário logado

#  Scenario: Realizar Login_LoginSucesso_Table
#    Given acesso a tela de login
#    When Informar usuario
#      | administrator | abc123 |
#    And tocar no parâmetro confirmar
#    And Informar senha
#      | administrator | abc123 |
#    And tocar no parâmetro confirmar
#    Then o sistema deve realizar o login e exibir a tela do mantis com o usuário logado


#  @automatizar
#  Scenario Outline: Login sucesso
#    Given acesso a tela de login
#    When informar usuario "<username>"
#    And tocar no parâmetro confirmar
#    And informar senha "<senha>"
#    And tocar no parâmetro confirmar
#    Then o sistema deve realizar o login e exibir a tela do mantis com o usuário logado
#
#    Examples:
#      | username      | senha  |
#      | administrator | abc123 |
#      | teste1        | teste2 |



















 # @CustomType
  #Scenario Outline: Login sucesso2
   # Given acesso a tela de login
    #When inserir um "<product_name>"
    #Then o sistema faz isso

    #Examples:
     # | product_name |
      #| nome         |

#    @teste3
#  Scenario: Realizar Login_LoginSucesso
#    Given acesso à tela de login
#    When informar usuario 'administrator'
#    And tocar no parâmetro  'confirmar'
#    And informar senha 'abc123'
#    And tocar no parâmetro  'confirmar'
#    Then o sistema deve realizar o login e exibir a tela do mantis com o usuário logado

