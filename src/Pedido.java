import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> itens =  new ArrayList<>();

    private boolean fechado;

    public boolean isFechado() {
        return fechado;
    }

    public void adicionarItem(Item item) {
        limiteItens();
        garantirPedidoAberto();
        itens.add(item);
    }

    public void  removerItem(String nome) {

        garantirPedidoAberto();

        for(Item i : itens) {
            if(i.getNome().equals(nome)) {
                itens.remove(i);
                System.out.println(i.getNome() + " removido do pedido.");
                return;
            }
        }
        System.out.println(nome + " não está no seu pedido!");
    }

    public void listar() {
        System.out.println("|====Lista de itens====|");
        for(Item i : itens) {
            System.out.println("Nome: " + i.getNome());
            System.out.println("Preco: " + i.getPreco());
        }
        System.out.println("|======================|");
    }

    public double calcularTotal(){
        double total = 0;
        for(Item i : itens) {
            total += i.getPreco();
        }

        if(total > 50) {
            total = total - total * 0.10;
        }
        return total;
    }

    public void fecharPedido(){
        if(itens.isEmpty()){
            System.out.println("Seu pedido está vazio e não pode ser fechado!");
            return;
        }
        fechado = true;
    }

    private void garantirPedidoAberto() {
        if (fechado) {
            throw new PedidoFechadoException("Pedido já fechado, não é possível alterar.");
        }
    }

    private void limiteItens() {
        if(itens.size() >= 10) {
            throw new LimiteDeItensException("Limite de 10 itens atingido! \n");
        }
    }
}
