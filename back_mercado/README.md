# back_mercado (backend)

Este repositório contém um backend Spring Boot mínimo para o frontend `projeto_mercado`.

Funcionalidades implementadas
- Endpoints REST básicos para produtos, contato e pedidos.
- H2 in-memory configurado por padrão para desenvolvimento.
- Validação básica dos payloads com retornos de erro amigáveis.

Endpoints principais
- GET /api/products
- GET /api/products/{id}
- POST /api/products
- POST /api/contact
- POST /api/orders

Como rodar localmente
1. Tenha Java 17+ e Maven instalados.
2. Na pasta do projeto execute:

```powershell
mvn -DskipTests package
mvn spring-boot:run
```

3. A aplicação estará disponível em http://localhost:8080

H2 console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:mercado`, user: `sa`, senha vazia)

Observações e próximos passos
- Alinhar nomes de rotas e formatos de payload com o frontend: se o frontend espera rotas diferentes, cole aqui `services/api.js` ou mova o frontend para o workspace e eu ajusto os controllers.
- Melhorias recomendadas: DTOs mais ricos, testes de integração, autenticação, paginação, relacionamento Order -> OrderItem e upload de imagens.

Quick examples (curl)

- List products

```bash
curl -sS http://localhost:8080/api/products | jq '.'
```

- Search products by name (query param `q`)

```bash
curl -sS "http://localhost:8080/api/products?q=arroz" | jq '.'
```

- Get product by id

```bash
curl -sS http://localhost:8080/api/products/1 | jq '.'
```

- Create contact message

```bash
curl -sS -X POST http://localhost:8080/api/contact -H "Content-Type: application/json" -d '{"name":"João","email":"joao@example.com","message":"Oi"}' | jq '.'
```

- Create order (simple)

```bash
curl -sS -X POST http://localhost:8080/api/orders -H "Content-Type: application/json" -d '{"customerName":"Maria","itemsJson":"[{\"productId\":1,\"qty\":2}]","total":59.8}' | jq '.'
```

OpenAPI / Swagger UI

If `springdoc` is available and the app runs, you can view interactive docs at:

- http://localhost:8080/swagger-ui.html
- or http://localhost:8080/swagger-ui/index.html

Run tests and build

```powershell
mvn -DskipTests package
mvn test
mvn spring-boot:run
```

Notes about the environment

- I couldn't run `mvn` in this environment because `mvn` isn't available here; run the commands above locally. If you paste any errors from `mvn test` or `mvn package` I will iterate and fix them.

