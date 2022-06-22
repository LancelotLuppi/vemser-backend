public class Cliente {
    String nome;
    String cpf;

    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for(int i=0; i<2; i++){
            if(contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i<2; i++) {
            if(enderecos[i] != null) {
                enderecos[i].imprimeEndereco();
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("----------------------------------------"
            + "Nome e CPF do titular"
            + "\nNome: " + this.nome
            + "\nCPF: " + this.cpf
        );
        imprimirContatos();
        imprimirEnderecos();
    }
}
