# Plataforma de Agenda de clientes da Mindsait

Projeto desenvolvido com Spring Boot, com CRUD completo que permite aos usuários gerenciar seus clientes e contatos. 

Agenda Mindsait Backend
Este é o repositório do backend do projeto Agenda Mindsait. Aqui você encontrará instruções para configurar e rodar o projeto localmente, além de acessar a documentação da API via Swagger.

## Tecnologias Utilizadas

● Spring Web
● H2 Driver
● Spring Data JPA
● Spring Boot DevTools
● Validation

## Pré-requisitos
* Antes de começar, certifique-se de ter instalado:

* Java JDK (versão 11 ou superior)

* Maven (gerenciador de dependências)

* Eclipse IDE (ou outra IDE de sua preferência)

* Git (para clonar o repositório)

## Como rodar o projeto 
1. Clone o projeto: 
```markdown
git clone https://github.com/adanisantana/agenda_mindsait_backend.git
````
2. Importe o projeto no Eclipse:

* Abra o Eclipse.

* Vá em File > Import.

* Selecione Maven > Existing Maven Projects.

* Escolha a pasta do projeto clonado e clique em Finish.

3. Execute o projeto:

* No Eclipse, clique com o botão direito no projeto.

* Vá em Run As > Spring Boot App.

* O servidor estará rodando em http://localhost:8080 (ou na porta configurada no application.properties).

## Acessando o Swagger
O projeto utiliza  Springdoc OpenAPI para documentar a API. Para acessar a interface do Swagger:

1. Certifique-se de que o servidor está rodando.

2. Abra o navegador e acesse:

```markdown
http://localhost:8080/
```
Nota: Substitua 8080 pela porta configurada no seu application.properties.

Na interface do Swagger, você poderá visualizar todos os endpoints disponíveis, testá-los e ver exemplos de requisições e respostas.

## Autores

- [Daniella Santana](https://www.linkedin.com/in/adaniellasantana/)




