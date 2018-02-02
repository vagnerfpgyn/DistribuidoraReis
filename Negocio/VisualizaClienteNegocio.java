package Negocio;

import java.sql.SQLException;

import Controller.CadastroClienteController;
import Dao.EditarClienteDao;
import Model.Cliente;

public class VisualizaClienteNegocio {
	CadastroClienteNegocio cadastroClienteNegocio =new CadastroClienteNegocio();
	EditarClienteDao editarClienteDao = new EditarClienteDao();
	
	public String editarCliente(Cliente cliente) throws SQLException {

        boolean email1Valido = false;
        boolean email2Valido = false;
        String salvo = "falha";
        StringBuilder sb = new StringBuilder();
        
        email1Valido = cadastroClienteNegocio.isEmailValid(cliente.getEmail1());
        if (!email1Valido) {
            sb.append("E-mail 1 inválido. \n");
        }
       
        String email2 = cliente.getEmail2();
        if (!(email2.isEmpty())){
        email2Valido = cadastroClienteNegocio.isEmailValid(cliente.getEmail2());
        if (!email1Valido) {
            sb.append("E-mail 2 inválido. \n");
        }
       }
        if (sb.toString().isEmpty()) {
            salvo = editarClienteDao.editarCliente(cliente);
        } else {
            sb.append(salvo);
            return sb.toString();
        }
        sb.append(salvo);
        return sb.toString();
    }

}
