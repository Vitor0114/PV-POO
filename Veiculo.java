import java.util.ArrayList;

public abstract class Veiculo {

    private int id;
    private String nome;
    public static ArrayList< Veiculo> veiculos = new ArrayList<Veiculo>();

    
    protected Veiculo(int id, String nome) {
        
        this.id = id;
        this.nome = nome;
        veiculos.add(this);
    }


    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return this.nome;
    }


    public void setNome(String nome) {
        this.nome= nome;
    }
    

    @Override
    public String toString() {
        return "Id: " + this.id + " | Nome: " + this.nome;
    }

}

