package farmaciasystem.model;

public class Item {
    
    private int codigo;
    private String nome;
    private String tipo;
    private int quantidade;

    public Item(String nome, int quantidade, String tipo){
        
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }
    public void Setcodigo(int codigo){
        this.codigo = codigo;
    }
    public int Getcodigo(){
        return codigo;
    }
    public void Setnome(String nome){
        this.nome = nome;
    }
    public String Getnome(){
        return nome;
    }
    public void Settipo(String tipo){
        this.tipo = tipo;
    }
    public String Gettipo(){
        return tipo;
    }
    public void Setquantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int Getquantidade(){
        return quantidade;
    }



}