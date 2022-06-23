package br.com.luppi.interfaces;

import br.com.luppi.classes.conta.Conta;

public interface Movimentacao {

    public boolean sacar(double valor);
    public boolean depositar(double valor);
    public boolean transferir(Conta contaDestino, double valor);
}
