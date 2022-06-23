package br.com.luppi.classes.cliente;

public class Contato {
    private String descricao;
    private String telefone;
    private int tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato(){
        System.out.println("--------------------------------------Imprimindo o contato do cliente"
            + "\nDescricao: " + this.getDescricao()
            + "\nTelefone: " + this.getTelefone()
            + "\nTipo: " + this.getTipo()
            + "\n1 - residencial || 2 - comercial");
    }
}
