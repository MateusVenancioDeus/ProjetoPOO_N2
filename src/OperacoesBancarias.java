public interface OperacoesBancarias {
    void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException;
    void imprimirExtrato();
}
