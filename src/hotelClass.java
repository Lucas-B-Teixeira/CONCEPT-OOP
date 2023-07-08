public class hotelClass {

    public static abstract class pessoa {
        private String nome;
        private String endereco;

        public pessoa(String nome, String endereco) {
            this.nome = nome;
            this.endereco = endereco;
        }

        public abstract String getNome();

        public abstract String getEndereco();
    }

    public static class Hospede extends pessoa {

        public Hospede(String nome, String endereco) {
            super(nome, endereco);
        }

        @Override
        public String getNome() {
            return super.nome;
        }

        @Override
        public String getEndereco() {
            return super.endereco;
        }
    }

    public static class funcionario extends pessoa {
        private String cargoFuncionario;

        public funcionario(String nome, String endereco, String cargo) {
            super(nome, endereco);
            this.cargoFuncionario = cargo;
        }

        @Override
        public String getNome() {
            return super.nome;
        }

        @Override
        public String getEndereco() {
            return super.endereco;
        }

        public String getCargo() {
            return cargoFuncionario;
        }

    }

    public static class Quarto {
        private String numero;
        private double preco;
        private boolean disponibilidade;

        public Quarto(String numero, double preco, boolean disponibilidade) {
            this.numero = numero;
            this.preco = preco;
            this.disponibilidade = disponibilidade;
        }

        public String getNumero() {
            return numero;
        }

        public boolean getDispo() {
            return disponibilidade;
        }

        public String getInfo() {
            String dispo;

            if (disponibilidade) {
                dispo = "Sim";
            } else {
                dispo = "Não";
            }

            return "Numero: " + numero + ", Preço: " + preco + ", Disponivel: " + dispo;
        }

        public void setDispo(boolean dispo) {
            this.disponibilidade = dispo;
        }
    }

    public static class reserva {
        private Quarto quarto;
        private Hospede hospede;
        private String dataReserva;
        private String dataChecking;
        private String dataCheckout;

        public reserva(Quarto quarto, Hospede hospede, String Dreserva, String Dcheking, String Dcheckout) {
            this.quarto = quarto;
            this.hospede = hospede;
            this.dataReserva = Dreserva;
            this.dataChecking = Dcheking;
            this.dataCheckout = Dcheckout;
        }

        public Quarto getQuarto() {
            return quarto;
        }

        public Hospede getHospede() {
            return hospede;
        }

        public String getDataReserva() {
            return dataReserva;
        }

        public String getDataChecking() {
            return dataChecking;
        }

        public String getDataCheckout() {
            return dataCheckout;
        }

        public void setQuarto(Quarto quarto) {
            this.quarto = quarto;
        }

        public void setHospede(Hospede hospede) {
            this.hospede = hospede;
        }

        public void setDataReserva(String dataReserva) {
            this.dataReserva = dataReserva;
        }

        public void setDataChecking(String dataChecking) {
            this.dataChecking = dataChecking;
        }

        public void setDataCheckout(String dataCheckout) {
            this.dataCheckout = dataCheckout;
        }
    }

}

