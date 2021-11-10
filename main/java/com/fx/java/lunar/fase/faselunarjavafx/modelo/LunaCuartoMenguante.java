package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaCuartoMenguante extends Luna{
    public LunaCuartoMenguante(){super();}
    public LunaCuartoMenguante(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Cuarto menguante");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen6.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
