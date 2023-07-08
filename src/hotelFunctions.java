import java.net.Inet4Address;
import java.util.*;

public class hotelFunctions {

    public static List<hotelClass.Quarto> quartos = new ArrayList<>(Arrays.asList(
            new hotelClass.Quarto("1", 80.00, true),
            new hotelClass.Quarto("2", 130.00, true),
            new hotelClass.Quarto("3", 100.00, true)
    ));

    public static List<hotelClass.Hospede> hospedes = new ArrayList<>(Arrays.asList(
            new hotelClass.Hospede("Lucas", "07863-000"),
            new hotelClass.Hospede("Pedro", "07854-000"),
            new hotelClass.Hospede("Juan", "07843-000")
    ));

     public static List<hotelClass.funcionario> funcionarios = new ArrayList<>(Arrays.asList(
             new hotelClass.funcionario("Mariana", "07845-200", "Recepcionista"),
             new hotelClass.funcionario("Marcelo", "07869-100", "Gerente"),
             new hotelClass.funcionario("Rafaela", "07841-000", "Fundadora")
     ));

    public static List<hotelClass.reserva> reservas = new ArrayList<>(Arrays.asList());


    public static Scanner scanner = new Scanner(System.in);


    public static void listarQuartos(){
        for (int i = 0; i <= quartos.size() - 1 ; i++) {
            System.out.println(quartos.get(i).getInfo());
        }
    }

    public static void listarHospede(){
        if (hospedes.size() > 0){
            System.out.println("Temos os seguintes Hospedes cadastrados:\n");
            for(int i=0; i <= hospedes.size() -1; i++){
                System.out.println("\nNome: " + hospedes.get(i).getNome() +
                        ", CEP: " + hospedes.get(i).getEndereco());
            }
        }else{
            System.out.println("*Atualmente não temos Hospedes cadastrados no sitema*\n");
        }
    }

    public static void listarFuncionario(){
        if (funcionarios.size() > 0){
            System.out.println("Temos os seguintes Funcionários cadastrados:\n");
            for(int i=0; i <= funcionarios.size() -1; i++){
                System.out.println("\nNome: " + funcionarios.get(i).getNome() +
                        ", CEP: " + funcionarios.get(i).getEndereco() +
                        ", Cargo: " +funcionarios.get(i).getCargo());
            }
        }else{
            System.out.println("*Atualmente não temos funcionários cadastrados no sitema*\n");
        }
    }

    public static void quartosDispo(){
        List<hotelClass.Quarto> quartosDispo = new ArrayList<>(Arrays.asList());

        for (int i = 0; i <= quartos.size() - 1 ; i++) {
            if (Objects.equals(quartos.get(i).getDispo(), true)){
                quartosDispo.add(quartos.get(i));
            }
        }
        if (quartosDispo.size() > 0){
            System.out.println("Temos os seguintes quartos disponiveis: ");
            for (int j = 0; j <= quartosDispo.size() - 1 ; j++) {
                System.out.println(quartosDispo.get(j).getInfo());
            }
        }else{
            System.out.println("*Atuamente não temos nenhum quarto disponivel!*");
            System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
            Main.menuInic();
        }

    }

    public static void listarReserv(){
        if (reservas.size() > 0){
            System.out.println("Temos os seguintes quartos reservados: ");
            for (int i = 0; i <= reservas.size() - i; i++) {
                System.out.println(reservas.get(i).getQuarto().getInfo());
            }
        }else{
            System.out.println("*Atuamente não temos nenhum quarto reservado!*");
            System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
            Main.menuInic();
        }
    }

    public static void reservaQuarto(int num){
        boolean reservaExiste = false;

        if(reservas.size() > 0){
            for (int i=0; i <= reservas.size() - 1; i++){
                if(Objects.equals(Integer.toString(num), reservas.get(i).getQuarto().getNumero())){
                    System.out.println("\nQuarto: " + reservas.get(i).getQuarto().getNumero() +
                            ", Hospede: " + reservas.get(i).getHospede().getNome() +
                            ", DataReserva: " + reservas.get(i).getDataReserva() +
                            ", DataChecking: " + reservas.get(i).getDataChecking() +
                            ", DataCheckout: " + reservas.get(i).getDataCheckout());
                    reservaExiste = true;
                }
            }
            if(!reservaExiste){
                System.out.println("*Atuamente não temos reserva para este quarto!*");
                System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
                Main.menuInic();
            }
        }
        else{
            System.out.println("*Atuamente não temos nenhum quarto reservado!*");
            System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
            Main.menuInic();
        }
    }



    public static void adicQuarto(){
        int ultimoQuarto = quartos.size();
        String num = Integer.toString(Integer.parseInt(quartos.get(ultimoQuarto - 1).getNumero()) + 1);
        boolean dispo = true;
        boolean controle = true;

        System.out.println("*---*A opção escolhida foi a [1] - Adicionar um novo quarto.*---*\n");

        System.out.println("Por favor, digite o preço do quarto(ex: 100,00)");

        while (controle){
            if(scanner.hasNextDouble()){
                double preco = scanner.nextDouble();
                controle = false;

                System.out.println("As informações do quarto que você deseja adicionar é: \n");
                System.out.println("Número: " + num + ", Preço: " + preco +
                        ", Disponibilidade: " + dispo + "\n");
                System.out.println("Se as informações estiverem corretas digite:");
                System.out.println("[1] - Sim.");
                System.out.println("[2] - Não.");

                int escolha = scanner.nextInt();

                if(escolha == 1){
                    quartos.add(new hotelClass.Quarto(num, preco, dispo));
                    System.out.println("Seu quarto foi criado com Sucesso e sua Lista de quartos foi atualiza para:\n");

                    listarQuartos();

                    System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
                    Main.menuInic();
                }else{
                    System.out.println("\nSeu Quarto não foi adicionado e Você será redirecionado para o Menu Principal!\n");
                    Main.menuInic();
                }

            }
            else{
                controle = true;
                System.out.println("O formato digitado não é valido, por favor digite novamente(ex. 100,00)");
                scanner.next();
            }
        }



    }

    public static void novaReserva() {
        System.out.println("*---*A opção escolhida foi a [2] - Fazer uma nova reserva.*---*\n");

        quartosDispo();

        System.out.println("\nDigite o número do quarto que deseja reservar(ex. 1)");

        boolean controle = true;

        while (controle) {
            if (scanner.hasNextInt()) {
                int numQuarto = scanner.nextInt();
                boolean quartoExiste = false;

                for (int i = 0; i <= quartos.size() - 1; i++) {
                    if (Objects.equals(Integer.toString(numQuarto), quartos.get(i).getNumero())) {
                        quartoExiste = true;
                        if (quartos.get(i).getDispo()) {
                            controle = false;

                            System.out.println("\nDigite o nome de quem deseja realizar a reserva(ex. Lucas)");
                            String nomeUsr = scanner.next();

                            System.out.println("\nDigite o CEP de quem deseja realizar a reserva(ex. 07863-000)");
                            String endUsr = scanner.next();

                            if (hospedes.size() > 0){
                                for(int j=0; j <= hospedes.size() -1; j++){
                                    if(Objects.equals(nomeUsr, hospedes.get(j).getNome()) && Objects.equals(endUsr, hospedes.get(j).getEndereco())){
                                        break;
                                    }
                                    if(j == hospedes.size() - 1){
                                        hospedes.add(new hotelClass.Hospede(nomeUsr, endUsr));
                                    }
                                }
                            }else {
                                hospedes.add(0, new hotelClass.Hospede(nomeUsr, endUsr));
                            }

                            System.out.println("\nDigite a data da reserva(ex. 10/04/2023)");
                            String dataReser = scanner.next();

                            System.out.println("\nDigite a data do check-in(ex. 12/04/2023)");
                            String datacheckin = scanner.next();

                            System.out.println("\nDigite a data do check-out(ex. 15/04/2023)");
                            String datacheckout = scanner.next();

                            System.out.println("As informações da reserva que você deseja adicionar é: \n");
                            System.out.println("Número do quarto: " + numQuarto +
                                    "\nNome do usuario: " + nomeUsr +
                                    "\nEndereço do usuario: " + endUsr +
                                    "\nData da reserva: " + dataReser +
                                    "\nData do check-in: " + datacheckin +
                                    "\nData do check-out: " + datacheckout);
                            System.out.println("\nSe as informações estiverem corretas e você realmente deseja reservar este quarto, " +
                                    "digite:");
                            System.out.println("[1] - Sim.");
                            System.out.println("[2] - Não.");

                            int escolha = scanner.nextInt();

                            if (escolha == 1) {
                                hotelClass.Hospede hospedeDoQuato = hospedes.get(0);

                                for(int k = 0; k < hospedes.size() - 1; k++){
                                    if(Objects.equals(nomeUsr, hospedes.get(k).getNome())){
                                        hospedeDoQuato = hospedes.get(k);
                                    }
                                }

                                reservas.add(0, new hotelClass.reserva(quartos.get(i), hospedeDoQuato, dataReser, datacheckin, datacheckout));
                                quartos.get(i).setDispo(false);

                                System.out.println("\n*O seu quarto foi reservado com sucesso!*");
                                System.out.println("\nSua lista de reserva foi atualizada para: ");

                                listarReserv();

                                System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
                                Main.menuInic();
                            } else {
                                System.out.println("\nSeu quarto não foi reservado, Você será redirecionado para o Menu Principal!\n");
                                Main.menuInic();
                            }

                        }
                        else {
                            quartoExiste = false;
                            controle = true;
                        }
                    }
                    else if(quartoExiste == true){
                        quartoExiste = false;
                    }
                }

                if (quartoExiste == false){
                    controle = true;
                    System.out.println("\nEsse quarto não existe ou já está ocupado, por favor digite o " +
                            "número de um quarto existente e disponivel(ex. 1)");
                }

            } else {
                controle = true;
                System.out.println("\nO número digitado não é valido, por favor digite somente o número(ex. 1)");
                scanner.next();
            }
        }
    }

    public static void cancelarReserva(){
        System.out.println("*---*A opção escolhida foi a [3] - Cancelar uma reserva existente.*---*\n");

        listarReserv();

        System.out.println("\nPor favor, digite o número do quarto que deseja cancelar a reserva");

        boolean controle = true;

        while(controle){
            if (scanner.hasNextInt()){
                String numQuarto = scanner.next();
                controle = false;

                for(int i=0; i<= reservas.size() - 1; i++){
                    if(Objects.equals(numQuarto, reservas.get(i).getQuarto().getNumero())){
                        System.out.println("As informações da reserva que você deseja cancelar é: \n");

                        System.out.println(reservas.get(i).getQuarto().getInfo());

                        System.out.println("\nSe as informações estiverem corretas e você realmente deseja reservar este quarto, " +
                                "digite:");
                        System.out.println("[1] - Sim.");
                        System.out.println("[2] - Não.");

                        int escolha = scanner.nextInt();

                        if(escolha == 1){
                            for(int j=0; j <= quartos.size() - 1; j++) {
                                if (Objects.equals(quartos.get(j).getNumero(), reservas.get(i).getQuarto().getNumero())) {
                                    quartos.get(j).setDispo(true);
                                    reservas.remove(i);
                                    System.out.println("\nReserva cancelada com sucesso, Você será redirecionado para o Menu Principal!\n");
                                    Main.menuInic();
                                }
                            }
                        }else{
                            System.out.println("\nSua reserva não foi cancelada, Você será redirecionado para o Menu Principal!\n");
                            Main.menuInic();
                        }
                    }
                    else{
                        controle = true;
                        System.out.println("\nEsse quarto não está reservado ou não existe, por favor digite o número de um quarto" +
                                " que possui reserva");
                    }
                }
            }else{
                controle = true;
                System.out.println("\nO número digitado não é valido(ex. 1)");
                scanner.next();
            }
        }


    }

    public static void editarReserva(){
        System.out.println("*---*A opção escolhida foi a [4] - Modificar uma reserva existente.*---*\n");

        listarReserv();

        System.out.println("\nPor favor, digite o número do quarto que deseja modificar a reserva");
        String numQuarto = scanner.next();

        reservaQuarto(Integer.parseInt(numQuarto));

        System.out.println("O que você deseja modificar:\n");
        System.out.println("[1] - data da reserva");
        System.out.println("[2] - data do check-in");
        System.out.println("[3] - data do check-out");

        boolean controleB = true;

        while (controleB){
            if (scanner.hasNextInt()){
                controleB = false;
                int escolha = scanner.nextInt();

                if(escolha == 1){
                    System.out.println("\nDigite a nova data da reserva: ");
                    String dataReserva = scanner.next();

                    for (int i=0; i <= reservas.size() - 1; i++){
                        if(Objects.equals(numQuarto, reservas.get(i).getQuarto().getNumero())){
                            reservas.get(i).setDataReserva(dataReserva);
                            System.out.println("\nA data da sua reserva foi atualizada com sucesso, Você será redirecionado para o Menu Principal!\n");
                            Main.menuInic();
                        }
                    }
                }
                if(escolha == 2){
                    System.out.println("\nDigite a nova data do check-in: ");
                    String dataCheckin = scanner.next();

                    for (int i=0; i <= reservas.size() - 1; i++){
                        if(Objects.equals(numQuarto, reservas.get(i).getQuarto().getNumero())){
                            reservas.get(i).setDataChecking(dataCheckin);
                            System.out.println("\nA data do seu check-in foi atualizada com sucesso, Você será redirecionado para o Menu Principal!\n");
                            Main.menuInic();
                        }
                    }
                }
                if(escolha == 3){
                    System.out.println("\nDigite a nova data do check-out: ");
                    String dataCheckout = scanner.next();

                    for (int i=0; i <= reservas.size() - 1; i++){
                        if(Objects.equals(numQuarto, reservas.get(i).getQuarto().getNumero())){
                            reservas.get(i).setDataCheckout(dataCheckout);
                            System.out.println("\nA data do seu check-out foi atualizada com sucesso, Você será redirecionado para o Menu Principal!\n");
                            Main.menuInic();
                        }
                    }
                }

                if(escolha < 1 || escolha > 3){
                    System.out.println("\nOpção não é valida, por favor digite uma opção valida");
                    controleB = true;
                }
            }
            else{
                System.out.println("\nO valor digitado não é valido, por favor digite um número das opções acima(ex. 1)");
                controleB = true;
                scanner.next();
            }
        }




    }

    public static void novoHospede(){
        System.out.println("*---*A opção escolhida foi a [5] - Cadastrar Hospede.*---*\n");

        System.out.println("Por favor, digite o nome do hospede: \n");
        String nomeHospede = scanner.next();

        System.out.println("Por favor, digite o CEP do hospede: \n");
        String endHospede = scanner.next();

        if (hospedes.size() > 0){
            for(int j=0; j <= hospedes.size() -1; j++){
                if(Objects.equals(nomeHospede, hospedes.get(j).getNome()) && Objects.equals(endHospede, hospedes.get(j).getEndereco())){
                    System.out.println("Esse Hospede já está cadastrado, você será redirecionado para o menu principal! \n");
                    Main.menuInic();

                }
                if(j == hospedes.size() - 1){
                    System.out.println("\nAs informações sobre o novo hospede estão corretas: \n");

                    System.out.println("Nome: " + nomeHospede + ", CEP: " + endHospede);

                    System.out.println("[1] - Sim.");
                    System.out.println("[2] - Não.");

                    int escolha = scanner.nextInt();

                    if(escolha == 1){
                        hospedes.add(new hotelClass.Hospede(nomeHospede, endHospede));
                        System.out.println("Hospede criado com sucesso, sua lista de hospede foi atualizada para: \n");

                        listarHospede();

                        System.out.println("\nVocê retornará para o menu inical!\n");
                        Main.menuInic();
                    }else{
                        System.out.println("\nHospede não foi criado, você retornará para o menu inical!\n");
                        Main.menuInic();
                    }
                }
            }
        }else {
            System.out.println("\nAs informações sobre o novo hospede estão corretas: \n");

            System.out.println("Nome: " + nomeHospede + ", CEP: " + endHospede);

            System.out.println("[1] - Sim.");
            System.out.println("[2] - Não.");

            int escolha = scanner.nextInt();

            if(escolha == 1){
                hospedes.add(new hotelClass.Hospede(nomeHospede, endHospede));
                System.out.println("Hospede criado com sucesso, sua lista de hospede foi atualizada para: \n");

                listarHospede();

                System.out.println("\nVocê retornará para o menu inical!\n");
                Main.menuInic();
            }else{
                System.out.println("\nHospede não foi criado, você retornará para o menu inical!\n");
                Main.menuInic();
            }
        }
    }

    public static void novoFuncionario(){
        System.out.println("*---*A opção escolhida foi a [6] - Cadastrar Funcionário.*---*\n");

        System.out.println("Por favor, digite o nome do funcionário: \n");
        String nomeFuncionario = scanner.next();

        System.out.println("Por favor, digite o CEP do funcionário: \n");
        String endFuncionario = scanner.next();

        System.out.println("Por favor, digite o cargo do funcionário: \n");
        String cargoFuncionario = scanner.next();

        if (funcionarios.size() > 0){
            for(int j=0; j <= funcionarios.size() -1; j++){
                if(Objects.equals(nomeFuncionario, funcionarios.get(j).getNome()) &&
                    Objects.equals(endFuncionario, funcionarios.get(j).getEndereco()) &&
                    Objects.equals(cargoFuncionario, funcionarios.get(j).getCargo())){
                        System.out.println("Esse Funcionário já está cadastrado, você será redirecionado para o menu principal! \n");
                        Main.menuInic();
                }
                if(j == funcionarios.size() - 1) {
                    System.out.println("\nAs informações sobre o novo Funcionário estão corretas: \n");

                    System.out.println("Nome: " + nomeFuncionario + ", CEP: " + endFuncionario + ", Cargo: " + cargoFuncionario);

                    System.out.println("[1] - Sim.");
                    System.out.println("[2] - Não.");

                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        funcionarios.add(new hotelClass.funcionario(nomeFuncionario, endFuncionario, cargoFuncionario));
                        System.out.println("Funcionário criado com sucesso, sua lista de Funcionário foi atualizada para: \n");

                        listarFuncionario();

                        System.out.println("\nVocê retornará para o menu inical!\n");
                        Main.menuInic();
                    } else {
                        System.out.println("\nFuncionário não foi criado, você retornará para o menu inical!\n");
                        Main.menuInic();
                    }
                }
            }
        }
    }

    public static void listarReservas(){
        System.out.println("*---*A opção escolhida foi a [7] - Exibir todas as reservas existentes.*---*\n");

        listarReserv();

        System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
        Main.menuInic();
    }

    public static void listarReservaQuarto(){
        System.out.println("*---*A opção escolhida foi a [8] - Exibir todas as reservas para um determinado quarto.*---*\n");
        System.out.println("Digite o numero do quarto que deseja visualizar as reservas(ex. 1)!\n");
        boolean controle = true;

        while(controle){
            if(scanner.hasNextInt()){
                int num = scanner.nextInt();
                controle = false;
                reservaQuarto(num);
            }
            else{
                System.out.println("\nO valor digitado não é valido, por favor digite um número das opções acima(ex. 1)");
                controle = true;
                scanner.next();
            }
        }

        System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
        Main.menuInic();

    }

    public static void todosHospedes(){
        System.out.println("*---*A opção escolhida foi a [9] - Exibir todos os Hospedes*---*\n");

        listarHospede();

        System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
        Main.menuInic();
    }

    public static void todosFuncionarios(){
        System.out.println("*---*A opção escolhida foi a [10] - Exibir todos os Funcionários*---*\n");

        listarFuncionario();

        System.out.println("\nVocê será redirecionado para o Menu Principal!\n");
        Main.menuInic();
    }

}
