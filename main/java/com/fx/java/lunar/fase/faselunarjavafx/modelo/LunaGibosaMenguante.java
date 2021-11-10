package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaGibosaMenguante extends Luna{
    public LunaGibosaMenguante(){super();}
    public LunaGibosaMenguante(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Gibosa menguante");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen5.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
