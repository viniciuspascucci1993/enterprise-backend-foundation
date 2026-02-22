# Roteiro

## Fase 1 — Fundamentos da Empresa Local

- Modelo básico do Spring Boot
- Dockerfile
- Docker Compose
- Contêiner PostgreSQL
- Contêiner Redis
- Verificações de integridade
- Padrão básico de registro de logs

---

## Fase 2 — Pilha de Observabilidade

- Registro de logs em JSON estruturado
- Integração com Prometheus
- Painéis do Grafana
- Loki para registro de logs centralizado
- Capacidade básica de rastreamento

---

## Fase 3 — Automação de CI/CD

- Pipeline do GitHub Actions
- Automação de build e teste
- Criação de imagem Docker
- Envio de dados para o registro de contêineres
- Varredura de segurança (aprimoramento futuro)

---

## Fase 4 — Suporte a Múltiplos Ambientes

- Configuração de Desenvolvimento/Staging/Produção
- Separação de perfis
- Estratégia de gerenciamento de segredos

---

## Fase 5 — Infraestrutura em Nuvem

- Estrutura de projeto Terraform
- Provisionamento de VPC na AWS
- Implantação do ECS
- Integração com o RDS
- IAM Configuração

---

## Fase 6 — Recursos Avançados da Plataforma

- Rastreamento distribuído (OpenTelemetry)
- Padrões de resiliência (tentativa e erro, disjuntor)
- Limitação de taxa
- Integração com broker de mensagens
- Autenticação serviço a serviço
