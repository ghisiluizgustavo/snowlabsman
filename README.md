# Snowman Labs Library

### Requirements:
- [x] Endpoints com versionamento  
- [x] CRUD para Livros
- [x] Notificação por mensageria (Spring Events)
- [x] Ao alugar um livro deixar ele indisponível
- [x] Ao alugar um livro disparar email para o cliente
- [x] Utilize spring-boot-starter-data-jpa e H2 Database para persistência
- [x] Utilize spring-boot-starter-web para criar os endpoints REST.
- [x] Implemente validação dos dados de entrada utilizando Bean Validation.
- [x] Documente a API usando Swagger.
- [x] Escreva testes unitários e de integração para os endpoints criados.
- [x] Read me para execução do projeto de forma autônoma por outro Software Engineer.
- [x] Usar o repositório Git e usar o Gitflow como padrão de versionamento.
- [x] Docker

### Como rodar o projeto:

1. Faça o clone do projeto:
```shell
git clone https://github.com/ghisiluizgustavo/snowmanlabs.git
```
2. Acesse a pasta snowmanlabs que foi criada após o clone
```shell
cd snowmanlabs
```
3. Suba a imagem da aplicação que está no docker-hub usando o docker-compose
```shell
docker-compose up
``` 
4. Após iniciar a aplicação irá loggar alguns ID's já previamente cadastrados na base
5. Substitua os id's nas collections do Postman por esses ID's loggados na aplicação

