package com.br.ucsal.lamis.model;

public class Lami {

    private int idLami;

    private int situacaoAtual;

    private int[][] horarios;

    public Lami(int idLami, int situacaoAtual) {
        super();
        this.idLami = idLami;
        this.situacaoAtual = situacaoAtual;
    }

    public Lami(int idLami, int situacaoAtual, int[][] horarios) {
        super();
        this.idLami = idLami;
        this.situacaoAtual = situacaoAtual;
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Lami " + idLami;
    }

    public int getIdLami() {
        return idLami;
    }

    public void setIdLami(int idLami) {
        this.idLami = idLami;
    }

    public int getSituacaoAtual() {
        return situacaoAtual;
    }

    public void setSituacaoAtual(int situacaoAtual) {
        this.situacaoAtual = situacaoAtual;
    }

    public int[][] getHorarios() {
        return horarios;
    }

    public void setHorarios(int[][] horarios) {
        this.horarios = horarios;
    }

}
