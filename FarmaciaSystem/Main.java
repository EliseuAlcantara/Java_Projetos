
import java.util.ArrayList;
import java.util.Scanner;

import farmaciasystem.controller.BancoDeDados;
import farmaciasystem.model.Item;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BancoDeDados banco = new BancoDeDados();
        
        String nome, tipo, vazString;
        int quantidade, codigo, escolha2;;

        ArrayList<Item> Itens = banco.ler();

        menu();
        
        int escolha = sc.nextInt();
        

    
    
        switch (escolha) {
            case 1:
                System.out.println("Qual o nome do produto?");
                vazString = sc.nextLine();

                nome = sc.nextLine();
                
                System.out.println("Qual o tipo do produto?");
                tipo = sc.nextLine();
                System.out.println("Qual a quantidade do produto?");
                quantidade = sc.nextInt();
                
                Item item = new Item(nome, quantidade, tipo);
                banco.cadastrar(item, true);
                System.out.println("\nMedicamento cadastrado com sucesso!!\n");
                break;
            //Editando medicamento
            case 2:
                System.out.println("\nEDITANDO...\n");
                System.out.println("Escolha o codigo do produto que gostaria de editar!\n");
                System.out.println("\n");

                //mostrando a lista de produto para o usuario escolher o produto a ser editado
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
                System.out.println(" ");

                //Escolhendo o indice do produto a ser editado
                codigo = sc.nextInt();

                //Escolhendo o que deseja editar
                System.out.println("O que deseja editar? \nNome[1]\nTipo[2]\nAmbos[3]");
                escolha = sc.nextInt();
                
                switch(escolha){

                    case 1:
                        System.out.println("Digite o novo nome:\n");
                        vazString = sc.nextLine();

                        nome = sc.nextLine();
                        Itens = banco.editar(codigo, Itens, nome, Itens.get(escolha).Gettipo(),Itens.get(escolha).Getquantidade());
                        System.out.println("\nLista atualizada\n");
                        Itens = banco.ler();
                        break;
                    case 2: 
                        System.out.println("Digite o novo Tipo:\n");
                        vazString = sc.nextLine();
                        tipo = sc.nextLine();
                        
                        Itens = banco.editar(codigo, Itens, Itens.get(escolha).Getnome(), tipo,Itens.get(escolha).Getquantidade());
                        System.out.println("\nLista atualizada\n");
                        Itens = banco.ler();
                        break;
                    default:
                        System.out.println("Digite o novo nome:\n");
                        nome = sc.nextLine();
                        System.out.println("Digite o novo Tipo:\n");
                        tipo = sc.nextLine();
                        Itens = banco.editar(codigo, Itens, nome, tipo, Itens.get(escolha).Getquantidade());
                        System.out.println("\nLista atualizada\n");
                        Itens = banco.ler();
                }
            //Excluindo medicamento
            case 3:
                System.out.println("Qual o codigo do produto que deseja excluir?");
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
                System.out.println(" ");
                escolha2 = sc.nextInt();
                banco.excluir(escolha2, Itens);
                System.out.println("Lista atualizada");
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
                System.out.println("\nMedicamento Excluido com sucesso!!\n");
            //Mostrando estoque
            case 4:
                System.out.println("\nESTOQUE DE REMEDIOS\n");
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
            //Adicionando item no estoque (quantidade no banco de dados)
            case 5:
                System.out.println("\nQual item gostaria de adicionar ao estoque?\n");
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
                codigo = sc.nextInt();
                System.out.println(" ");
                System.out.println("Qual a quantidade que deseja adicionar?");
                quantidade = sc.nextInt();
                quantidade = quantidade + Itens.get(codigo).Getquantidade();
                banco.editar(codigo, Itens, Itens.get(codigo).Getnome(), Itens.get(codigo).Gettipo(), quantidade);
                System.out.println("\nQuantidade adicionada com sucesso!\n");
            //Vendendo (Retirando unidades de medicamentos do banco de dados)
            case 6:
                System.out.println("\nQual item gostaria de retirar do estoque?\n");
                for(int i = 0; i<Itens.size(); i++){
                    System.out.println("Codigo - "+i+" - Nome: "+Itens.get(i).Getnome()+" - Quantidade: "+Itens.get(i).Getquantidade()+" - Tipo: "+Itens.get(i).Gettipo());
                }
                codigo = sc.nextInt();
                System.out.println(" ");
                System.out.println("Qual a quantidade que deseja vender?");
                quantidade = sc.nextInt();
                quantidade = quantidade + Itens.get(codigo).Getquantidade();
                banco.editar(codigo, Itens, Itens.get(codigo).Getnome(), Itens.get(codigo).Gettipo(), quantidade);
                System.out.println("\nMedicamento vendido com sucesso!\n");
        
        }

    }
       
    


    public static void menu(){
        
        System.out.println("\nO que gostaria de fazer?\n");
        System.out.println("Cadastrar medicamento [1]");
        System.out.println("Editar medicamento [2]");
        System.out.println("Excluir medicamento [3]");
        System.out.println("Visualizar estoque [4]");
        System.out.println("Adicionar Item ao estoque [5]");
        System.out.println("Realizar venda [6]");
        
    }

}
