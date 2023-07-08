import java.util.Scanner;

class Main{

    public static void main(String[] args){
        System.out.println("*--------* Olá, Seja bem vindo ao FORD HOTEL *--------*\n");
        menuInic();
    }

    public static void menuInic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*---*Digite o NÚMERO da opção que deseja:");
        System.out.println("[1] - Adicionar um novo quarto.");
        System.out.println("[2] - Fazer uma nova reserva.");
        System.out.println("[3] - Cancelar uma reserva existente.");
        System.out.println("[4] - Modificar uma reserva existente.");
        System.out.println("[5] - Cadastrar Hospede.");
        System.out.println("[6] - Cadastrar Funcionário.");
        System.out.println("[7] - Exibir todas as reservas existentes.");
        System.out.println("[8] - Exibir todas as reservas para um determinado quarto.");
        System.out.println("[9] - Exibir todos os hospedes.");
        System.out.println("[10] - Exibir todos os funcionarios.");
        System.out.println("[11] - Sair.");

        boolean controle = true;

        while(controle){
            if (scanner.hasNextInt()){
               controle = false;
               int escolha = scanner.nextInt();

               switch (escolha){
                   case 1:
                       hotelFunctions.adicQuarto();
                       break;
                   case 2:
                       hotelFunctions.novaReserva();
                       break;
                   case 3:
                       hotelFunctions.cancelarReserva();
                       break;
                   case 4:
                       hotelFunctions.editarReserva();
                       break;
                   case 5:
                       hotelFunctions.novoHospede();
                       break;
                   case 6:
                       hotelFunctions.novoFuncionario();
                       break;
                   case 7:
                       hotelFunctions.listarReservas();
                       break;
                   case 8:
                       hotelFunctions.listarReservaQuarto();
                       break;
                   case 9:
                       hotelFunctions.todosHospedes();
                       break;
                   case 10:
                       hotelFunctions.todosFuncionarios();
                       break;
                   case 11:
                       break;
                   default:
                       controle = true;
                       System.out.println("\nEscolha uma opção valida, um número de 1 a 11!");
                       break;
               }
            }
            else{
                controle = true;
                System.out.println("\nEscolha uma opção valida, um número de 1 a 11!");
                scanner.next();
            }
        }

    }
}