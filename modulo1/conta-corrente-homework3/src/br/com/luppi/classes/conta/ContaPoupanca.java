package br.com.luppi.classes.conta;

import br.com.luppi.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    @Override
    public void imprimir() {
        if(verificaDadosNull()) {
            imprimirDadosGerais();
            System.out.println("Juros mensal: " + JUROS_MENSAL);
        }
    }

    public void creditarTaxa(){
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }


}
