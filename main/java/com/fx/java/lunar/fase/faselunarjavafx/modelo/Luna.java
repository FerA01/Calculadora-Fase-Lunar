package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

public abstract class Luna implements Fase{
    private Image imagen;
    private String nombreFaseLuna;

    public Luna(){ setImagen(null); setNombreFaseLuna("");}
    public Luna(Image imagen){ setImagen(imagen); setNombreFaseLuna("");}

    public Image getImagen() { return this.imagen; }
    public void setImagen(Image imagen) { this.imagen = imagen; }
    public String getNombreFaseLuna() { return nombreFaseLuna; }
    public void setNombreFaseLuna(String nombreFaseLuna) { this.nombreFaseLuna = nombreFaseLuna; }

    public abstract void cambiarFase();
}
