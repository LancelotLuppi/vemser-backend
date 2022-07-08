package br.com.luppi.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;

    @NotNull(message = "Tipo do contato nao pode ser nulo")
    private TipoContato tipoContato;

    @Size(min=3, max=13)
    @NotBlank(message = "Numero nao pode ser nulo ou em branco")
    private String telefone;
    @NotBlank(message = "Descricao nao pode ser nulo ou em branco")
    private String descricao;

    public Contato( Integer idPessoa, Integer idContato, TipoContato tipoContato , String telefone, String descricao) {
        this.idPessoa = idPessoa;
        this.idContato = idContato;
        this.tipoContato = tipoContato;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public Contato(){

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

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
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
