import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> Itens;

    public Carrinho(){
        Itens = new ArrayList<>();
    }
    public void adicionarItem(Item item){
        Itens.add(item);
        System.out.println(item.getNome()+" Adicionado no Carrinho!\n");
    }
    public void removerItem(int codigo){
        for(int i = 0; i<Itens.size(); i++ ){
            if (i == codigo){
                
                System.out.println(Itens.get(i).getNome()+" Removido do Carrinho!\n");
                Itens.remove(i);
            }
            
        }
        
    }
    public void mostrarCarrinho(){
        System.out.println("\nProdutos no carrinho: \n");
        for(int i = 0; i<Itens.size(); i++){
            System.out.println(i+ " " + Itens.get(i).getNome()+" "+Itens.get(i).getPreco()+" "+Itens.get(i).getQuantidade());
        }
    }
    public Double calculoPrecoTotal(){
        Double total = 0.0;
        for(int i = 0; i<Itens.size(); i++){
            total += (Itens.get(i).getPreco())*(Itens.get(i).getQuantidade());
        }
        return total;
    }

    public void setQuantidade(int quantidade, int codigo){
        Itens.get(codigo).setQuantidade(quantidade);
    }
   
}
