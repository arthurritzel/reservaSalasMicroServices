# Reserva de Salas - Microserviços

Este é um sistema de reserva de salas arquitetado em microserviços. O projeto utiliza um monorepo, onde cada microserviço possui seu próprio Dockerfile e banco de dados independente. A orquestração dos serviços é feita por meio do Docker Compose.


## Estrutura do Projeto

```
reserva-salas/
│-- SalaMicroService/
|   ├──sala/
│     ├── Dockerfile
│     ├── src/
│-- UserMicroService/ 
|   ├──user/
│     ├── Dockerfile
│     ├── src/
│-- ReservaMicroService/
|   ├──reserva/
│     ├── Dockerfile
│     ├── src/
│-- docker-compose.yml 
│-- README.md          
```

---

## Tecnologias Utilizadas
- **Adminer** (para gerenciar os bancos de dados)
- **PostgreSQL** (um banco para cada serviço)
- **Docker & Docker Compose**
- **Java 17**
- **Spring Boot 3.4.3**


## Como Rodar o Projeto 🚀

### 1️⃣  **Rodar todos os serviços com Docker Compose**
```sh
docker-compose up -d --build
```
Isso irá subir:
- **3 microserviços** 
- **3 bancos de dados PostgreSQL**
- **Adminer** para gestão do banco

### **Acessar o Adminer** (Gerenciador de Banco)
- URL: `http://localhost:8080`
- Sistema: **PostgreSQL**
- Servidor: **dbuser**, **dbsala**, **dbreserva**
- Usuário: **postgres**
- Senha: **admin**
- Base de Dados: **usersdb**, **salasdb**, **reservasdb**

---

## Testando as APIs no Postman

### **📌 SalaService (`8082`)**
#### **Criar uma Sala**
**POST** `http://localhost:8082/salas`
```json
{
  "nome": "Sala de estudos 5",
  "capacidade": 20
}
```

#### **Listar Salas**
**GET** `http://localhost:8082/salas`

---

### **📌 UserService (`8081`)**
#### **Criar um Usuário**
**POST** `http://localhost:8081/users`
```json
{
  "nome": "Arthur",
  "email": "ritzel@email.com",
  "senha": "123456",
  "telefone": "11987654321",
  "rua": "Rua Pinto bandeira",
  "numero": "2342352",
  "cidade": "Xaxin",
  "cep": "01010-010",
  "cpf": "234543234523-53",
  "dataNascimento": "1995-06-10",
  "dataCadastro": "2024-02-25"
}
```

#### **Listar Usuários**
**GET** `http://localhost:8081/users`

---

### **📌 ReservaService (`8083`)**
#### **Criar uma Reserva**
**POST** `http://localhost:8083/reservas/salvar
```json
{
  "dataHora": "2025-02-04T15:00:00",
  "sala_id": 1,
  "usuario_id": 1
}
```

#### **Listar Reservas**
**GET** `http://localhost:8083/reservas`

---



