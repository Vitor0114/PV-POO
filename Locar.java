import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Locar {
    
    private int id;
    private int idVeiculo;
    private LocalDate data;
    private LocalTime hora;
    public static ArrayList<Locar> locacoes = new ArrayList<Locar>();

    public Locar(int id, LocalDate data, LocalTime hora, int idVeiculo) {
        
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.idVeiculo = idVeiculo;
        locacoes.add(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdVeiculo() {
        return this.idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Data: " + this.data;
    }

    public static Locar getLocarById(int id) {
        for (Locar locar : Locar.locacoes) {
            if (locar.id == id) {
                return locar;
            }
        }

        return null;
    }

    public static Locar deleteLocarById(int id) {
        for (Locar locar : Locar.locacoes) {
            if (locar.id == id) {
                Locar.locacoes.remove(locar);
                return locar;
            }
        }

        return null;
    }
}
