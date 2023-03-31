# HotelEstelar

Esse projeto tem por objetivo realizar o controle de reservas do Hotel Estelar.

## Endpoints

- Reserva
  - [Cadastrar nova reserva](#cadastrar-reserva)
  - [Listar minhas reservas](#listar-reservas)
  - [Ver detalhes da minha reserva](#ver-detalhes-da-reserva)
  - [Apagar minha reserva](#apagar-minha-reserva)
  - [Atualizar minha reserva](#atualizar-minha-reserva)

## Cadastrar Nova Reserva

`POST` /hotelestelar/api/reserva/cadastrar

| campo                 | tipo           | obrigatório | descrição                                                                     |
| --------------------- | -------------- | ----------- | ----------------------------------------------------------------------------- |
| id                    | Long            | sim         | é o identificador unico de uma reserva                                        |
| unidade               | String         | sim         | unidade onde está localizada a reserva                                        |
| dataReserva           | data           | sim         | data em que foi realizada a reserva                                           |
| dataInicio            | data           | sim         | data do inicio da estadia                                                     |
| dataFim               | data           | sim         | data do fim da estadia                                                        |
| acomodacao            | String         | sim         | descricao do tipo de acomodacao                                               |
| informacoesAdicionais | List<boolean"> | sim         | indicação se há ou não as acomodações existentes, sendo 1 pra sim e 2 pra não |
| valorTotal           | BigDecimal        | sim         | valor total da reserva                                                        |

**Exemplo do corpo de Request**

```js
{
    "idReserva": 1,
    "unidade": "São Paulo",
    "dataReserva":"2023-03-06",
    "dataInicio":"2024-01-01",
    "dataFim":"2024-01-02",
    "acomodacao":"quarto de luxo familia",
    "informacoesAdicionais": {
        "aceitaPet":1,
        "possuiWifi":0,
        "possuiEscritorio":0,
        "possuiArCondicionado":1,
        "ehBeiraMar":1,
        "possuiMaquinaDeLavar":0,
        "possuiFerroDePassar":0,
        "possuiTv":1,
        "possuiSecadora":0,
        "possuiTerraco":1,
        "possuiBerco":0,
        "possuiLareira":0
    }
    "valorTotal":2300
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | reserva realizada com sucesso
| 400 | erro na validação dos dados da requisição

## Listar Minhas Reservas

`GET` /hotelestelar/api/minhas-reservas

**Exemplo do corpo do Response**

```js
{
    "id": 1,
    "reservas": {
        {
            "idReserva": 1,
            "unidade": "São Paulo",
            "dataReserva":"2023-03-06",
            "dataInicio":"2024-01-01",
            "dataFim":"2024-01-02",
            "acomodacao":"quarto de luxo familia",
            "informacoesAdicionais": {
                "aceitaPet":1,
                "possuiWifi":0,
                "possuiEscritorio":0,
                "possuiArCondicionado":1,
                "ehBeiraMar":1,
                "possuiMaquinaDeLavar":0,
                "possuiFerroDePassar":0,
                "possuiTv":1,
                "possuiSecadora":0,
                "possuiTerraco":1,
                "possuiBerco":0,
                "possuiLareira":0
            }
            "valorTotal":2300,
        },
        {
            "idReserva": 2,
            "unidade": "Rio de Janeiro",
            "dataReserva":"2022-12-11",
            "dataInicio":"2023-09-19",
            "dataFim":"2023-09-25",
            "acomodacao":"quarto de luxo familia",
            "informacoesAdicionais": {
                "aceitaPet":0,
                "possuiWifi":1,
                "possuiEscritorio":1,
                "possuiArCondicionado":0,
                "ehBeiraMar":0,
                "possuiMaquinaDeLavar":1,
                "possuiFerroDePassar":1,
                "possuiTv":1,
                "possuiSecadora":1,
                "possuiTerraco":1,
                "possuiBerco":0,
                "possuiLareira":0
            }
            "valorTotal":1900,
        }
    }
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foram encontradas reservas com id informado

## Ver Detalhes da Reserva

`GET` /hotelestelar/api/reserva/detalhes/{idReserva}

**Exemplo do corpo de Response**

```js
{
    "idReserva": 1,
    "unidade": "São Paulo",
    "dataReserva":"2023-03-06",
    "dataInicio":"2024-01-01",
    "dataFim":"2024-01-02",
    "acomodacao":"quarto de luxo familia",
    "informacoesAdicionais": {
        "aceitaPet":1,
        "possuiWifi":0,
        "possuiEscritorio":0,
        "possuiArCondicionado":1,
        "ehBeiraMar":1,
        "possuiMaquinaDeLavar":0,
        "possuiFerroDePassar":0,
        "possuiTv":1,
        "possuiSecadora":0,
        "possuiTerraco":1,
        "possuiBerco":0,
        "possuiLareira":0
    }
    "valorTotal":2300
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada reserva com id informado

## Apagar Minha Reserva

`DELETE` /hotelestelar/api/minha-reserva/apagar/{idReserva}

**Exemplo do corpo de Request**

```js
{
    "idReserva": 1,
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | reserva deletada com sucesso
| 400 | não foi encontrada reserva com id informado

## Atualizar Minha Reserva

`PUT` /hotelestelar/api/minha-reserva/atualizar

**Exemplo do corpo de Request**

#### Alguns campos não podem ser alterados pelo usuário, como a data da reserva e o id.

```js
{
    "idReserva": 1,
    "unidade": "São Paulo",
    "dataReserva":"2023-03-06",
    "dataInicio":"2024-01-02",
    "dataFim":"2024-01-03",
    "acomodacao":"quarto de luxo familia",
    "informacoesAdicionais": {
        "aceitaPet":1,
        "possuiWifi":0,
        "possuiEscritorio":0,
        "possuiArCondicionado":1,
        "ehBeiraMar":1,
        "possuiMaquinaDeLavar":0,
        "possuiFerroDePassar":0,
        "possuiTv":1,
        "possuiSecadora":0,
        "possuiTerraco":1,
        "possuiBerco":0,
        "possuiLareira":0
    }
    "valorTotal":2400
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | reserva atualizada com sucesso
| 400 | não foi encontrada reserva com id informado
