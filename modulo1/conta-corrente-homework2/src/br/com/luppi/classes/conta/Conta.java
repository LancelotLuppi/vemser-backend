package br.com.luppi.classes.conta;

import br.com.luppi.classes.cliente.Cliente;
import br.com.luppi.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;


    public boolean sacar(double valor){
        if(valor>0 && valor <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) {
        if(valor > 0){
            this.setSaldo(this.getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }
    public boolean transferir(Conta contaDestino, double valor){
        if(this.sacar(valor)){
            return contaDestino.depositar(valor);
        } else {
            return false;
        }
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

    public boolean verificaDadosNull() {
        if(this.getCliente().getNome() != null && this.getNumeroConta() != null){
            return true;
        }
        System.out.println("\nPor favor, verifique se os dados de Nome do cliente" +
                " e numero da conta foram adicionados corretamente.");

        return false;
    }
}
