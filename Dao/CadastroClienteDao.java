package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import Model.Cliente;
import daoUtil.ConnectionFactory;

public class CadastroClienteDao {
	
	ConnectionFactory connection = null;
    private Connection con;
    private Statement stm;
    private PreparedStatement stmt;

    public CadastroClienteDao() {
        ConnectionFactory cf = new ConnectionFactory();
        con = cf.getConnection();
    }


    String sqlSalvar = "INSERT INTO distribuidoraReis.clientes" +
            "(cpf_cpnj,razao_social, nome_fantasia,i_estadual,i_municipal,endereco,numero,"
            + "complemento,bairro,cidade, uf, cep, ddd1, telefone1, ddd2, telefone2, ddd3,"
            +  	"telefone3, email1, email2, dt_cadastro)" +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String sqlEditar = "UPDATE clientes SET nome = ?, sobrenome = ?," +
            "cpf = ?, rg = ?, telefone = ?, celular = ?, endereco = ?," +
            "email = ?  WHERE id = ?";

    String sqlDeletar = "DELETE from clientes where id = ?";


    public String salvar(Cliente cliente) throws SQLException {


        String salvo = "falha";


        try {
            con.setAutoCommit(false);
            stmt = (PreparedStatement) con.prepareStatement(sqlSalvar);
            
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
            stmt.setInt(13,  cliente.getDddtel1());
            stmt.setString(14, cliente.getTelefone1());
            stmt.setInt(15,  cliente.getDddtel2());
            stmt.setString(16,  cliente.getTelefone2());
            stmt.setInt(17,  cliente.getDddtel3());
            stmt.setString(18, cliente.getTelefone3());
            stmt.setString(19, cliente.getEmail1());
            stmt.setString(20, cliente.getEmail2());
            stmt.setDate(21, Date.valueOf(cliente.getDt_cadastro()));              
            stmt.executeUpdate();

            //Grava as informações se caso de problema os dados não são gravados
            con.commit();
            salvo = "salvo";

        } catch (SQLException e) {
            if (con != null) {
                try {
                    System.err.print("Rollback efetuado na transação");
                    con.rollback();
                } catch (SQLException e2) {
                    System.err.print("Erro na transação!" + e2);
                    salvo = "\"Erro na transação!\"+e2";
                }
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            con.setAutoCommit(true);
        }

        return salvo;
    }

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

   
    public String editar(Cliente cliente) throws SQLException {
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
    
    public List<Cliente> listarClientes() {
        List<Cliente> list = new ArrayList<Cliente>();
        ResultSet res = null;

        try {
            stm = con.createStatement();
        	res = stm.executeQuery("SELECT * FROM clientes");

            while (res.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(res.getInt("id"));
                
                String cpf_cnpj = res.getString("cpf_cpnj");
                if (cpf_cnpj!=null){
                	if (cpf_cnpj.length()==14) {
                	cliente.setCpf_cpnj((imprimeCNPJ(cpf_cnpj)));
                	}
                	if (cpf_cnpj.length()==11) {
                		cliente.setCpf_cpnj(imprimeCPF(cpf_cnpj));
                	}
                }
                
                cliente.setRazao_social(res.getString("razao_social"));
                cliente.setNome_fantasia(res.getString("nome_fantasia"));
                cliente.setInsc_estadual(res.getString("i_estadual"));
                cliente.setInsc_municipal(res.getString("i_municipal"));
                cliente.setEndereco(res.getString("endereco"));
                cliente.setNumero(res.getInt("numero"));
                cliente.setComplemento(res.getString("complemento"));
                cliente.setBairro(res.getString("bairro"));
                cliente.setCidade(res.getString("cidade"));
                cliente.setUf(res.getString("uf"));
                cliente.setCep(res.getString("cep"));
                cliente.setDddtel1(res.getInt("ddd1"));
                cliente.setTelefone1(res.getString("telefone1"));
                cliente.setDddtel2(res.getInt("ddd2"));
                cliente.setTelefone2(res.getString("telefone2"));
                cliente.setDddtel3(res.getInt("ddd3"));
                cliente.setTelefone3(res.getString("telefone3"));
                cliente.setEmail1(res.getString("email1"));
                cliente.setEmail2(res.getString("email2"));
                Date dt_cadastro = res.getDate("dt_cadastro");
                cliente.setDt_cadastro(dt_cadastro.toLocalDate());
                
                
                
                
                list.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta1:" + e.getMessage());
        }
        return list;
    }
    
    public static String imprimeCNPJ(String CNPJ) {
		// máscara do CNPJ: 99.999.999/9999-99
		    return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
		      CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-" +
		      CNPJ.substring(12, 14));
		  }
    public static String imprimeCPF(String CPF) {
		// máscara do CPF: 999.999.9999-99
		    return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
		    		CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
		  }
}

