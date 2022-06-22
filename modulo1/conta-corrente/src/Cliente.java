public class Cliente {
    String nome;
    String cpf;

    //TODO arrumar o limite de 2 objetos por cliente nos vetores
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for(int i=0; i<2; i++){
            if(contatos[i] != null) {
                System.out.println("----------------------------------------"
                        + "Imprimindo o " + (i + 1) + "st" + " contato"
                        + "\nDescricao: " + contatos[i].descricao
                        + "\nTelefone: " + contatos[i].telefone
                        + "\nTipo: " + contatos[i].tipo
                        + "\n1 - residencial || 2 - comercial");
            }
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i<2; i++) {
            if(enderecos[i] != null) {
                System.out.println("----------------------------------------"
                        + "Imprimindo o " + (i + 1) + "st" + " endereço"
                        + "\nTipo de endereço: " + enderecos[i].tipo + " (1-Residencial | 2-Comercial)"
                        + "\nLogradouro: " + enderecos[i].logradouro
                        + "\nNumero: " + enderecos[i].numero
                        + "\nComplemento: " + enderecos[i].complemento
                        + "\nCEP: " + enderecos[i].cep
                        + "\nCidade: " + enderecos[i].cidade
                        + "\nEstado: " + enderecos[i].estado
                        + "\nPaís: " + enderecos[i].pais
                );
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
