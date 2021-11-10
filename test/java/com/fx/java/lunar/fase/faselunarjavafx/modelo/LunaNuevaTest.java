package com.fx.java.lunar.fase.faselunarjavafx.modelo;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
class LunaNuevaTest extends Luna {
    private LunaNueva lunaNueva;

    public void escenario(){
        setLunaNueva(new LunaNueva());
    }

    public LunaNueva getLunaNueva() { return lunaNueva; }
    public void setLunaNueva(LunaNueva lunaNueva) { this.lunaNueva = lunaNueva; }


    @Test
    void testSetImagen() {
        escenario();
        getLunaNueva().cambiarFase();
        try {
            assertEquals(new Image(
                         new FileInputStream("src/main/resources/images/imagen1.png")).getUrl()
                         , getLunaNueva().getImagen().getUrl()
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCambiarFase() {
        escenario();
        getLunaNueva().cambiarFase();
    }

    @Override
    public void cambiarFase() {

    }
}