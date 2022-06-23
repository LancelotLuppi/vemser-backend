public interface Movimentacao {

    public boolean sacar(double valor);
    public boolean depositar(double valor);
    public boolean transferir(Conta contaDestino, double valor);
}
