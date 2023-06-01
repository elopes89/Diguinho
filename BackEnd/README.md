# Projeto 2 Módulo 3 Futuro DEV[Pinheira]

Projeto desenvolvido em java com Spring Boot.

## Front End do Projeto
O projeto atual pode ser executado no Front End, uma maneira mais amigável de executar o mesmo.
Segue o link da parte do Front:

[Front End](https://github.com/elopes89/frontProjeto2Modulo3/tree/main)
## Ferramentas necessárias para uso do projeto:

  - Intellij 
  - Postman
  - PgAdmin4 ou DBeaver
  - Google Chrome

## Funcionalidade da aplicação
Com a aplicação é possível fazer um crud completo tanto de produtos quanto de suas categoarias. Ou seja, é possível: salvar, deletar, editar e listar ambas as entidades do projeto.

## Como usar a aplicação

- No Intellij abra o arquivo pom.xml como projeto 
- Inicie a aplicação
- Na ferramenta de banco de dados verifique se foram criadas as tabelas
- No Postman ou no Swagger execute os endpoints
- Retorne ao DBeaver e veja os resultados da manipulação obtida com os endpoints
  
## Projeto documentado com a ferramenta Swagger.
O projeto pode ser executado com a ferramenta de documentação:   
 [Swagger](http://localhost:4000/swagger-ui.html#/)


## Foto do modelo Relacional

![](/modulo3/src/main/resources/modeloRelacional.png)

## Exemplos de execução no Postman ou no Swagger

### Exemplo de como cadastrar uma categoria:
### Método POST

![](/modulo3/src/main/resources/postCategoria.png)

### Exemplo de como exibir uma categoria:
### Método GET

![](/modulo3/src/main/resources/getCategoria.png)

### Exemplo de como editar uma categoria:
### Método PUT

![](/modulo3/src/main/resources/putCategoria.png)

### Exemplo de como deletar uma categoria:
### Método DELETE

![](/modulo3/src/main/resources/deleteCategoria.png)

### Atenção!!!
Se um produto estiver cadastrado com uma categoria será exibido este erro:
### Método DELETE

![](/modulo3/src/main/resources/erroDeleteCategoria.png)



### Exemplo de como cadastrar um produto:
  Este é o formato Json para realizar o cadastro da entidade. Para manipular a entidade Produto é só seguir seguir os passos de Categoria.
#### Obs.: É necessário ter no mínimo uma categoria registrada antes de cadastrar um  produto.
### Método POST
### Url http://localhost:4000/produtos

    {
        "nome": "bolacha recheada",
        "valorProduto":5.0,
        "statusProduto": true,
        "id_categoria":1
    }

Resultado esperado:

    {
        "id": 1,
        "nome": "bolacha recheada",
        "valorProduto":5.0,
        "statusProduto": true,
        "id_categoria":1
    }


### Produzido por Emanuel Lopes
## Aluno FuturoDev Senai






