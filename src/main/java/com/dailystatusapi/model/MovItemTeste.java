package com.dailystatusapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mov_item_teste")
public class MovItemTeste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_mov_item_teste")
    private Long codigo;

    @Column(name = "tp_status_item")
    private String tpStatusItem;

    @Column(name = "dt_inicio_mov")
    private LocalDateTime dtInicioMov;

    @ManyToOne
    @JoinColumn(name = "cd_usuario_inicio_mov")
    private Usuario usuarioInicioMov;

    @Column(name = "dt_fim_mov")
    private LocalDateTime dtFimMov;

    @ManyToOne
    @JoinColumn(name = "cd_usuario_fim_mov")
    private Usuario usuarioFimMov;

    @ManyToOne
    @JoinColumn(name = "cd_item_teste")
    private ItemTeste itemTeste;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTpStatusItem() {
        return tpStatusItem;
    }

    public void setTpStatusItem(String tpStatusItem) {
        this.tpStatusItem = tpStatusItem;
    }

    public LocalDateTime getDtInicioMov() {
        return dtInicioMov;
    }

    public void setDtInicioMov(LocalDateTime dtInicioMov) {
        this.dtInicioMov = dtInicioMov;
    }

    public Usuario getUsuarioInicioMov() {
        return usuarioInicioMov;
    }

    public void setUsuarioInicioMov(Usuario usuarioInicioMov) {
        this.usuarioInicioMov = usuarioInicioMov;
    }

    public LocalDateTime getDtFimMov() {
        return dtFimMov;
    }

    public void setDtFimMov(LocalDateTime dtFimMov) {
        this.dtFimMov = dtFimMov;
    }

    public Usuario getUsuarioFimMov() {
        return usuarioFimMov;
    }

    public void setUsuarioFimMov(Usuario usuarioFimMov) {
        this.usuarioFimMov = usuarioFimMov;
    }

    public ItemTeste getItemTeste() {
        return itemTeste;
    }

    public void setItemTeste(ItemTeste itemTeste) {
        this.itemTeste = itemTeste;
    }
}
