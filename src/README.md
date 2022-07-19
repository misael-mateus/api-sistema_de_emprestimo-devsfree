# Challenge DevsFree #4

- REST API para Emprestimo Bancário

## Stack

- Gradle 4.4.1
- Java 17
- Spring Boot 2.7.1

## Proposta da Aplicação

- Disponibilizar emprestimo para algumas pessoas seguinda algumas regras de negócio:

Salário   | Emprestimo Pessoal | Emprestimo c/ garantia | Emprestimo Consignado
--------- |--------------------|------------------------| -------------
`Salário < 3000`  | `SIM`      | `SIM - @@@`            | `NÃO`
`Salário >= 3000` | `SIM`      | `SIM - @@`             | `NÃO`
`Salário >= 5000` | `SIM`      | `SIM - @`              | `SIM`

### Regras Adicionais:
1. @@@ = Clientes com menos de 30 anos de idade que residem em "SP".
2. @@ = Clientes que residem em "SP".
3. @ = Clientes com menos de 30 anos de idade.

## Instruções

Método  | Endpoint                              | Descrição  
--------- |---------------------------------------| -----------
POST  | `localhost:8080/emprestimos/cliente ` | Insira no corpo da requisição um cliente, seguindo o modelo a seguir.
GET  | `localhost:8080/emprestimos/modelo`   | Retorna o modelo de cliente para ser inserido no corpo da requisição.

## Modelo
``` json
{
    "name": "João",
    "cpf": "SP",
    "age": 20,
    "uf": "SP",
    "rendaMensal": 6000
}
```

![Postman Example](images/Captura%20de%20tela%20de%202022-07-19%2014-41-00.png)

## Port

- Default port 8080

