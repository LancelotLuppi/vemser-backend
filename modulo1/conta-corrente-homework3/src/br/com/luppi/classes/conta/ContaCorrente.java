package br.com.luppi.classes.conta;

import br.com.luppi.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    @Override
    public void imprimir() {
        if(verificaDadosNull()) {
            imprimirDadosGerais();
            System.out.println("Cheque especial com saldo: " + this.retornarSaldoComChequeEspecial());
        }
    }
    @Override
    public boolean sacar(double valor){
        if(this.verificarSaldo(valor)){
            retirarDinheiro(valor);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean verificarSaldo(double valor) {
        return(valor>0 && valor <= this.retornarSaldoComChequeEspecial());
    }
    @Override
    public void retirarDinheiro(double valor) {
        this.setSaldo(this.getSaldo() - valor);
    }

    public double retornarSaldoComChequeEspecial() {
        return (this.getSaldo() + this.chequeEspecial);
    }
    public void setChequeEspecial(double valor){
        this.chequeEspecial = valor;
    }



}
