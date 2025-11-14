public class BancoApp {
    public static void main(String[] args) {
        try {
            System.out.println("☕ BEM VINDO AO BANCO JALVA! ☕");

            //Criação das contas
            ContaCorrente conta_corrente = new ContaCorrente(1, "Mateus Vitor", 100);
            ContaPoupanca conta_poupanca = new ContaPoupanca(2, "Bob Marley", 200);

            //Saldo inicial
            System.out.println("\n---- SALDO INICIAL----");
            System.out.println("Saldo inicial da conta de " + conta_corrente.getTitular() + ": R$" + conta_corrente.getSaldo());
            System.out.println("Saldo inicial da conta de " + conta_poupanca.getTitular() + ": R$" + conta_poupanca.getSaldo());
            System.out.println("---------------------------------");

            //Depósito
            System.out.println("\n---- DEPOSITO----");
            conta_corrente.depositar(100);
            System.out.println("Deposito feito na conta de Mateus Vitor(Conta Corrente)!");
            conta_poupanca.depositar(200);
            System.out.println("Deposito feito na conta de Bob Marley(Conta Poupanca)!");

            System.out.println("---------------------------------");

            //Transferência
            conta_corrente.transferir(conta_poupanca, 25);
            conta_poupanca.transferir(conta_corrente, 350);

            //Atualizar saldo (taxa e rendimento)
            System.out.println("\n---- TAXAS DE APLICAÇÃO----");
            conta_corrente.atualizarSaldo();
            conta_poupanca.atualizarSaldo();
            System.out.println("---------------------------------");

            //Sacar
            System.out.println("\n---- ÁREA DE SAQUE----");
            conta_corrente.sacar(40);
            conta_poupanca.sacar(60);
            System.out.println("---------------------------------");

            //Imprimir os extratos
            conta_corrente.imprimirExtrato();
            conta_poupanca.imprimirExtrato();
        }
        catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("\nBanco finalizado");
            System.out.println("😎Agradecemos pela preferência, volte sempre!");
        }
    }
}