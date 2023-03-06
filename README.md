# HotelEstelar

Esse projeto tem por objetivo realizar o controle de reservas do Hotel Estelar.

## Endpoints

- Unidades
  - Listar
- Acomodacoes
  - Listar
- Filtros
  - Listar
- Resumo
  - Listar
- Confirmação de Reserva
  - Cadastrar reserva
- Minhas Reservas
  - Listar
  - Ver detalhes
  - Apagar
  - Atualizar

## Listar Unidade

`GET` /hotelestelar/api/unidades/listar

## Listar Acomodacoes

`GET` /hotelestelar/api/acomodacoes/listar

## Listar Filtros

`GET` /hotelestelar/api/filtros/listar

## Listar Resumo

`GET` /hotelestelar/api/resumo/listar

## Cadastrar Reserva

`POST`/hotelestelar/api/reserva/cadastrar

## Listas Reservas

`GET` /hotelestelar/api/minhas-reservas/listar

## Ver Detalhes da Reserva

`GET` /hotelestelar/api/minha-reserva/detalhes/{id}

## Apagar Minha Reserva

`DELETE` /hotelestelar/api/minha-reserva/apagar/{id}

## Atualizar Minha Reserva

`PUT` /hotelestelar/api/minha-reserva/atualizar

## Listas Reservas

`GET` /hotelestelar/api/minhas-reservas/listar
