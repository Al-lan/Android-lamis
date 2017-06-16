package com.br.ucsal.lamis;

/**
 * Created by alan on 15/06/17.
 */

public class Lami {

    private int idLami;

    private int [][] horario;

    public Lami() {
    }

    public Lami(int idLami, int[][] horario) {
        super();
        this.idLami = idLami;
        this.horario = horario;
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

    public int[][] getHorario() {
        return horario;
    }

    public void setHorario(int[][] horario) {
        this.horario = horario;
    }

}
