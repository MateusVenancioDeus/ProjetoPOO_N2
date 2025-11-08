public class Banco {
    public static void main(String[] args) {
        try {
            System.out.println("☕Bem vindo ao Banco Jalva!☕ \n");

            ContaCorrente conta_corrente = new ContaCorrente(1, "Alice", 1000);
            ContaPoupanca conta_poupanca = new ContaPoupanca(2, "Bob", 500);

            //Depositar
            conta_corrente.depositar(200);
            conta_poupanca.depositar(300);

            //Transferencia
            conta_corrente.sacar(100);
            conta_poupanca.transferir(conta_poupanca, 200);

            //atualizar o saldo
            conta_corrente.atualizarSaldo();
            conta_poupanca.atualizarSaldo();

            //Impressão do extrato
            conta_corrente.imprimirExtrato();
            conta_poupanca.imprimirExtrato();
        }
        catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {
                System.out.println("Banco finalizado");
            System.out.println("   \uD83D\uDE0EAgradecemos pela preferencia, volte sempre!\uD83D\uDE0E");
        }
    }
}
