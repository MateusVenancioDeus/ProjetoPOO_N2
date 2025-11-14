public class ContaPoupanca extends ContaBancaria implements OperacoesBancarias {

    public ContaPoupanca(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void atualizarSaldo() {
        try {
            double ganho = getSaldo() * 0.003; // 0,3%
            double novoSaldo = getSaldo() + ganho;
            setSaldo(novoSaldo);
            System.out.println("🏦A conta de " + getTitular() + " rendeu R$" + String.format("%.2f", ganho) + " neste período.");
            System.out.println("Saldo com o ganho é de R$" + String.format("%.2f", novoSaldo));
        } catch (Exception e) {
            System.out.println("Erro ao calcular rendimento da poupança.");
        }
    }
    @Override
    public void transferir(ContaBancaria destino, double valor) {
        try {
            System.out.println("\n---- \uD83D\uDCB0ÁREA DE TRANSFERÊNCIA (CONTA POUPANÇA)\uD83D\uDCB0 ----");
            if (valor <= 0) {
                System.out.println("Valor inválido! A transferência deve ser maior que zero.");
            } else if (valor > getSaldo()) {
                System.out.println("Saldo insuficiente para transferir R$" + valor);
            } else {
                // Faz a transferência direta
                setSaldo(getSaldo() - valor);
                    destino.setSaldo(destino.getSaldo() + valor);
                System.out.println("-----Informações das contas-----");
                System.out.println("Conta de origem: " + getTitular() + " (Conta Poupança)");
                System.out.println("Conta de destino: " + destino.getTitular() + " (" + destino.getClass().getSimpleName() + ")\n");
                System.out.println("-----Valor descontado-----");
                System.out.println("Valor descontado da conta origem: R$" + valor);
                System.out.println("Transferência de R$" + valor + " feita com sucesso!\n");
                System.out.println("-----Saldos das contas-----");
                System.out.println("Saldo atual da origem: R$" + getSaldo());
                System.out.println("Saldo atual da conta destino: R$" + destino.getSaldo());
            }System.out.println("-----------------------------------------------");
        }catch (Exception e) {
            System.out.println("Erro ao realizar a transferência.");
        }
    }
    @Override
        public void imprimirExtrato() {
        try {
            System.out.println("\n---- Extrato da Conta Poupança ----");
            System.out.println("Titular: " + getTitular());
            System.out.println("Número: " + getNumero());
            System.out.println("Saldo final: R$" + String.format("%.2f",getSaldo()));
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao imprimir o extrato.");
        }
    }
}