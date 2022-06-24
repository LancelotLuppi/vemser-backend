package br.com.luppi.classes.conta;

import br.com.luppi.classes.cliente.Cliente;
import br.com.luppi.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;


    public boolean sacar(double valor){
        if(this.verificarSaldo(valor)){
            retirarDinheiro(valor);
            return true;
        } else {
            return false;
        }
    }
    public boolean depositar(double valor) {
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }
    public boolean transferir(Conta contaDestino, double valor){
        if(verificarSaldo(valor)){
            this.retirarDinheiro(valor);
            return contaDestino.depositar(valor);
        }
        return false;
    }
    public void retirarDinheiro(double valor){
            this.setSaldo(this.getSaldo() - valor);
    }
    public boolean verificarSaldo(double valor) {
        return(valor>0 && valor <= this.getSaldo());
    }

    public boolean verificaDadosNull() {
        return(this.getCliente() != null
                && this.getCliente().getNome() != null
                && this.getNumeroConta() != null
        );
    }

    public void imprimirDadosGerais() {
        System.out.println("------------------------"
                + "Imprimindo dados da conta"
                + "\nCliente: " + this.getCliente().getNome()
                + "\nNumero da conta: " + this.getNumeroConta()
                + "\nAgencia: " + this.getAgencia()
                + "\nSaldo: " + this.getSaldo());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
