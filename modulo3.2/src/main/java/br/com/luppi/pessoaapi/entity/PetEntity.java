package br.com.luppi.pessoaapi.entity;

import br.com.luppi.pessoaapi.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "PET")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "SEQ_PET", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private TipoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;
}
