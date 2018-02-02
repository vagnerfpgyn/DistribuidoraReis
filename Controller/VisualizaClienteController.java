package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.Cliente;
import Negocio.CadastroClienteNegocio;
import Negocio.VisualizaClienteNegocio;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VisualizaClienteController implements Initializable{
	static Cliente cliente = new Cliente();
	VisualizaClienteNegocio editarClienteNegocio = new VisualizaClienteNegocio();
	CadastroClienteController cadastroClienteController = new CadastroClienteController();
	
	@FXML
	private Label lblCpfCnpj;
	@FXML
	private TextField txtID;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtRazaoSocial;
	@FXML
	private TextField txtIEstadual;
	@FXML
	private TextField txtIMunicipal;
	@FXML
	private TextField txtEndereco;
	@FXML
	private TextField txtNumero;
	@FXML
	private TextField txtComplemento;
	@FXML	
	private TextField txtBairro;
	@FXML
	private TextField txtCidade;
	@FXML
	private ComboBox <String> cbEstado;
	@FXML
	private TextField txtCEP;
	@FXML
	private TextField txtDDD1;
	@FXML
	private TextField txtTel1;
	@FXML
	private TextField txtDDD2;
	@FXML
	private TextField txtTel2;
	@FXML
	private TextField txtDDD3;
	@FXML
	private TextField txtTel3;
	@FXML
	private TextField txtEmail1;
	@FXML
	private TextField txtEmail2;
	@FXML
	private Label lblDtCadastro;
	@FXML
	private Button btnEditar;
	
	Main main = null;
	
	  @FXML
	    public void SetarClienteSessao(Cliente cliente){
	        this.cliente = cliente;	  
	  }
	  
	  public static void setarCliente(Cliente cli){
		  cliente = cli;
	  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			
		setaValores(cliente);
		
		
		txtNome.setEditable(false);
	}
	
	public void editarCliente() {
		
		txtNome.setStyle("-fx-background-color: white");
		txtNome.setEditable(true);
		txtRazaoSocial.setStyle("-fx-background-color: white");
		txtRazaoSocial.setEditable(true);
		txtIEstadual.setStyle("-fx-background-color: white");
		txtIEstadual.setEditable(true);
		txtIMunicipal.setStyle("-fx-background-color: white");
		txtIMunicipal.setEditable(true);
		txtEndereco.setStyle("-fx-background-color: white");
		txtEndereco.setEditable(true);
		txtNumero.setStyle("-fx-background-color: white");
		txtNumero.setEditable(true);
		txtComplemento.setStyle("-fx-background-color: white");
		txtComplemento.setEditable(true);
		txtBairro.setStyle("-fx-background-color: white");
		txtBairro.setEditable(true);
		txtCidade.setStyle("-fx-background-color: white");
		txtCidade.setEditable(true);
		cbEstado.setStyle("-fx-background-color: white");
		cbEstado.setEditable(true);
		txtCEP.setStyle("-fx-background-color: white");
		txtCEP.setEditable(true);
		txtDDD1.setStyle("-fx-background-color: white");
		txtDDD1.setEditable(true);
		txtTel1.setStyle("-fx-background-color: white");
		txtTel1.setEditable(true);
		txtDDD2.setStyle("-fx-background-color: white");
		txtDDD2.setEditable(true);
		txtTel2.setStyle("-fx-background-color: white");
		txtTel2.setEditable(true);
		txtDDD3.setStyle("-fx-background-color: white");
		txtDDD3.setEditable(true);
		txtTel3.setStyle("-fx-background-color: white");
		txtTel3.setEditable(true);
		txtEmail1.setStyle("-fx-background-color: white");
		txtEmail1.setEditable(true);
		txtEmail2.setStyle("-fx-background-color: white");
		txtEmail2.setEditable(true);
		
		List<String> estados = new ArrayList<String>();
        estados.add("AC");
        estados.add("AL");
        estados.add("AP");
        estados.add("AM");
        estados.add("BA");
        estados.add("CE");
        estados.add("DF");
        estados.add("ES");
        estados.add("GO");
        estados.add("MA");
        estados.add("MT");
        estados.add("MS");
        estados.add("MG");
        estados.add("PA");
        estados.add("PB");
        estados.add("PR");
        estados.add("PE");
        estados.add("PI");
        estados.add("RJ");
        estados.add("RN");
        estados.add("RS");
        estados.add("RR");
        estados.add("RO");
        estados.add("SC");
        estados.add("SP");
        estados.add("SE");
        estados.add("TO");
       
        cbEstado.getItems().addAll(estados);

    }
		
		private void setaValores(Cliente cliente) {

        txtID.setText(String.valueOf(cliente.getId()));
        lblCpfCnpj.setText(cliente.getCpf_cpnj());
        txtRazaoSocial.setText(cliente.getRazao_social());
        txtNome.setText(cliente.getNome_fantasia());
        txtIEstadual.setText(cliente.getInsc_estadual());
        txtIMunicipal.setText(cliente.getInsc_municipal());
        txtEndereco.setText(cliente.getEndereco());
        txtNumero.setText(String.valueOf(cliente.getNumero()));
        txtComplemento.setText(cliente.getComplemento());
        txtBairro.setText(cliente.getBairro());
        txtCidade.setText(cliente.getCidade());
        cbEstado.setValue(cliente.getUf());
        txtCEP.setText(cliente.getCep());
        txtDDD1.setText(String.valueOf(cliente.getDddtel1()));
        txtTel1.setText(cliente.getTelefone1());
        txtDDD2.setText(String.valueOf(cliente.getDddtel2()));
        txtTel2.setText(cliente.getTelefone2());
        txtDDD3.setText(String.valueOf(cliente.getDddtel3()));
        txtTel3.setText(cliente.getTelefone3());
        txtEmail1.setText(cliente.getEmail1());
        txtEmail2.setText(cliente.getEmail2());
        lblDtCadastro.setText(String.valueOf(cliente.getDt_cadastro()));
    }
		
		private void pegaValores(Cliente cliente) {
	        cliente.setId(Integer.parseInt(txtID.getText()));
	        cliente.setRazao_social(txtRazaoSocial.getText());
	        cliente.setNome_fantasia(txtNome.getText());
	        cliente.setInsc_estadual(txtIEstadual.getText());
	        cliente.setInsc_municipal(txtIMunicipal.getText());
	        cliente.setEndereco(txtEndereco.getText());
	        cliente.setNumero(Integer.parseInt(txtNumero.getText()));
	        cliente.setComplemento(txtComplemento.getText());
	        cliente.setBairro(txtBairro.getText());
	        cliente.setCidade(txtCidade.getText());
	        cliente.setUf(cbEstado.getValue());
	        cliente.setCep(txtCEP.getText());
	        cliente.setDddtel1(Integer.parseInt(txtDDD1.getText()));
	        cliente.setTelefone1(txtTel1.getText());
	        cliente.setDddtel2(Integer.parseInt(txtDDD2.getText()));
	        cliente.setTelefone2(txtTel2.getText());
	        cliente.setDddtel3(Integer.parseInt(txtDDD3.getText()));
	        cliente.setTelefone3(txtTel3.getText());
	        cliente.setEmail1(txtEmail1.getText());
	        cliente.setEmail2(txtEmail2.getText());
	        cliente.setDt_cadastro(LocalDate.now());
	       
	    }
		
		public void salvarEdicao() throws SQLException {
			pegaValores(cliente);
			String validar;
			 validar = editarClienteNegocio.editarCliente(cliente);
             if (validar.equals("salvo")) {	                   
                 String msg = "Objeto editado com sucesso!";
                 cadastroClienteController.exibeMensagem(msg);

               
             }else{
                 cadastroClienteController.exibeMensagem(validar);
             }
			
			
		}

}
