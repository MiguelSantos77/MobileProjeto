package com.example.projetoandroid.jogadores;

import android.content.Intent;

public class AvaliacaoHelper {

    private String username;
    private String idJogador;

    private String PAC;
    private String DRI;
    private String SHO;
    private String DEF;
    private String PAS;
    private String PHY;



    AvaliacaoHelper(){

    }

    AvaliacaoHelper(String username, String idJogador, String PAC, String DRI, String SHO, String DEF,
                  String PAS,String PHY){
        this.username= username;
        this.idJogador = idJogador;
        this.PAC = PAC;
        this.DRI = DRI;
        this.SHO = SHO;
        this.DEF = DEF;
        this.PAS= PAS;
        this.PHY = PHY;

    }



}
