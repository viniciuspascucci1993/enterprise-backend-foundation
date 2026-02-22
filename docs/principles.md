# Princípios de Engenharia

## 1. Arquitetura com foco em contêineres

Todos os serviços devem ser executados dentro de contêineres.

Nenhum serviço deve depender da configuração da máquina local.

---

## 2. Observabilidade por padrão

Logs, métricas e endpoints de integridade são obrigatórios.

Nenhum serviço deve ser implantado sem recursos de observabilidade.

---

## 3. Segurança por padrão

A configuração de segurança deve existir desde a inicialização do projeto.

Fundamentos de autenticação e autorização não são opcionais.

---

## 4. Infraestrutura como código

Toda a infraestrutura deve ser versionada e reproduzível.

A configuração manual na nuvem é desencorajada.

---

## 5. Paridade de ambientes

Os ambientes de desenvolvimento, homologação e produção devem ser o mais semelhantes possível.

Não são permitidas soluções alternativas específicas para cada ambiente.

---

## 6. Implantações imutáveis

Os aplicativos devem ser empacotados como imagens de contêiner imutáveis.

Modificações em tempo de execução não são permitidas.

---

## 7. Automação em vez de trabalho manual

Construções, testes e implantações devem ser automatizados.

A intervenção humana deve ser minimizada.

---

## 8. Arquitetura evolutiva

Espera-se que a plataforma evolua.

Refatorações e melhorias arquitetônicas são incentivadas.