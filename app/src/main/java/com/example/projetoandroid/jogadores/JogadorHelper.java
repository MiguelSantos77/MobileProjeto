package com.example.projetoandroid.jogadores;

import android.content.Intent;

public class JogadorHelper {

    private String nome;
    private String idClube;

    private String PAC;
    private String DRI;
    private String SHO;
    private String DEF;
    private String PAS;
    private String PHY;



    JogadorHelper(){

    }
    JogadorHelper(String nome, String idClube, String PAC, String DRI, String SHO, String DEF,
                  String PAS,String PHY){
        this.nome= nome;
        this.idClube = idClube;
        this.PAC = PAC;
        this.DRI = DRI;
        this.SHO = SHO;
        this.DEF = DEF;
        this.PAS= PAS;
        this.PHY = PHY;

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdClube() {
        return idClube;
    }

    public void setIdClube(String idClube) {
        this.idClube = idClube;
    }

    public String getPAC() {
        return PAC;
    }

    public void setPAC(String PAC) {
        this.PAC = PAC;
    }

    public String getDRI() {
        return DRI;
    }

    public void setDRI(String DRI) {
        this.DRI = DRI;
    }

    public String getSHO() {
        return SHO;
    }

    public void setSHO(String SHO) {
        this.SHO = SHO;
    }

    public String getDEF() {
        return DEF;
    }

    public void setDEF(String DEF) {
        this.DEF = DEF;
    }

    public String getPAS() {
        return PAS;
    }

    public void setPAS(String PAS) {
        this.PAS = PAS;
    }

    public String getPHY() {
        return PHY;
    }

    public void setPHY(String PHY) {
        this.PHY = PHY;
    }
}
