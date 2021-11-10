package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaLlena extends Luna{
    public LunaLlena(){super();}
    public LunaLlena(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Luna llena");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen4.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
