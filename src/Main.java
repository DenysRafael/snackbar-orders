public class Main {

    public static void main(String[] args) {
        testeItem();
        testeAdicionarERemover();
        testeTotal();
        testeDesconto();
        testeLimiteDe10();
        testeFecharPedido();
        testeBloqueioPedidoFechado();
        testeSucessoNaoMente();
    }

    static void titulo(String texto) {
        System.out.println();
        System.out.println("=== " + texto + " ===");
    }

    static void testeItem() {
        titulo("1. Item");
        Item item = new Item("X-Burger", 20.0);
        System.out.println(item.getNome() + " custa R$" + item.getPreco());
    }

    static void testeAdicionarERemover() {
        titulo("2. Adicionar e remover");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Item("X-Burger", 20.0));
        pedido.adicionarItem(new Item("Refri", 6.0));
        pedido.adicionarItem(new Item("Batata", 12.0));
        pedido.listar();

        pedido.removerItem("Refri");
        pedido.removerItem("Pizza");
        pedido.listar();
    }

    static void testeTotal() {
        titulo("3. Total sem desconto");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Item("X-Burger", 20.0));
        pedido.adicionarItem(new Item("Refri", 6.0));
        pedido.adicionarItem(new Item("Batata", 12.0));
        System.out.println("Total: R$" + pedido.calcularTotal());

        pedido.removerItem("Refri");
        System.out.println("Total: R$" + pedido.calcularTotal());
    }

    static void testeDesconto() {
        titulo("4. Desconto de 10% acima de R$50");

        Pedido acima = new Pedido();
        acima.adicionarItem(new Item("X-Burger", 20.0));
        acima.adicionarItem(new Item("X-Burger", 20.0));
        acima.adicionarItem(new Item("X-Burger", 20.0));
        System.out.println("Acima de 50: R$" + acima.calcularTotal());

        Pedido exato = new Pedido();
        exato.adicionarItem(new Item("Combo", 50.0));
        System.out.println("Exatamente 50: R$" + exato.calcularTotal());

        Pedido abaixo = new Pedido();
        abaixo.adicionarItem(new Item("Refri", 6.0));
        System.out.println("Abaixo de 50: R$" + abaixo.calcularTotal());
    }

    static void testeLimiteDe10() {
        titulo("5. Limite de 10 itens");
        Pedido pedido = new Pedido();
        for (int i = 1; i <= 10; i++) {
            pedido.adicionarItem(new Item("Item " + i, 1.0));
        }
        pedido.listar();

        try {
            pedido.adicionarItem(new Item("Item 11", 1.0));
        } catch (LimiteDeItensException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void testeFecharPedido() {
        titulo("6. Fechar pedido");
        Pedido pedido = new Pedido();

        pedido.fecharPedido();
        System.out.println("Fechado? " + pedido.isFechado());

        pedido.adicionarItem(new Item("X-Burger", 20.0));
        pedido.fecharPedido();
        System.out.println("Fechado? " + pedido.isFechado());
    }

    static void testeBloqueioPedidoFechado() {
        titulo("7. Pedido fechado lança exceção");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Item("X-Burger", 20.0));
        pedido.fecharPedido();

        try {
            pedido.adicionarItem(new Item("Refri", 6.0));
        } catch (PedidoFechadoException e) {
            System.out.println("Erro ao adicionar: " + e.getMessage());
        }

        try {
            pedido.removerItem("X-Burger");
        } catch (PedidoFechadoException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }

        pedido.listar();
    }

    static void testeSucessoNaoMente() {
        titulo("8. A mensagem de sucesso não aparece quando falha");
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Item("X-Burger", 20.0));
        pedido.fecharPedido();

        try {
            pedido.adicionarItem(new Item("Refri", 6.0));
            System.out.println("Item adicionado com sucesso!");
        } catch (PedidoFechadoException e) {
            System.out.println("Não adicionou: " + e.getMessage());
        }
    }
}