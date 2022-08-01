package br.com.luppi.classes.conta;

import br.com.luppi.interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {
    static final double TAXA_SAQUE = 4.25;

    @Override
    public boolean sacar(double valor) {
        if(verificarSaldo(valor)){
            retirarDinheiro(valor + TAXA_SAQUE);
            return true;
        }
        return false;
    }
    @Override
    public boolean verificarSaldo(double valor) {
        return(valor > 0 && this.getSaldo() >= valor + TAXA_SAQUE);
    }

    @Override
    public void imprimir() {
        if(verificaDadosNull()){
            imprimirDadosGerais();
            System.out.println("Valor da taxa de saque: " + TAXA_SAQUE);
        }
    }
}
