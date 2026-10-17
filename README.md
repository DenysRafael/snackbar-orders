# 🍔 Snack Bar Orders

Sistema de pedidos de lanchonete em **Java puro**, sem frameworks e sem banco de dados. Os dados ficam em memória, e o foco do projeto é praticar **orientação a objetos**, **regras de negócio** e **tratamento de erros com exceções próprias**.

## ✨ Funcionalidades

- Adicionar e remover itens de um pedido
- Listar os itens do pedido
- Calcular o total do pedido
- Fechar o pedido

## 📏 Regras de negócio

| Regra | Comportamento |
|---|---|
| **Limite de itens** | Um pedido aceita no máximo **10 itens**. Tentar adicionar o 11º lança `LimiteDeItensException` |
| **Desconto** | Pedidos com total **acima de R$ 50,00** recebem **10% de desconto**. Exatamente R$ 50,00 não recebe |
| **Fechamento** | Um pedido **vazio** não pode ser fechado |
| **Pedido fechado** | Depois de fechado, não aceita adicionar nem remover itens e lança `PedidoFechadoException` |

## 🗂️ Estrutura do projeto

```
src/
├── Item.java                       # Produto do cardápio (nome e preço)
├── Pedido.java                     # Regras de negócio do pedido
├── PedidoFechadoException.java     # Erro: alteração em pedido fechado
├── LimiteDeItensException.java     # Erro: passou do limite de 10 itens
└── Main.java                       # Testes organizados por regra
```

## 🧠 Conceitos praticados

- Encapsulamento: atributos privados, getters e métodos que protegem o estado
- Coleções: `List` e `ArrayList`
- Métodos privados para reaproveitar validações
- Exceções próprias com `extends RuntimeException`
- Tratamento de erros com `try/catch`

## ▶️ Como executar

1. Clone o repositório:
```bash
   git clone https://github.com/SEU-USUARIO/snackbar-orders.git
```
2. Abra a pasta no **IntelliJ IDEA** (ou outra IDE Java)
3. Execute o método `main` da classe `Main`

## 🧪 Exemplo de saída

```
=== 4. Desconto de 10% acima de R$50 ===
Acima de 50: R$54.0
Exatamente 50: R$50.0
Abaixo de 50: R$6.0

=== 7. Pedido fechado lança exceção ===
Erro ao adicionar: Pedido já fechado, não é possível alterar.
Erro ao remover: Pedido já fechado, não é possível alterar.
```

## 🚧 Próximos passos

- Trocar os avisos restantes (item inexistente e pedido vazio) por exceções
- Adicionar testes automatizados com JUnit
- Evoluir o projeto para uma API REST
