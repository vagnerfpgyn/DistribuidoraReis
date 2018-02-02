package application;
	
import java.awt.event.ActionEvent;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	 @Override
	    public void start(Stage principal) throws Exception{
	            VBox raiz = new VBox(10); // 1
	            raiz.setAlignment(Pos.CENTER); // 2
	         URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaPrincipal.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	            Scene cena = new Scene(fxmlParent, 540, 850); //1250, 900
	             principal.setTitle("SGDR - Sistema de Gestão Distribuidora Reis");
	             principal.setScene(cena);
	             principal.show();


	    }

	    public void handle(ActionEvent evento) {
	        System.out.println("Evento tratado na próxima classe!");
	    }


	    public static void main(String[] args) {
	        launch(args);
	    }

}
