package br.com.luppi.classes.conta;

import br.com.luppi.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    @Override
    public void imprimir() {
        if(verificaDadosNull()) {
            System.out.println("----------------------------------------"
                    + "Imprimindo dados da conta corrente"
                    + "\nbr.com.luppi.classes.cliente.Cliente: " + this.getCliente().getNome()
                    + "\nNumero da conta: " + this.getNumeroConta()
                    + "\nAgencia: " + this.getAgencia()
                    + "\nSaldo: " + this.getSaldo()
                    + "\nCheque especial com saldo: " + this.retornarSaldoComChequeEspecial()
            );
        }
    }
    public void setChequeEspecial(double valor){
        this.chequeEspecial = valor;
    }

    @Override
    public boolean sacar(double valor){
        if(valor>0 && valor <= this.retornarSaldoComChequeEspecial()){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial() {
        double saldoTotal = this.getSaldo() + this.chequeEspecial;
        return saldoTotal;
    }



}
