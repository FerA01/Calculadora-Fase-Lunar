package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaGibosaIluminante extends Luna{
    public LunaGibosaIluminante(){super();}
    public LunaGibosaIluminante(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Gibosa iluminante");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen3.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
