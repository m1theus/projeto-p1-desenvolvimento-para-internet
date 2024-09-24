## Build do projeto

```bash
./mvnw clean install
```

## Rodando a aplicação

1. Rodando a aplicação usando Maven:

```bash
./mvnw spring-boot:run
```

`utilizando uma SERVER_PORT altearnativa`

```bash
SERVER_PORT=8082 ./mvnw spring-boot:run
```

2. Acessando o projeto:

- Default URL: http://localhost:8080

## Testando

### Cadastrar um veiculo

```bash
curl --location --request POST 'localhost:8080/veiculos' \
--header 'Content-Type: application/json' \
--data '{
	"placa": "100001",
	"modelo": "Uno",
	"marca": "Fiat",
	"cor": "Branca",
	"anoModelo": "2024",
	"anoFabricacao": "2024",
	"preco": 18909.02
}'
```

### Listar Veiculos

```bash
curl --location 'localhost:8080/veiculos'
```

### Buscar veiculo pela placa

```bash
curl --location 'localhost:8080/veiculos/100001'
```

### Atualizar um veiculo

```bash
curl --location --request PUT 'localhost:8080/veiculos/100001' \
--header 'Content-Type: application/json' \
--data '{
	"anoFabricacao": "2024",
	"preco": 38909.02
}'
```

### Deletar um veiculo

```bash
curl --location --request DELETE 'localhost:8080/veiculos/100001'
```

##

### Cadastrar um servico

```bash
curl --location --request POST 'localhost:8080/servicos' \
--header 'Content-Type: application/json' \
--data '{
	"descricao": "Manutencao preventiva",
	"placaVeiculo": "100001"
}'
```

### Listar servicos

```bash
curl --location 'localhost:8080/servicos'
```

### Buscar servico por id

```bash
curl --location 'localhost:8080/servicos/1'
```

### Atualizar um servico

```bash
curl --location --request PUT 'localhost:8080/servicos/1' \
--header 'Content-Type: application/json' \
--data '{
	"descricao": "Manutencao preventiva e alinhamento"
}'
```

### Deletar um servico

```bash
curl --location --request DELETE 'localhost:8080/servicos/1'
```
