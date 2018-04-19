package com.dailystatusapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_teste")
public class ItemTeste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_item_teste")
    private Long codigo;

    @Column(name = "ds_task", unique = true)
    private String dsTask;

    @Column(name = "tp_task")
    private String tpTask;

    @Column(name = "ds_link_task")
    private String linkTask;

    @Column(name = "nm_cliente")
    private String nmCliente;

    @Column(name = "ds_observacao")
    private String observacao;

    @Column(name = "ds_motivo_reprovacao")
    private String dsMotivoReprovacao;

    @Column(name = "tp_status")
    private String tpStatus;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    @ManyToOne
    @JoinColumn(name = "cd_usuario_criacao")
    private Usuario usuarioCriacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_build")
    private Build build;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDsTask() {
        return dsTask;
    }

    public void setDsTask(String dsTask) {
        this.dsTask = dsTask;
    }

    public String getTpTask() {
        return tpTask;
    }

    public void setTpTask(String tpTask) {
        this.tpTask = tpTask;
    }

    public String getLinkTask() {
        return linkTask;
    }

    public void setLinkTask(String linkTask) {
        this.linkTask = linkTask;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDsMotivoReprovacao() {
        return dsMotivoReprovacao;
    }

    public void setDsMotivoReprovacao(String dsMotivoReprovacao) {
        this.dsMotivoReprovacao = dsMotivoReprovacao;
    }

    public String getTpStatus() {
        return tpStatus;
    }

    public void setTpStatus(String tpStatus) {
        this.tpStatus = tpStatus;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Usuario getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(Usuario usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }
}
