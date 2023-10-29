# Mantis4Testers Docker

Este projeto foi criado com o intuito de testar minhas habilidades para a criação e manipulação de um projeto de automação de testes front-end, utilizando as melhores práticas do mercado para automação de teste.

O projeto foi desenvolvido em JAVA, utilizando o SELENIUM web driver e todos os recursos disponíveis para a linguagem.
Projeto em MAVEN, uma ferramenta de gerenciamento de projetos que ajuda a simplificar e automatizar várias tarefas relacionadas ao ciclo de vida do desenvolvimento de software

O sistema alvo é o Mantis BugTracker e é utilizado o Docker para gestão do ambiente e banco de dados.

Foi utilizado o Selenium Grid neste projeto.

## Instalação

### 1. Preparação do ambiente Mantis

Serão necessárias as seguinte configurações para iniciar o projeto:

- Docker-compose: neste repositório é possível encontrar um arquivo chamado "docker-compose.yml", este arquivo contem um grupo de imagens do Mantis, seu banco de dados e o Selenium Grid com seus nós (Mozilla Firefox e Google Chrome).

Crie o diretório local "C:\mantis", baixe o arquivo docker-compose.yml e cole neste diretório criado.

#### 1.1 Setup Docker Mantis

- Instalar [Docker Desktop](https://www.docker.com/products/docker-desktop) e reiniciar a máquina
- Caso apresente o erro "WSL 2 installation is incomplete", [baixe e instale o WSL2 Kernel](https://docs.microsoft.com/pt-br/windows/wsl/wsl2-kernel) e clique em Restart
- Abra o aplicativo Docker Desktop
- Deverá ser apresentado o tutorial, basta dar skip que você terá esta tela
- Abra um terminal e acesse o diretório recém criado: "C:/mantis"
- No diretório haverá o arquivo docker-compose.yml
- Execute o comando `docker-compose.exe up -d`
- Após o processamento, se tudo correr bem, as imagens serão baixadas e novos contêineres criados.

Para validar a criação e execução dos contêineres, execute o comando `docker ps -a` e os contêineres estarão disponíveis e executando.

#### 1.2 Configuração inicial Mantis

- Faça o seu primeiro acesso ao Mantis pelo endereço http://127.0.0.1:8989
- Após acessar, será necessário configurar o banco de dados conforme tabela e valores abaixo:

| Variável               | Valor         |
|------------------------|---------------|
| Type of Database       | MySQL Improved|
| Hostname (for Database Server) | mantis_db_1 |
| Username (for Database)| mantisbt      |
| Password (for Database)| mantisbt      |
| Database name (for Database)| bugtracker |
| Admin Username (to create Database if required)| root |
| Admin Password (to create Database if required)| root |

Após preencher, clique em Login/Continue e aguarde o processamento.

O primeiro acesso deverá ser feito utilizando as credenciais administrator/root. Redefina a senha para o valor "administrator" ou outro valor fácil de lembrar.

#### 1.3 Acessar banco de dados Mantis/MariaDB

Para acessar o banco de dados do Mantis (MariaDB), siga os passos abaixo:

- Baixe e instale o [software HeidiSQL](https://www.heidisql.com/download.php)
- Ao abrir o Gerenciador de sessões, preencha com os valores fornecidos no arquivo.
- Abra a conexão e será possível verificar todas as tabelas e registros:

#### 3. Selenium Grid

- É necessário [instalar o selenium grid](https://www.selenium.dev/documentation/grid/getting_started/) e rodar o comando para subir os nós.(existem algumas formas de instalação, verifique no site).
- Basta baixar o arquivo e descompactar em uma pasta que deseja.
- Na pasta onde o arquivo foi descompactado, rodar o comando abaixo:
     java -jar selenium-server-4.13.0.jar standalone (java -jar + o nome do arquivo que você baixou)
- Com isso, o selenium grid já estará em execução na sua máquina.
- Parabens!! agora basta configurar o seu projeto para rodar no grid!




 
