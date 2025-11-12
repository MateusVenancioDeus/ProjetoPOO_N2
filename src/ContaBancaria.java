public abstract class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        try {
            if (valor <= 0) {
                System.out.println("Valor inválido! O depósito deve ser maior que zero.");
            } else {
                saldo = saldo + valor;
                System.out.println("Depósito de R$" + valor + " feito com sucesso!");
                System.out.println("Saldo atual: R$" + saldo);
            }
        } catch (Exception e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        try {
            if (valor <= 0) {
                System.out.println("Valor inválido! O saque deve ser maior que zero.");
            } else if (valor > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente! Você tem apenas R$" + saldo);
            } else {
                saldo = saldo - valor;
                System.out.println("Saque de R$" + valor + " feito com sucesso!");
                System.out.println("Saldo atual: R$" + String.format("%.2f", saldo));
            }
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Erro inesperado ao sacar: " + e.getMessage());
        }
    }

    public abstract void atualizarSaldo();
}