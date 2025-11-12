public class ContaPoupanca extends ContaBancaria implements OperacoesBancarias {
    private static final double RENDIMENTO = 0.003;

    public ContaPoupanca(int numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public void atualizarSaldo() {
        double novoSaldo = getSaldo() + (getSaldo() * RENDIMENTO);
        setSaldo(novoSaldo);
    }

    @Override
    public void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Recibo Conta Poupança ---");
        System.out.println("Titular: " + getTitular());
        System.out.println("Número: " + getNumero());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("-------------------------------");
    }
}