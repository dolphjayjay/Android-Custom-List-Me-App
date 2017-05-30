package com.idemobi.customlistmeapp;

/**
 * Created by Jerome Demyttenaere on 30/05/2017.
 */
class People {
    private int color;
    private String pseudo;
    private String text;

    People(int color, String pseudo, String text) {
        this.color = color;
        this.pseudo = pseudo;
        this.text = text;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }

    String getPseudo() {
        return pseudo;
    }

    void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }
}
