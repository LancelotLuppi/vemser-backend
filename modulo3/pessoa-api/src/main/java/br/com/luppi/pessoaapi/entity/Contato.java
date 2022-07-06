package br.com.luppi.pessoaapi.entity;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String telefone;
    private String descricao;

    public Contato( Integer idPessoa, Integer idContato, TipoContato tipoContato , String telefone, String descricao) {
        this.idPessoa = idPessoa;
        this.idContato = idContato;
        this.tipoContato = tipoContato;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", telefone='" + telefone + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
