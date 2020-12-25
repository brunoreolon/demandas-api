# API REST
Api para o cadastro de demandas, onde um usuário cadastra uma demanda, em seguida o coordenador ira aprovar ou reprovar a mesma, depois os usuários poderam se increver em uma demanda para enviar uma solução.

## Request e Response

### API Resources
#### Usuario
- POST /usuario/
- GET /usuario
- GET /usuario/[id]
- PUT /usuario/[id]
- DELETE /usuario/[id]

#### Demanda
- POST /demandas/
- GET /demandas
- GET /demandas/[id]
- PUT /demandas/[id]
- DELETE /demandas/[id]

#### Coordenador
- GET /coordenador
- PATCH /coordenador/[id]/status
