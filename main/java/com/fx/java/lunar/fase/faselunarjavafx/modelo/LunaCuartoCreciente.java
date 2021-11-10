package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaCuartoCreciente extends Luna{
    public LunaCuartoCreciente(){super();}
    public LunaCuartoCreciente(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Cuarto creciente");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen2.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
