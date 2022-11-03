import java.util.ArrayList;

public class Carro extends Veiculo {
    
    private Generic<String, Integer> placa;
    private String cor;
    public static ArrayList<Carro> carros = new ArrayList<Carro>();

    public Carro(int id, String nome, Generic<String, Integer> placa, String cor) {

        super(id, nome);
        try{
            if(carros.isEmpty()){        
                this.placa = placa;
                this.cor = cor;
        
                carros.add(this);
            }else if(!carros.isEmpty())
                for(Carro carro : carros){
                    if(carro.getPlaca().equals(placa)){
                        throw new Exception("Placa já cadastrada");
                    }else{
                        this.placa = placa;
                        this.cor = cor;
                
                        carros.add(this);
                    }
            }else{
                throw new Exception("Carro já cadastrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    


    }

    public Generic<String, Integer> getPlaca() {
        return placa;
    }

    public void setPlaca(Generic<String, Integer> placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean verificaPlaca(Generic<String, Integer> placa){
        for(Carro carro: carros){
            if( carro.getPlaca().equals(placa) == true){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return super.toString() + "| Placa: " + this.placa + "| Cor: " + this.cor;
    }


}