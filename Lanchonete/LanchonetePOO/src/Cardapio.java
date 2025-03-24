import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Item> cardapio;
    public Cardapio(){
        cardapio = new ArrayList<>();
    }
    public void adicionarItemCardapio(int codigo, String nome, double preco){
        Item it1 = new Item(codigo, nome, preco);
        cardapio.add(it1);
    }
    public void removerItemCardapio(int codigo){
        for(int i = 0; i<cardapio.size(); i++){
            if(cardapio.get(i).getCodigo() == codigo){
                cardapio.remove(i);
            }
        }
    }
   
    public void mostrarCardapio(){
        for(int i = 0; i < cardapio.size(); i++){
            System.out.println(cardapio.get(i).getCodigo()+" "+cardapio.get(i).getNome()+".........."+cardapio.get(i).getPreco());
        }
    }
    public Item buscarItem(int cod){
        for(int i = 0; i<cardapio.size(); i++){
            if(cardapio.get(i).getCodigo() == cod){
                return cardapio.get(i);
            }
        }
        return cardapio.get(0);
    }
    public int quantidadeItensCardapio(){
        return cardapio.size();
    }

}
