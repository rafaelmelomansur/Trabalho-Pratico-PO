# Trabalho Prático — Sistema Hospitalar

## Contexto

Os avanços tecnológicos têm transformado significativamente a gestão de instituições de saúde, permitindo maior controle sobre atendimentos, prontuários e processos internos.

Hospitais modernos necessitam de sistemas capazes de organizar informações de pacientes, profissionais da saúde, consultas, internações e demais procedimentos realizados diariamente.

Um hospital de médio porte decidiu substituir seus registros manuais por um sistema informatizado que permita centralizar e gerenciar todas as informações relacionadas aos atendimentos realizados. O objetivo é melhorar a organização dos dados, reduzir erros operacionais e fornecer informações confiáveis para apoiar as atividades administrativas e médicas.

Para atender a essa necessidade, será desenvolvido um **Sistema de Informação Hospitalar** utilizando conceitos avançados de **Programação Orientada a Objetos (POO)**, arquitetura em camadas e desenvolvimento de APIs.

## Objetivo

Desenvolver, ao longo do semestre, um sistema completo para gerenciamento das operações de um hospital, contemplando:

- Modelagem orientada a objetos;

- Arquitetura em camadas: `Controller`, `Service`, `Repository` e `Model`;

- API REST com Spring Boot;

- Persistência em banco de dados;

- Tratamento de exceções;

- Testes automatizados.

> **Observação:** A modelagem proposta neste documento representa apenas os requisitos iniciais do sistema. Ao longo do desenvolvimento do projeto, novas necessidades poderão ser identificadas e incorporadas em versões posteriores da aplicação.

## Persistência de Dados

A aplicação deverá persistir suas informações em banco de dados.

Cada grupo poderá optar por uma das seguintes abordagens:

- Banco de dados relacional, como MySQL, PostgreSQL ou equivalente;

- Banco de dados não relacional orientado a documentos, como MongoDB.

A escolha deverá ser justificada tecnicamente na documentação do projeto.

Independentemente da tecnologia escolhida, a aplicação deverá utilizar uma **API REST desenvolvida com Spring Boot** para acesso aos dados.

## Escopo do Sistema

O sistema deve permitir:

- Gerenciamento de pacientes;

- Gerenciamento de profissionais da saúde;

- Agendamento e controle de consultas;

- Controle de internações;

- Gerenciamento de quartos hospitalares;

- Controle de disponibilidade de atendimento;

- Registro do histórico de atendimentos dos pacientes;

- Consulta de informações médicas e administrativas.

## Regras de Negócio

1. Um paciente poderá possuir diversas consultas e internações ao longo do tempo.

1. As consultas deverão estar associadas a um profissional da saúde responsável e a um paciente.

1. Um profissional não poderá possuir dois atendimentos agendados para o mesmo horário.

1. Uma internação deverá estar associada a um paciente e a um quarto disponível.

1. Um quarto não poderá ultrapassar sua capacidade máxima de ocupação.

1. O sistema deverá manter o histórico de consultas e internações dos pacientes.

1. Todas as operações realizadas deverão respeitar as regras de disponibilidade de recursos e integridade dos dados.

## Características e Requisitos do Sistema

### 1. Paciente

O sistema deverá armazenar, no mínimo:

- Nome;

- CPF;

- Data de nascimento;

- Telefone;

- Endereço;

- E-mail para contato.

### 2. Profissional da Saúde

O sistema deverá armazenar, no mínimo:

- Nome;

- Registro profissional;

- Especialidade;

- Telefone;

- E-mail para contato.

### 3. Consulta

Uma consulta deverá possuir, no mínimo:

- Paciente;

- Profissional responsável;

- Data;

- Horário;

- Motivo da consulta;

- Observações médicas.

### 4. Internação

Uma internação deverá possuir, no mínimo:

- Paciente;

- Profissional responsável;

- Quarto;

- Data de entrada;

- Data prevista de alta;

- Data efetiva de alta;

- Observações.

### 5. Quarto

Um quarto deverá possuir, no mínimo:

- Número de identificação;

- Andar;

- Capacidade máxima de pacientes;

- Situação atual: disponível ou ocupado.

### 6. Histórico Médico

O sistema deverá permitir consultar o histórico de um paciente contendo:

- Consultas realizadas;

- Internações realizadas;

- Informações relevantes registradas durante os atendimentos.
