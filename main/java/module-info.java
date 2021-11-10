module com.fx.java.lunar.fase.faselunarjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fx.java.lunar.fase.faselunarjavafx to javafx.fxml;
    exports com.fx.java.lunar.fase.faselunarjavafx;
    exports com.fx.java.lunar.fase.faselunarjavafx.controladores;
    opens com.fx.java.lunar.fase.faselunarjavafx.controladores to javafx.fxml;
}