public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato(){
        System.out.println("---------------------------"
            + "\nDescricao: " + this.descricao
            + "\nTelefone: " + this.telefone
            + "\nTipo: " + this.tipo
            + "\n1 - residencial || 2 - comercial");
    }
}
