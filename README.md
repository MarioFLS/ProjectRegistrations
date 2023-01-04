# ProjectRegistrations!

## Descrição
Esse Projeto busca simular cadastros de pessoas e seus endereços. Projeto feito para Desafio da Attornatus.

## Tecnologias Usadas

> Desenvolvida utilizando: Java 17, SpringBoot e o Banco de dados H2

# ENDPOINTS

Eles estaram no arquivo *Rotas Projeto.postman_collection.json*, situado na raiz do projeto. Pode ser usado no Postman.

Geralmente você usará o caminho `http://localhost:8080`, o seu terminal indicará a porta correta.

Algumas Requisições teram um body em formato de JSON!

<details>
  <summary><strong>Rotas de Buscas de Pessoa</strong></summary><br />
  
  > Pegar todas as pessoas cadastradas **GET**
``http://localhost:8080/people``

>Pegar pessoas cadastrada pelo ID **GET**. Precisa ser um ID que exista. Se não retornará um erro!
``http://localhost:8080/people/1``


> Cadastrar Nova pessoa **POST**
``http://localhost:8080/people``

```
  {
    "name" : "Nome",
    "birthDate": "10/11/2002"
  } 
```

> Editar o Cadastro de uma pessoa **PUT**. Você precisa passar um id existente!
``http://localhost:8080/people/1``

```
  {
    "name" : "Nome Atualizado",
    "birthDate": "11/10/2020"
  } 
```

> Deletar um Cadastro **Delete**. Você precisa passar um id existente!
``http://localhost:8080/people/1``

> Adicionar Endereço como Principal **Put**. Você precisa passar um id de cadastro e de Endereço existente! O primeiro Número equivale a Pessoa. O segundo ao Endereço

``http://localhost:8080/people/1/address/1``

> Buscar endereço principal da pessoas cadastradas **GET**
``http://localhost:8080/people/1/address/main``
  <br />
</details>

<details>
  <summary><strong>Buscar e Adicionar Endereço</strong></summary><br />
  
> Buscar endereço do Usuário **GET**
``http://localhost:8080/people/1/address``

> Cadastrar Novo Endereço **POST**. O Id equivale a pessoa cadastrada
``http://localhost:8080/people/1/address``

O logradouro não é um valor obrigatório.

```
 {
    "cep": "88888888",
    "number": 800,
    "logradouro": "Esse valor não é obrigatório",
    "city": "Rio de Janeiro"
}
```

  <br />
</details>

## Estou aqui para Ajudar!
Havendo algum problema. Entre em contato comigo, poderei auxiliar a resolver os problemas!
Isso também vale para dúvidas de funcionamento!
