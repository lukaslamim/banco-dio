package br.banco;

public abstract class Conta implements InterfaceConta{

    private static final int AGENCIA_PADRAO = 1001;
    private static int SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer acc;
    protected Double saldo = 0.0;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.acc = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.acc));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getConta() {
        return acc;
    }

    public Double getSaldo() { return saldo; }
}
