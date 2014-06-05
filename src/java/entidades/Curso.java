package entidades;


public class Curso {
    private int id;
    private String nome;
    private String categoria;
    private Professor cordenador; 

    public Curso(){
        this.cordenador= new Professor();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Professor getCordenador() {
        return cordenador;
    }

    public void setCordenador(Professor cordenador) {
        this.cordenador = cordenador;
    }
    
}
