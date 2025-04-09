package farmaciasystem.controller;

import farmaciasystem.model.Item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class BancoDeDados {



    public void cadastrar(Item item, boolean opcao){
        try {
            OutputStream os = new FileOutputStream("Lista_medicamentos.txt", opcao);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String linha = item.Getnome()+","+item.Getquantidade() + ","+ item.Gettipo();
            
            bw.write(linha);
            bw.newLine();
            
            bw.close();
            osw.close();
            os.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public ArrayList<Item> editar(int codigo, ArrayList<Item> Itens, String nome, String tipo, int quant){
        
        Item itemnovo = new Item(nome, quant, tipo);
        Itens.remove(codigo);
        
        Itens.add(codigo, itemnovo);
        
        for(int i = 0; i<Itens.size(); i++){
            Item item = new Item(Itens.get(i).Getnome(), Itens.get(i).Getquantidade(), Itens.get(i).Gettipo());
            if(i == 0){
                cadastrar(item, false);
            }else{
                cadastrar(item, true);
            }
        }
        
        System.out.println("Produto editado com sucesso!!");
        return Itens;
    }
    public void excluir(int codigo, ArrayList<Item> Itens){
        Itens.remove(codigo);

        for(int i = 0; i<Itens.size(); i++){
            Item item = new Item(Itens.get(i).Getnome(), Itens.get(i).Getquantidade(), Itens.get(i).Gettipo());
            if(i == 0){
                cadastrar(item, false);
            }else{
                cadastrar(item, true);
            }
        }
    }
    public Item pesquisar(int codigo, ArrayList<Item> Itens){

        return Itens.get(codigo);

    }
    public ArrayList<Item> ler(){
        try {
            InputStream is = new FileInputStream("Lista_medicamentos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();
            ArrayList<String> linhas = new ArrayList<>();

            while(linha != null){
                System.out.println(linha);
                linhas.add(linha);
                linha = br.readLine();
            }

            ArrayList<Item> itens = new ArrayList<>();
            Item item;
            String[] elementos = new String[3];

            for(int i = 0; i<linhas.size(); i++){
                elementos = linhas.get(i).split(",");
                int quantidade = Integer.parseInt(elementos[1]);
                item = new Item(elementos[0], quantidade, elementos[2]);
                itens.add(item);
            }
            
            System.out.println("O arquivo foi lido com sucesso!");
            return itens;
            

            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
