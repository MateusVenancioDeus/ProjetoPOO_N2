public abstract class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;

    public ContaBancaria(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero; }

    public String getTitular() {
        return titular; }

    public double getSaldo() {
        return saldo; }

    //usado em outras subclasses
    protected void setSaldo(double saldo) {
        this.saldo = saldo; }

    public void depositar(double valor) {
        if (valor > 0) this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        saldo -= valor;
    }

    public abstract void atualizarSaldo();
}
