package model; 

public class Investidor { 
    private String nome; 
    private String cpf; 
    private String senha; 
    private Carteira carteira; 
    

    // ================== Construtores ==================
    
    // Construtor padrão 
    public Investidor() { 
        this.carteira = new Carteira();  
    } 
    
    // Construtor sem carteira (inicializa uma nova carteira zerada) 
    public Investidor(String nome, String cpf, String senha) { 
        this.nome = nome; 
        this.cpf = cpf; 
        this.senha = senha; 
        this.carteira = new Carteira(); 
    } 

    // Construtor completo 
    public Investidor(String nome, String cpf, String senha, Carteira carteira) { 
        this.nome = nome; 
        this.cpf = cpf; 
        this.senha = senha; 
        this.carteira = carteira; 
    } 
    
    // ================== Getters e Setters ==================

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}


