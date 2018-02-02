package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ConsultaClienteController implements Initializable{
	
	@FXML
	private TableView  tblClientes;
	@FXML
	private TableColumn  clCodigo;
	@FXML
	private TableColumn clCpfCnpj;
	@FXML
	private TableColumn clRazaoSocial;
	@FXML
	private TableColumn clFantasia;
	@FXML
	private TableColumn clCidade;
	@FXML
	private CadastroClienteController cadastroCliente;
	@FXML
	private Cliente cliente;

	
	
	
    List<Cliente> clientes = new ArrayList();
    ObservableList<Cliente> clientesView = null;
    VisualizaClienteController visualizaClienteController = new VisualizaClienteController();
	
	 public void initialize(URL location, ResourceBundle resources) {
		 cadastroCliente = new CadastroClienteController();
		 cliente = new Cliente();
	        clientes = cadastroCliente.listarClientes();
	        
	        populaView(clientes);

	    }
	 
	 public void populaView(List<Cliente> clientes){
		 clCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
		 clCpfCnpj.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf_cpnj"));
		 clRazaoSocial.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("razao_social"));
		 clFantasia.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome_fantasia"));
		 clCidade.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cidade"));
		 clientesView = FXCollections.observableArrayList(clientes);
		 tblClientes.setItems(clientesView);

	    }
	
	 
	 public Cliente setarCliente(Cliente cliente){
	        cliente = this.cliente;
	        visualizaClienteController.setarCliente(cliente);
	        return cliente;
	    }
	 
	  @FXML
	    public void visualiza() throws IOException{

	        cliente = new Cliente();
	        cliente = (Cliente) tblClientes.getSelectionModel().getSelectedItem();
	        telaVisualizaCliente(null);
	        
	  }

	  public void telaVisualizaCliente (ActionEvent t) throws IOException  {	 
		  
	        visualizaClienteController.setarCliente(cliente);

	        URL arquivoFXML;
	        arquivoFXML = getClass().getResource("/Visao/telaVisualizaCliente.fxml");
	        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);

	        Stage stage = new Stage();
	        Scene scene = new Scene(fxmlParent, 881, 600);
	        stage.setScene(scene);
	        stage.setTitle("Visualiza Cliente");			
	        stage.show();	   
	  }
	  
	private void telaVisualizaCliente(Object object) {
		// TODO Auto-generated method stub
		
	}
	          
	 

}
