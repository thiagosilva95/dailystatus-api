package com.dailystatusapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_build")
    private Long codigo;

    @NotNull
    @Column(name = "nm_build")
    private String nome;

    @NotNull
    @Column(name = "tp_status")
    private String tpStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_produto")
    private Produto produto;

    @OneToMany(mappedBy = "build")
    private List<ItemTeste> itens;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTpStatus() {
        return tpStatus;
    }

    public void setTpStatus(String tpStatus) {
        this.tpStatus = tpStatus;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
