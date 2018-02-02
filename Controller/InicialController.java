package Controller;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class InicialController {
	
	@FXML
	private Pane paneInicial;	
	@FXML
	private MenuBar menuPrincipal;
	@FXML
	private MenuItem itemMenuCadastrarCliente;
	@FXML
	private MenuItem menuItemCadastrarFonecedor;
	@FXML
	private MenuItem menuItemCadastrarProdutos;
	@FXML
	private MenuItem menuItemCadastrarStatusCliente;
	@FXML
	private MenuItem menuItemConsultarCliente;
	@FXML
	private MenuItem menuItemConsultarFornecedor;
	@FXML
	private MenuItem menuItemConsultarProduto;
	
	  public void abrirJanelaCadastrarCliente() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaCadastroCliente.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }

	  public void abrirJanelaCadastrarFornecedor() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaCadastroFornecedor.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }

	  public void abrirJanelaCadastrarProduto() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaCadastroProduto.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }
	  
	  public void abrirJanelaCadastrarStatusCliente() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaCadastroStatusCliente.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }
	  
	  public void abrirJanelaConsultarCliente() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaConsultaCliente.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }
	  
	  public void abrirJanelaConsultarFornecedor() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaConsultaFornecedor.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }
	  
	  public void abrirJanelaConsultarProduto() throws IOException {
	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaConsultaProduto.fxml");
	        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
	        paneInicial.getChildren().clear();
	        paneInicial.getChildren().add(fxmlParent);	        
	    }
}
