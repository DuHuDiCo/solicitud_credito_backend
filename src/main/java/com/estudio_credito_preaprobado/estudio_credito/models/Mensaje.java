
package com.estudio_credito_preaprobado.estudio_credito.models;


public class Mensaje {
    
    private String to;
    private String text;

    public Mensaje() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "to=" + to + ", text=" + text + '}';
    }
    
    
    

}
