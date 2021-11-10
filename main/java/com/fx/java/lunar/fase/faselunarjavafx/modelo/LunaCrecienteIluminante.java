package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LunaCrecienteIluminante extends Luna{
    public LunaCrecienteIluminante(){super();}
    public LunaCrecienteIluminante(Image image){ super(image); }

    @Override
    public void cambiarFase() {
        setNombreFaseLuna("Creciente iluminante");
        try {
            setImagen(new Image(new FileInputStream("src/main/resources/images/imagen1.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No cargo la imagen");
        }
    }
}
