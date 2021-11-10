package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaNueva extends Luna{
    public LunaNueva(){super();}
    public LunaNueva(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Luna nueva");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen0.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
