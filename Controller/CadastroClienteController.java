package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import Model.Cliente;
import Negocio.CadastroClienteNegocio;
import application.Main;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class CadastroClienteController implements Initializable{
	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtCpfCnpj;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtRazaoSocial;
	@FXML
	private TextField txtInscricaoEstadual;
	@FXML
	private TextField txtInscricaoMunicipal;	
	@FXML
	private TextField txtLimiteDeCredito;
	@FXML
	private TextField txtEndereco;
	@FXML
	private TextField txtNumero;
	@FXML
	private TextField txtBairro;
	@FXML
	private TextField txtComplemento;
	@FXML
	private TextField txtCidade;
	@FXML
	private ComboBox<String> cb_UF;
	@FXML
	private TextField txtCep;
	@FXML
	private TextField txtDdd1;
	@FXML
	private TextField txtTelefone1;
	@FXML
	private TextField txtDdd2;
	@FXML
	private TextField txtTelefone2;
	@FXML
	private TextField txtDdd3;
	@FXML
	private TextField txtTelefone3;
	@FXML
	private TextField txtEmail1;
	@FXML
	private TextField txtEmail2;
	@FXML
	private Button btnSalvar; 
	@FXML
	private Button 	btnLimpar;
	@FXML
	private Button BtnCancelar;
	
    List<Cliente> clientes = new ArrayList();
	Cliente cliente;
	Main main;
    CadastroClienteNegocio  cadastroClienteNegocio = new CadastroClienteNegocio();

	 public void initialize(URL location, ResourceBundle resources) {
	        txtId.setVisible(false);
	        txtId.setText("0");
	        cliente = new Cliente();
	        clientes = listarClientes();
	      	        	        
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
	       
	        cb_UF.getItems().addAll(estados);

	    }

	    private void pegaValores(Cliente cliente) {
	        cliente.setId(Integer.parseInt(txtId.getText()));
	        cliente.setCpf_cpnj(txtCpfCnpj.getText());
	        cliente.setRazao_social(txtRazaoSocial.getText());
	        cliente.setNome_fantasia(txtNome.getText());
	        cliente.setInsc_estadual(txtInscricaoEstadual.getText());
	        cliente.setInsc_municipal(txtInscricaoMunicipal.getText());
	        cliente.setEndereco(txtEndereco.getText());
	        cliente.setNumero(Integer.parseInt(txtNumero.getText()));
	        cliente.setComplemento(txtComplemento.getText());
	        cliente.setBairro(txtBairro.getText());
	        cliente.setCidade(txtCidade.getText());
	        cliente.setUf(cb_UF.getValue());
	        cliente.setCep(txtCep.getText());
	        cliente.setDddtel1(Integer.parseInt(txtDdd1.getText()));
	        cliente.setTelefone1(txtTelefone1.getText());
	        cliente.setDddtel2(Integer.parseInt(txtDdd2.getText()));
	        cliente.setTelefone2(txtTelefone2.getText());
	        cliente.setDddtel3(Integer.parseInt(txtDdd3.getText()));
	        cliente.setTelefone3(txtTelefone3.getText());
	        cliente.setEmail1(txtEmail1.getText());
	        cliente.setEmail2(txtEmail2.getText());
	        cliente.setDt_cadastro(LocalDate.now());
	       
	    }

	    

	    public void limpaCampos() {

	    	txtId.setText("0");
	        txtCpfCnpj.setText("");
	        txtRazaoSocial.setText("");
	        txtNome.setText("");
	        txtInscricaoEstadual.setText("");
	        txtInscricaoMunicipal.setText("");
	        txtEndereco.setText("");
	        txtNumero.setText("");
	        txtComplemento.setText("");
	        txtBairro.setText("");
	        txtCidade.setText("");
	        //txt
	        txtCep.setText("");
	        txtDdd1.setText("");
	        txtTelefone1.setText("");
	        txtDdd2.setText("");
	        txtTelefone2.setText("");
	        txtDdd3.setText("");
	        txtTelefone3.setText("");
	        txtEmail1.setText("");
	        txtEmail2.setText("");	 	    	    	
	    }
	    
	    @FXML
	    private void salvar() throws SQLException {
	        String validar;
	        boolean validacao = false;
	        cliente = new Cliente();
	        pegaValores(cliente);
	        validacao = validarCampos();
	        if(validacao) {
	            //if (cliente.getId() == 0) {
	                 validar = cadastroClienteNegocio.salvar(cliente);
	                if(validar.equals("salvo")) {
	                   

	                    String msg = "Cliente inserido!";
	                    exibeMensagem(msg);
	                    limpaCampos();
	                }else{
	                    exibeMensagem(validar);
	                }
	            } /*else {
	                validar = cadastroClienteNegocio.editar(cliente);
	                if (validar.equals("salvo")) {	                   
	                    String msg = "Objeto editado com sucesso!";
	                    exibeMensagem(msg);

	                    limpaCampos();
	                   // btnAcao.setText("Salvar");
	                }else{
	                    exibeMensagem(validar);
	                }
	            }
	        */

	    }
	   
	    public List<Cliente> listarClientes(){
	        clientes = cadastroClienteNegocio.listarClientes();
	        return clientes;
	    }
	    
	    public boolean validarCampos(){
            String cpf_cnpj = txtCpfCnpj.getText() ;
            String razao_social = txtRazaoSocial.getText();
            String nome_fantasia = txtNome.getText();
            String endereco = txtEndereco.getText();
            String numero = txtNumero.getText();
            String bairro = txtBairro.getText();
            String cidade = txtCidade.getText();
            String uf = cb_UF.getValue();
            String cep = txtCep.getText();
            String dddtel1 = txtDdd1.getText();
            String telefone1 = txtTelefone1.getText();
            String email1 = txtEmail1.getText();
            

            List<Control>  controls = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            
            if(cpf_cnpj.equals("") || cpf_cnpj == null){
                sb.append("O CPF/CNPJ não pode ser vazio!. \n");
                controls.add(txtCpfCnpj);
                }
            
            if(razao_social.equals("") || razao_social == null){
                sb.append("A Razão Social telefone não pode ser vazio!. \n");
                controls.add(txtRazaoSocial);
                }
            if(nome_fantasia.equals("") || nome_fantasia == null){
                sb.append("Nome Fantasia não pode ser vazio!. \n");
                controls.add(txtNome);
                }
            if(endereco.equals("") || endereco == null){
                sb.append("O endereço não pode ser vazio!. \n");
                controls.add(txtEndereco);
                }
            if(numero.equals("") || numero == null){
                sb.append("O Número não pode ser vazio!. \n");
                controls.add(txtNumero);
                }
            if(bairro.equals("") || bairro == null){
                sb.append("O bairro não pode ser vazio!. \n");
                controls.add(txtBairro);
                }
            if(cidade.equals("") || cidade == null){
                sb.append("A cidade não pode ser vazio!. \n");
                controls.add(txtCidade);
                }
            if( uf == null){
                sb.append("A UF não pode ser vazio!. \n");
                controls.add(cb_UF);
                }
            if(cep.equals("") || cep == null){
                sb.append("O CEP não pode ser vazio!. \n");
                controls.add(txtCep);
                }
            if(dddtel1.equals("") || dddtel1 == null){
                sb.append("O DDD não pode ser vazio!. \n");
                controls.add(txtDdd1);
                }
            if(telefone1.equals("") || telefone1 == null){
                sb.append("O telefone não pode ser vazio!. \n");
                controls.add(txtTelefone1);
                }
            
            if(email1.equals("") || email1 == null){
                sb.append("O e-mail não pode ser vazio!. \n");
                controls.add(txtEmail1);
                }
            
            if(!sb.equals("")) {
                exibeMensagem(sb.toString());
                animaCamposValidados(controls);
            }

            return sb.toString().isEmpty();
    }

    public void animaCamposValidados(List<Control> controls) {
        controls.forEach(control -> {
            RotateTransition rotateTransition = new RotateTransition(Duration.millis(60), control);
            rotateTransition.setFromAngle(-4);
            rotateTransition.setToAngle(4);
            rotateTransition.setCycleCount(8);
            rotateTransition.setAutoReverse(true);
            rotateTransition.setOnFinished((ActionEvent event1) ->{
                control.setRotate(0);
            });
            rotateTransition.play();
        });
        if(!controls.isEmpty()){
            controls.get(0).requestFocus();
        }
    }

    public void exibeMensagem(String msg){
        Notifications.create()
                .title("Atenção")
                .text(String.valueOf(msg))
                .owner(main)
                .hideAfter(Duration.seconds(3))
                .darkStyle()
                .position(Pos.TOP_RIGHT)
                .showInformation();
        }


}
