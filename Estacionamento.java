import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Estacionamento {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int menu = 0;

        System.out.println("------ESTACIONAMENTO------");

        do {
            System.out.println("\n(1) - Cadastrar Carros");
            System.out.println("(2) - Cadastrar Motos");
            System.out.println("(3) - Cadastrar Bicicletas");
            System.out.println("(4) - Cadastrar Vagas");
            System.out.println("(5) - Cadastrar Locações\n");
            System.out.println("(6) - Listar Carros");
            System.out.println("(7) - Listar Motos");
            System.out.println("(8) - Listar Bicicletas");
            System.out.println("(9) - Listar Vagas");
            System.out.println("(10) - Listar Locações");
            System.out.println("(11) - Excluir Carros\n");
            System.out.println("(12) - Excluir Motos");
            System.out.println("(13) - Excluir Bicicletas");
            System.out.println("(14) - Excluir Vagas");
            System.out.println("(15) - Excluir Locações");
            System.out.println("(16) - Sair");

            System.out.print("\nDigite um numero: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1: {
                    CadastrarCarro(sc);
                    break;
                }

                case 2: {
                    CadastrarMoto(sc);
                    break;
                }

                case 3: {
                    CadastrarBicicleta(sc);
                    break;
                }

                case 4: {
                    CadastrarVagas(sc);
                    break;
                }

                case 5: {
                    CadastrarLocacao(sc);
                    break;
                }

                case 6: {
                    ListarCarros(sc);
                    break;
                }

                case 7: {
                    ListarMotos(sc);
                    break;
                }

                case 8: {
                    ListarBicicletas(sc);
                    break;
                }

                case 9:
                    ListarVagas(sc);
                break;

                case 10:
                    ListarLocacao(sc);
                break;

                case 11: {
                    ExcluirCarros(sc);
                    break;
                }

                case 12: {
                    ExcluirMotos(sc);
                    break;
                }

                case 13: {
                    ExcluirBicicletas(sc);
                    break;
                }

                case 14:
                    ExcluirVagas(sc);
                break;

                case 15:
                    ExcluirLocacao(sc);
                break;

                case 16: {
                        System.out.println("Muito Obrigado, volte sempre!");
                    break;
                }

                default: {
                    System.out.println("opção inválida!");
                    break;
                }
            }

        } while (menu != 16);
    }

    
    public static void CadastrarCarro(Scanner sc) {

        Boolean placaVerificada = false;
        System.out.println("\n-----CADASTRO DE CARROS-----\n");

        System.out.print("Digite o nome do carro: ");
        String nome = sc.next();

        System.out.print("\nDigite as letras do carro: ");
        String letra = sc.next();

        System.out.print("\nDigite os números placa do carro: ");
        String numero = sc.next();


        while(placaVerificada != true){
            if( letra.length() == 3 && numero.length() == 4) {
                placaVerificada = true;
            }else if(letra.length() != 3 && numero.length() ==4){
                System.out.print("\nDigite as letras da placa novamente: ");
                letra = sc.next();
            }else if(letra.length() ==3 && numero.length() != 4){
                System.out.print("\nDigite os números da placa novamente ");
                numero = sc.next();
            }else{
                System.out.print("\nDigite as letras da placa ");
                letra = sc.next();
                System.out.print("\nDigite os numeros da placa ");
                numero = sc.next();
            }
            
        }

        System.out.print("\nQual a cor do carro: ");
        String cor = sc.next();
        if(placaVerificada == true){
            Generic<String,Integer> placa = new Generic<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Carro carro = new Carro(Veiculo.veiculos.size() + 1, nome, placa, cor);
                while(carro.getPlaca() == null){
                    int idCarro = carro.getId();
                    System.out.println("Placa Já cadastrada");
                    System.out.print("\nDigite as letras da placa novamente");
                    letra = sc.next();
                    System.out.print("\nDigite os numeros da placa novamente");
                    numero = sc.next();   
                    placa = new Generic<String,Integer>(letra,Integer.parseInt(numero));
                    for (Veiculo car : Veiculo.veiculos) {
                        if (car instanceof Carro && car.getId() == idCarro) {
                            Veiculo.veiculos.remove(car);
                            break;
                        }
                    }
                    carro = new Carro(idCarro, nome, placa, cor);
                }
                System.out.println("\nCarro cadastrado!\n" + carro);
            }catch(Exception e){

                System.out.println("Erro: " + e.getMessage());
            }
            
        }
    }

    public static void CadastrarMoto(Scanner sc) {
        
        Boolean placaVerificada = false;
        System.out.println("\n-----CADASTRO DE MOTOS-----\n");

        System.out.print("Digite o nome da moto: ");
        String nome = sc.next();

        System.out.print("\nDigite a quantidade de cilindradas: ");
        String cilindradas = sc.next();

        System.out.print("\nDigite as letras da placa da moto: ");
        String letra = sc.next();

        System.out.print("\nDigite os números da placa da moto");
        String numero = sc.next();

        while(placaVerificada != true){
            if( letra.length() == 3 && numero.length() == 4) {
                placaVerificada = true;
            }else if(letra.length() != 3 && numero.length() ==4){
                System.out.print("\nDigite as letras da placa novamente: ");
                letra = sc.next();
            }else if(letra.length() ==3 && numero.length() != 4){
                System.out.print("\nDigite os números da placa novamente ");
                numero = sc.next();
            }else{
                System.out.print("\nDigite as letras da placa novamente");
                letra = sc.next();
                System.out.print("\nDigite os numeros da placa novamente");
                numero = sc.next();
            }
        }
        if(placaVerificada == true){
            Generic<String,Integer> placa = new Generic<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Moto moto = new Moto(Veiculo.veiculos.size() + 1, nome, placa, cilindradas);

                while(moto.getPlaca() == null){
                    int idCarro = moto.getId();
                    System.out.println("\nJá cadastrada");

                    System.out.print("\nDigite as letras da placa novamente");
                    letra = sc.next();

                    System.out.print("\nDigite os numeros da placa novamente");
                    numero = sc.next();   

                    placa = new Generic<String,Integer>(letra,Integer.parseInt(numero));
                    for (Veiculo mot : Veiculo.veiculos) {
                        if (mot instanceof Moto && mot.getId() == idCarro) {
                            Veiculo.veiculos.remove(mot);
                            break;
                        }
                    }
                    moto = new Moto(Veiculo.veiculos.size() + 1, nome, placa, cilindradas);

                }
                System.out.println("\nMoto cadastrado com sucesso!\n" + moto);
            }catch(Exception e){
                System.out.println("\nErro ao cadastrar carro: " + e.getMessage());
            }
            
        }
    }

    public static void CadastrarBicicleta(Scanner sc) {
        System.out.println("\n-----CADASTRO DE BICICLETAS-----\n");

        System.out.print("Digite o nome da bicicleta: ");
        String nome = sc.next();

        System.out.print("\nDigite a marca da bicicleta: ");
        String marca = sc.next();

        System.out.print("\nDigite a cor da bicicleta: ");
        String cor = sc.next();

        Veiculo bicicleta = new Bicicleta(Veiculo.veiculos.size() + 1, nome, marca, cor);

        System.out.println("\n-----BICICLETA CADASTRADA-----!\n\n" + bicicleta);
    }

    public static void CadastrarVagas(Scanner sc) {

        Boolean vagaVerificada = false;
        System.out.println("\n-----CADASTRO DE VAGAS-----\n");

        System.out.println("\nDigite o tipo da vaga: [C] - Carro | [M] - Moto | [B] - Bicicleta");
        System.out.print("Digite uma letra: ");
        String tipo = sc.next();

        System.out.print("\nDigite o tamanho da vaga: ");
        String tamanho = sc.next();
        
        System.out.print("\nDigite o valor da vaga: ");
        double valor = sc.nextDouble();
        
        System.out.print("\nDigite a letra da vaga: ");
        String letra = sc.next();

        System.out.print("\nDigite os números da vaga: ");
        String numero = sc.next();

        while(vagaVerificada != true){
            if( letra.length() == 1 && numero.length() == 3) {
                vagaVerificada = true;
            }else if(letra.length() != 1 && numero.length() ==3){
                System.out.print("\nDigite as letras da placa novamente: ");
                letra = sc.next();
            }else if(letra.length() ==1 && numero.length() != 3){
                System.out.print("\nDigite os números da placa novamente ");
                numero = sc.next();
            }else{
                System.out.print("\nDigite a letra da vaga novamente");
                letra = sc.next();
                System.out.print("\nDigite os numeros da vaga novamente");
                numero = sc.next();
            }
        }
        if(vagaVerificada == true){
            
            Generic<String,Integer> numeroVaga = new Generic<String,Integer>(letra,Integer.parseInt(numero));
            try{
                Vaga vaga = new Vaga(Vaga.vagas.size() + 1, numeroVaga, tipo, tamanho, valor);

                while(vaga.getVaga() == null){
                    int idVaga = vaga.getId();
                    System.out.println("\nJá cadastrado");
                    System.out.print("\nDigite a letra  novamente");
                    letra = sc.next();
                    System.out.print("\nDigite os numeros novamente");
                    numero = sc.next();
                    numeroVaga = new Generic<String,Integer>(letra,Integer.parseInt(numero));
                    for (Vaga vagass : Vaga.vagas) {
                        if (vagass instanceof Vaga && vagass.getId() == idVaga) {
                            Veiculo.veiculos.remove(vagass);
                            break;
                        }
                    }
                    vaga = new Vaga(Vaga.vagas.size() + 1, numeroVaga, tipo, tamanho, valor);

                }
                System.out.println("\nVaga cadastrado com sucesso!\n" + vaga);
            }catch(Exception e){
                System.out.println("\nErro ao cadastrar vaga: " + e.getMessage());
            }
        }


    }

    public static void CadastrarLocacao(Scanner sc) {
        System.out.println("\n-----CADASTRO DE LOCACAO-----\n");

        System.out.println("Veículos para Locação: ");
        for (Veiculo veiculo : Veiculo.veiculos) {
            if (veiculo instanceof Veiculo) {
                System.out.println(veiculo);
            }
        }
        System.out.println("\n----------------------------------");

        System.out.print("\nDigite o id do veículo: ");
        int idVeiculo = sc.nextInt();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    
	    Calendar calendario = Calendar.getInstance();
        String data = dateFormat.format(calendario.getTime());
	    System.out.println("\nData e Horario: " + data);
        System.out.println(data.equals("24-11-2022 19:29"));

    }

    
    public static void ListarCarros(Scanner sc) {
        System.out.println("\n-----LISTAGEM DE CARROS-----\n");

        for (Veiculo carro : Veiculo.veiculos) {
            if (carro instanceof Carro) {
                System.out.println(carro);
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void ListarMotos(Scanner sc) {
        System.out.println("\n-----LISTAGEM DE MOTOS-----\n");

        for (Veiculo moto : Veiculo.veiculos) {
            if (moto instanceof Moto) {
                System.out.println(moto);
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void ListarBicicletas(Scanner sc) {
        System.out.println("\n-----LISTAGEM DE BICICLETAS-----\n");

        for (Veiculo bicicleta : Veiculo.veiculos) {
            if (bicicleta instanceof Bicicleta) {
                System.out.println(bicicleta);
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void ListarVagas(Scanner sc) {
        System.out.println("\n-----LISTAGEM DE VAGAS-----\n");

        for (Vaga vaga : Vaga.vagas) {
            if (vaga instanceof Vaga) {
                System.out.println(vaga);
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void ListarLocacao(Scanner sc) {
        System.out.println("\n-----LISTAGEM DE LOCACAO-----\n");

        for (Locar locar : Locar.locacoes) {
            if (locar instanceof Locar) {
                System.out.println(locar);
            }else{
                System.out.println("\nNao foi possivel alocar");
            }
        }
        System.out.println("\n----------------------------------");
    }


    public static void ExcluirCarros(Scanner sc) {
        System.out.println("\n-----EXCLUSAO DE CARROS-----\n");

        System.out.print("Digite o ID do carro: ");
        int id = sc.nextInt();

        for (Veiculo carro : Veiculo.veiculos) {
            if (carro instanceof Carro && carro.getId() == id) {
                Veiculo.veiculos.remove(carro);
                System.out.println("\nCarro excluido!");
                break;
            }
        }
    }

    public static void ExcluirMotos(Scanner sc) {
        System.out.println("\n-----EXCLUSAO DE MOTOS-----\n");

        System.out.print("Digite o ID da moto: ");
        int id = sc.nextInt();

        for (Veiculo moto : Veiculo.veiculos) {
            if (moto instanceof Moto && moto.getId() == id) {
                Veiculo.veiculos.remove(moto);
                System.out.println("\nMoto excluida!");
                break;
            }
        }
    }

    public static void ExcluirBicicletas(Scanner sc) {
        System.out.println("\n-----EXCLUSAO DE BICICLETAS-----\n");

        System.out.print("Digite o ID da bicicleta: ");
        int id = sc.nextInt();

        for (Veiculo bicicleta : Veiculo.veiculos) {
            if (bicicleta instanceof Bicicleta && bicicleta.getId() == id) {
                Veiculo.veiculos.remove(bicicleta);
                System.out.println("\nBicicleta excluida!");
                break;
            }
        }
    }

    public static void ExcluirVagas(Scanner sc) {
        System.out.println("\n-----EXCLUSAO DE VAGAS-----\n");

        System.out.print("Digite o ID da Vaga: ");
        int id = sc.nextInt();

        for (Vaga vaga : Vaga.vagas) {
            if (vaga instanceof Vaga && vaga.getId() == id) {
                Vaga.vagas.remove(vaga);
                System.out.println("\nVaga excluída!");
                break;
            }
        }
    }

    public static void ExcluirLocacao(Scanner sc) {
        System.out.println("\n-----EXCLUSAO DE LOCACAO-----\n");

        System.out.print("Digite o ID da Locacao: ");
        int id = sc.nextInt();

        for (Locar locacao : Locar.locacoes) {
            if (locacao instanceof Locar && locacao.getId() == id) {
                Locar.locacoes.remove(locacao);
                System.out.println("\nBicicleta excluida!");
                break;
            }
        }
    }
}