# SagaProject
Repository for version control of the SAGA project for Digital Bussiness Enablement class. 

## Filmes

Descrição dos endpoints de Filmes

- `GET` /categorias: listar todos os Filmes do sistema
- `POST` /categorias: cadastrar um Filme
- `GET` /categorias/{id}: retornar um Filme pelo seu ID
- `PUT` /categorias/{id}: atualizar um Filme pelo seu ID
- `DELETE` /categorias/{id}: apagar um Filme pelo seu ID

### Exemplo de JSON
```js
{
    "id" : long,
    "titulo": "string",
    "sinopse": "string",
    "diretor": "string",
    "duracao": "string",
    "dataEstreia": LocalDate,
    "caminhoBanner": "string",
    "faixaEtaria": int,
    "idCategoria": long
}
```

### Códigos de retorno
|codigo| significado
|-|-
|200 | dados retornados com sucesso
|201 | criado com sucesso
|204 | apagado com sucesso
|400 | dados inválidos
|404 | não encontrado


## Usuarios

Descrição dos endpoints de Usuarios

- `GET` /categorias: listar todos os Usuarios do sistema
- `POST` /categorias: cadastrar um Usuario
- `GET` /categorias/{id}: retornar um Usuario pelo seu ID
- `PUT` /categorias/{id}: atualizar um Usuario pelo seu ID
- `DELETE` /categorias/{id}: apagar um Usuario pelo seu ID

### Exemplo de JSON
```js
{
    "id" : long,
    "email": "string",
    "nome": "string",
    "senha": "string",
    "dataNascimento": LocalDate
}
```

### Códigos de retorno
|codigo| significado
|-|-
|200 | dados retornados com sucesso
|201 | criado com sucesso
|204 | apagado com sucesso
|400 | dados inválidos
|404 | não encontrado


## Categoria de Filmes

Descrição dos endpoints de Categorias

- `GET` /categorias: listar todos as Categorias do sistema
- `POST` /categorias: cadastrar uma Categoria
- `GET` /categorias/{id}: retornar uma Categoria pelo seu ID
- `PUT` /categorias/{id}: atualizar uma Categoria pelo seu ID
- `DELETE` /categorias/{id}: apagar uma Categoria pelo seu ID

### Exemplo de JSON
```js
{
    "id" : long,
    "nomeCategoria": "string"
}
```

### Códigos de retorno
|codigo| significado
|-|-
|200 | dados retornados com sucesso
|201 | criado com sucesso
|204 | apagado com sucesso
|400 | dados inválidos
|404 | não encontrado


## Favoritos

Descrição dos endpoints de Favoritos

- `GET` /categorias: listar todos os Favoritos do sistema
- `POST` /categorias: cadastrar um Favorito
- `GET` /categorias/{id}: retornar um Favorito pelo seu ID
- `PUT` /categorias/{id}: atualizar um Favorito pelo seu ID
- `DELETE` /categorias/{id}: apagar um Favorito pelo seu ID

### Exemplo de JSON
```js
{
    "id" : long,
    "idFilme": long,
    "idUsuario": long
}
```

### Códigos de retorno
|codigo| significado
|-|-
|200 | dados retornados com sucesso
|201 | criado com sucesso
|204 | apagado com sucesso
|400 | dados inválidos
|404 | não encontrado