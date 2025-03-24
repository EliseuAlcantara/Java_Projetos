import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int pedido, quantidade, numeropedido = 0;
        boolean finalizarPedido = false;
        Scanner sc = new Scanner(System.in); 
        Carrinho carrinho = new Carrinho();    
        Cardapio cardapio = new Cardapio();
        
        cardapio.adicionarItemCardapio(1, "Hamburguer", 26.99);
        cardapio.adicionarItemCardapio(2, "Combo 1", 41.99);
        cardapio.adicionarItemCardapio(3, "Combo 2", 54.99);
        cardapio.adicionarItemCardapio(4, "Coca-Cola", 6.99);
        cardapio.adicionarItemCardapio(5, "Pepsi", 5.99);
        


        System.out.println("\nBem vindo a lanchonete, esse é o cardapio, o que gostaria de pedir?\n\n");
        
        
        
        while(finalizarPedido == false){
            cardapio.mostrarCardapio();
            System.out.println((cardapio.quantidadeItensCardapio() + 1) + " Para remover um produto");
            System.out.println((cardapio.quantidadeItensCardapio() + 2) + " Para fechar o carrinho");

            System.out.println("Escolha o numero do pedido desejado: \n");

            pedido = sc.nextInt();

            //Caso queira retirar produto do carrinho
            if(pedido == (cardapio.quantidadeItensCardapio() + 1)){
                carrinho.mostrarCarrinho();
                System.out.println("\nQual produto deseja retirar? \n");
                pedido = sc.nextInt();
                
                carrinho.removerItem(pedido);
            }
            //Caso queira fechar o carrinho
            else if(pedido == (cardapio.quantidadeItensCardapio() + 2)){
                finalizarPedido = true;
                System.out.println("Carrinho Fechado");
                carrinho.mostrarCarrinho();
            }
            //Caso queira continuar comprando
            else{
             System.out.println("Escolha a quantidade: ");
             quantidade = sc.nextInt();
             carrinho.adicionarItem(cardapio.buscarItem(pedido));
             carrinho.setQuantidade(quantidade, numeropedido);
            }
            numeropedido++;
        }
        
        System.out.println("\nO valor do carrinho ficou R$ "+carrinho.calculoPrecoTotal());
        sc.close();
    }   
}
