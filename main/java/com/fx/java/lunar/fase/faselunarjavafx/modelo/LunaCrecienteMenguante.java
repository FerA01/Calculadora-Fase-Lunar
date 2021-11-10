package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaCrecienteMenguante extends Luna{
    public LunaCrecienteMenguante(){super();}
    public LunaCrecienteMenguante(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Creciente menguante");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen7.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
