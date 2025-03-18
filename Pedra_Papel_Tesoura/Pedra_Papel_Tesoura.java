package Pedra_Papel_Tesoura;
import java.util.Scanner;
import java.util.Random;

public class Pedra_Papel_Tesoura {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        int Vitoriasjogador = 0;
        int VitoriasComputador = 0;

        boolean Gameover = false;
        System.out.println("Bem vindo ao Pedra-Papel-Tesoura ");
        while(Gameover == false){
        int JogadaAdversario = gerador.nextInt(3);
        
        System.out.println( "Escolha sua jogada: ");
        System.out.println("Pedra [0] Papel[1] Tesoura[2]");
    
        int Player = sc.nextInt();

        switch (Player) {
            case 0: 
                if(JogadaAdversario == 0){
                    System.out.println("\nDeu empate, também escolhi Pedra!\n");
                    break;
                }
                else if(JogadaAdversario == 1){
                    System.out.println("\nEu ganhei, escolhi Papel!\n");
                    VitoriasComputador++;
                    break;
                }
                else{
                    System.out.println("\nVocê ganhou, eu escolhi Tesoura!\n");
                    Vitoriasjogador++;
                    break;
                }
                
            case 1: 
            if(JogadaAdversario == 1){
                System.out.println("\nDeu empate, também escolhi Pedra!\n");
                break;
            }
            else if(JogadaAdversario == 2){
                System.out.println("\nEu ganhei, escolhi Papel!\n");
                VitoriasComputador++;
                break;
            }
            else{
                System.out.println("\nVocê ganhou, eu escolhi Tesoura!\n");
                Vitoriasjogador++;
                break;
            }
            
            case 2: 
                if(JogadaAdversario == 2){
                    System.out.println("\nDeu empate, também escolhi Pedra!\n");
                    break;
                }
                else if(JogadaAdversario == 0){
                    System.out.println("\nEu ganhei, escolhi Papel!\n");
                    VitoriasComputador++;
                    break;
                }
                else{
                    System.out.println("\nVocê ganhou, eu escolhi Tesoura!\n");
                    Vitoriasjogador++;
                    break;
                }
            default:
                break;
        }
        System.out.println("\n\nPLACAR \n\nJogador1 = " + Vitoriasjogador);
        System.out.println("Computador = " + VitoriasComputador + "\n\n");
        System.out.println("Deseja jogar novamente? [S][N]");
        String s = sc.nextLine();
        String resposta = sc.nextLine();
        if(resposta == "s" || resposta == "S"){
            Gameover = false;
        }
        else{
            Gameover = true;
            System.out.println("Fim de jogo! Foi uma honra jogar com você");
        }
    }
    }
    
}
