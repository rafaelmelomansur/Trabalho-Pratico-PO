# Sistema Hospitalar — API da Sprint 2

Backend Spring Boot da Sprint 2 do Trabalho Prático — Sistema Hospitalar.

## O que foi implementado

- Classes de domínio para pacientes, profissionais, consultas, internações e quartos;
- Categorias `CLINICO_GERAL`, `ESPECIALISTA` e `CIRURGIAO`;
- Modalidades de consulta de rotina, consulta especializada e emergência;
- Procedimentos cirúrgicos com ciclo de vida próprio;
- Situações de consulta representadas por enum;
- Regras de disponibilidade, compatibilidade de especialidade, capacidade de quarto e transição de status;
- Endpoints REST em memória.

## Como executar

Requisitos: Java 17 e Maven 3.9+.

```bash
cd backend
mvn test
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET/POST | `/pacientes` | Listar e cadastrar pacientes |
| GET/POST | `/profissionais` | Listar e cadastrar profissionais |
| GET/PATCH | `/consultas/{id}` | Consultar e alterar situação |
| GET/POST | `/consultas` | Listar e cadastrar consultas |
| GET/POST | `/internacoes` | Listar e cadastrar internações |
| GET/POST | `/quartos` | Listar e cadastrar quartos |
| GET/POST/PATCH | `/procedimentos-cirurgicos` | Gerenciar procedimentos cirúrgicos |

Os dados são armazenados em memória e reiniciados ao parar a aplicação. A persistência em MySQL, PostgreSQL ou MongoDB deverá ser definida e justificada em uma Sprint posterior.

## Exemplo de consulta de emergência

```json
{
  "pacienteId": 1,
  "profissionalId": 2,
  "data": "2026-11-10",
  "horario": "14:00:00",
  "modalidade": "EMERGENCIA",
  "motivo": "Dor torácica",
  "prioridade": "ALTA"
}
```
