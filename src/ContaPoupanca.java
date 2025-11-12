public class ContaPoupanca extends ContaBancaria implements OperacoesBancarias {

    private static final double RENDIMENTO = 0.003;

    public ContaPoupanca(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void atualizarSaldo() {
        try {
            double ganho = getSaldo() * RENDIMENTO; // 0.003 * saldo atual
            double novoSaldo = getSaldo() + ganho;
            setSaldo(novoSaldo);

            System.out.println("🏦 Rendimento de R$" + String.format("%.2f", ganho)
                    + " aplicado à conta de " + getTitular() + ".");
            System.out.println("Saldo atualizado: R$" + String.format("%.2f", getSaldo()));
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o saldo da poupança.");
        }
    }


    @Override
    public void transferir(ContaBancaria destino, double valor) {
        try {
            System.out.println("\n---- ÁREA DE TRANSFERÊNCIA (CONTA POUPANÇA) ----");

            if (valor <= 0) {
                System.out.println("Valor inválido! A transferência deve ser maior que zero.");
            } else if (valor > getSaldo()) {
                System.out.println("Saldo insuficiente para transferir R$" + valor);
            } else {
                // Faz a transferência direta
                setSaldo(getSaldo() - valor);
                destino.setSaldo(destino.getSaldo() + valor);

                System.out.println("Transferência de R$" + valor + " feita com sucesso!");
                System.out.println("Conta de origem: " + getTitular() + " (Conta Poupança)");
                System.out.println("Conta de destino: " + destino.getTitular() + " (" + destino.getClass().getSimpleName() + ")");
                System.out.println("Saldo atual da origem: R$" + getSaldo());
            }

            System.out.println("-----------------------------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao realizar a transferência.");
        }
    }

    @Override
    public void imprimirExtrato() {
        try {
            System.out.println("\n---- Extrato da Conta Poupança ----");
            System.out.println("Titular: " + getTitular());
            System.out.println("Número: " + getNumero());
            System.out.println("Saldo final: R$" + getSaldo());
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao imprimir o extrato.");
        }
    }
}