# Projeto de API do Live Coding da Digital Innovation One

- Desenvolvido com Spring Boot 2.5.3
- Dependências: Spring Web, H2, Project Lombok, Mapstruct, JPA.
- CRUD de pessoas (Inserção, Update, Exclusão e Listagem por ID e Geral).
- Executado deploy no Heroku (https://glaubergad-peopleapi.herokuapp.com/)
  Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```


São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido durante a aula:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.