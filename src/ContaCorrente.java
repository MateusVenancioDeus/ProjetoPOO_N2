public class ContaCorrente extends ContaBancaria implements OperacoesBancarias {

    public ContaCorrente(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void atualizarSaldo() {
        try {
            double taxa = getSaldo() * 0.005; // 0,5%
            setSaldo(getSaldo() - taxa);
            System.out.println("💼Taxa de manutenção de 0,5% aplicada à conta Corrente de " + getTitular() + ". \n Valor da taxa: R$" + String.format("%.2f", taxa));
        } catch (Exception e) {
            System.out.println("Erro ao aplicar taxa de manutenção.");
        }
    }

    @Override
    public void transferir(ContaBancaria destino, double valor) {
        try {
            System.out.println("\n---- ÁREA DE TRANSFERÊNCIA (CONTA CORRENTE) ----");

            if (valor <= 0) {
                System.out.println("Valor inválido! A transferência deve ser maior que zero.");
            } else if (valor > getSaldo()) {
                System.out.println("Saldo insuficiente para transferir R$" + valor);
            } else {
                setSaldo(getSaldo() - valor);
                destino.setSaldo(destino.getSaldo() + valor);

                System.out.println("Transferência de R$" + valor + " feita com sucesso!");
                System.out.println("Conta de origem: " + getTitular() + " (Conta Corrente)");
                System.out.println("Conta de destino: " + destino.getTitular() + " (" + destino.getClass().getSimpleName() + ")");
                System.out.println("Valor descontado da conta origem: R$" + valor);
                System.out.println("Saldo atual da origem: R$" + getSaldo());
                System.out.println("Saldo atual da destino: R$" + destino.getSaldo());
            }

            System.out.println("-----------------------------------------------");
        } catch (Exception e) {
            System.out.println("Erro ao fazer a transferência.");
        }
    }

    @Override
    public void imprimirExtrato() {
        try {
            System.out.println("\n---- Extrato da Conta Corrente ----");
            System.out.println("Titular: " + getTitular());
            System.out.println("Número: " + getNumero());
            System.out.println("Saldo final: R$" + String.format("%.2f", getSaldo()));
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            System.err.println("⚠️Erro ao imprimir extrato: " + e.getMessage());
        }
    }
}