package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Cliente;
import daoUtil.ConnectionFactory;

public class EditarClienteDao {
	
	ConnectionFactory connection = null;
    private Connection con;
    private PreparedStatement stmt;

    public EditarClienteDao() {
        ConnectionFactory cf = new ConnectionFactory();
        con = cf.getConnection();
    }
	
    
    String sqlEditar = "UPDATE clientes SET cpf_cpnj = ?, razao_social = ?, nome_fantasia = ?," +
            "i_estadual = ?, i_municipal = ?, endereco = ?, numero = ?, complemento = ?," +
            "bairro = ?, cidade=?, uf = ?, cep = ?, ddd1 = ?, telefone1 = ?, ddd2 = ?, "
            + "telefone2 = ?, ddd3 = ?, telefone3 = ?, email1 = ?, email2 = ?, dt_cadastro = ?  WHERE id = ?";

    String sqlDeletar = "DELETE from clientes where id = ?";
    public String Editar(Cliente cliente) {
        String deletado = "falha";
        try {
            con.setAutoCommit(false);
            stmt = (PreparedStatement) con.prepareStatement(sqlDeletar);

            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();
            con.commit();
            deletado = "deletado";

        } catch (SQLException e) {
            System.out.println("Erro na exclusão :" + e.getMessage());
            deletado = e.getMessage();
        }

        return deletado;
    }

   
    public String editarCliente(Cliente cliente) throws SQLException {
        String salvo = "falha";
        try {
            con.setAutoCommit(false);
            stmt = (PreparedStatement) con.prepareStatement(sqlEditar);

            stmt.setString(1, cliente.getCpf_cpnj());
            stmt.setString(2,cliente.getRazao_social());
            stmt.setString(3, cliente.getNome_fantasia());
            stmt.setString(4, cliente.getInsc_estadual());
            stmt.setString(5, cliente.getInsc_municipal());
            stmt.setString(6, cliente.getEndereco());
            stmt.setInt(7,  cliente.getNumero());
            stmt.setString(8,cliente.getComplemento());
            stmt.setString(9,  cliente.getBairro());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11,  cliente.getUf());
            stmt.setString(12, cliente.getCep());
            stmt.setInt(13, cliente.getDddtel1());
            stmt.setString(14, cliente.getTelefone1());
            stmt.setInt(15, cliente.getDddtel2());
            stmt.setString(16,  cliente.getTelefone2());
            stmt.setInt(17, cliente.getDddtel3());
            stmt.setString(18, cliente.getTelefone3());
            stmt.setString(19, cliente.getEmail1());
            stmt.setString(20, cliente.getEmail2());
            stmt.setDate(21, Date.valueOf(cliente.getDt_cadastro())); 
            stmt.setInt(22, cliente.getId());

            stmt.executeUpdate();
            con.commit();
            salvo = "salvo";


        }catch (Exception e){
            System.out.println("erro ao atualizar " + e.getMessage());
            salvo = e.getMessage();
        }
        return salvo;
    }

    public String deletar(Cliente cliente) throws SQLException {
        String salvo = "falha";
        try {
            con.setAutoCommit(false);
            stmt = (PreparedStatement) con.prepareStatement(sqlEditar);

            stmt.setString(1, cliente.getCpf_cpnj());
            stmt.setString(2,cliente.getRazao_social());
            stmt.setString(3, cliente.getNome_fantasia());
            stmt.setString(4, cliente.getInsc_estadual());
            stmt.setString(5, cliente.getInsc_municipal());
            stmt.setString(6, cliente.getEndereco());
            stmt.setInt(7,  cliente.getNumero());
            stmt.setString(8,cliente.getComplemento());
            stmt.setString(9,  cliente.getBairro());
            stmt.setString(10, cliente.getCidade());
            stmt.setString(11,  cliente.getUf());
            stmt.setString(12, cliente.getCep());
            stmt.setString(13, cliente.getTelefone1());
            stmt.setString(14,  cliente.getTelefone2());
            stmt.setString(15, cliente.getTelefone3());
            stmt.setString(16, cliente.getEmail1());
            stmt.setString(17, cliente.getEmail2());
            stmt.setDate(18, Date.valueOf(cliente.getDt_cadastro())); 
            stmt.setInt(19, cliente.getId());

            stmt.executeUpdate();
            con.commit();
            salvo = "salvo";


        }catch (Exception e){
            System.out.println("erro ao atualizar " + e.getMessage());
            salvo = e.getMessage();
        }
        return salvo;
    }

}
