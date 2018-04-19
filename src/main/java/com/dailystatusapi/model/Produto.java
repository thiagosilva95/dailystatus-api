package com.dailystatusapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_produto")
    private Long codigo;

    @NotNull
    @Column(name = "nm_produto")
    private String nome;

    @Column(name = "sn_ativo", length = 1)
    private String snAtivo;

    @OneToMany(mappedBy = "produto")
    private List<Build> builds;

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

    public String getSnAtivo() {
        return snAtivo;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }
}
