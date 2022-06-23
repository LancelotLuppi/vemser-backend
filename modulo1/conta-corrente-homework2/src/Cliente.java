public class Cliente {
    private String nome;
    private String cpf;

    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(int index, Contato contatos) {
        this.contatos[index] = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(int index, Endereco enderecos) {
        this.enderecos[index] = enderecos;
    }
}
