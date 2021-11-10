package com.fx.java.lunar.fase.faselunarjavafx.controladores;
import com.fx.java.lunar.fase.faselunarjavafx.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.converter.LocalDateStringConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ControladorFaseLunar {
    private final String FORMATOFECHA = "dd-MM-yyyy";
    @FXML
    private Label etiquetaFaseLunar;
    @FXML
    public DatePicker fecha;
    @FXML
    public Button botonObtenerFecha;
    @FXML
    private ImageView marcoImagen;

    public Label getEtiquetaFaseLunar() { return etiquetaFaseLunar; }
    public void setEtiquetaFaseLunar(Label etiquetaFaseLunar) { this.etiquetaFaseLunar = etiquetaFaseLunar; }
    public DatePicker getFecha() { return fecha; }
    public void setFecha(DatePicker fecha) { this.fecha = fecha; }
    public Button getBotonObtenerFecha() { return botonObtenerFecha; }
    public void setBotonObtenerFecha(Button botonObtenerFecha) { this.botonObtenerFecha = botonObtenerFecha; }
    public ImageView getMarcoImagen() { return marcoImagen; }
    public void setMarcoImagen(ImageView marcoImagen) { this.marcoImagen = marcoImagen; }

    /**Calcula la posición de la luna***/
    private int determinarPosicion(Date d){
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        int dia = cal.get(Calendar.DATE);
        int mes = cal.get(Calendar.MONTH);
        int anio = cal.get(Calendar.YEAR);

        double c, e, jd = 0.0;
        int b = 0;
        if(dia < 3) {
            anio--;
            mes += 12;
        }
        mes++;
        c = 365.25 * anio;
        e = 30.6 * mes;
        jd = c + e + dia - 694039.09;
        jd /= 29.5305882;
        b = (int) jd;
        jd -= b;
        b = (int)Math.round(jd * 8);

        if(b >= 8){
            b = 0;
        }
        return b;
    }

    /**Establece la fase lunar**/
    public Luna calcularFase(Date d) {
        switch(determinarPosicion(d) ) {
            case 0:
                return new LunaNueva();
            case 1:
                return new LunaCrecienteIluminante();
            case 2:
                return new LunaCuartoCreciente();
            case 3:
                return new LunaGibosaIluminante();
            case 4:
                return new LunaLlena();
            case 5:
                return new LunaGibosaMenguante();
            case 6:
                return new LunaCuartoMenguante();
            case 7:
                return new LunaCrecienteMenguante();
        }
        throw new RuntimeException("Error al determinar la fase de la luna.");
    }
    @FXML
    public void obtenerFaseLunar(ActionEvent evento){
        evento.consume();
        //Obtener fecha dd-MM-aaaa
        Date fecha = obtenerFechaElegida();
        if (fecha!=null){
            //Obtener fase lunar segun fecha
            Luna luna = calcularFase(fecha);
            luna.cambiarFase();
            //Setear datos a la etiqueta e imagen
            getEtiquetaFaseLunar().setText(luna.getNombreFaseLuna());
            getMarcoImagen().setImage(luna.getImagen());
        }else {
            System.out.println("La fecha obtenida es nula.");
        }

    }
    private LocalDate ingresoFecha(){
        boolean condicion = true;
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText("Ingrese una fecha.");
        try{
            return getFecha().getValue();
        }catch (NullPointerException e){
            while (getFecha().getValue() == null){
            }
        }
        return null;
    }
    private Date transformarADate(String fecha) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
    }
    private Date obtenerFechaElegida(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATOFECHA);
        fecha.setConverter(new LocalDateStringConverter(formato, null));
        LocalDate fechaElegida = fecha.getValue();
        String fechaElegidaAString = formato.format(fechaElegida);
        try {
            return transformarADate(fechaElegidaAString);

        }catch (ParseException e){
            e.printStackTrace();
            System.out.println("Error en la conversión.");
        }
        return null;
    }
}