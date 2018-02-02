package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.CadastroClienteDao;
import Model.Cliente;

public class CadastroClienteNegocio {

	
	    CadastroClienteDao cadastroclienteDao = new CadastroClienteDao();
	    
	    public String salvar(Cliente cliente) throws SQLException {

	        boolean cpf_cpnjValido = false;
	        boolean email1Valido = false;
	        boolean email2Valido = false;

	        String salvo = "falha";
	        StringBuilder sb = new StringBuilder();
	        String cpf_cnpj = cliente.getCpf_cpnj();
	        int tam = cpf_cnpj.length();
	        if ((tam == 11)||(tam ==14)) {
	        	if (tam ==11) {
	        		cpf_cpnjValido = validaCPF(cliente.getCpf_cpnj());
	        			if (!cpf_cpnjValido) {
	        				sb.append("cpf inválido. \n");
	        			}
	        	}
	        	if (tam ==14) {
	    	       cpf_cpnjValido = validaCNPJ(cliente.getCpf_cpnj());
	    	        	if (!cpf_cpnjValido) {
	    	        		sb.append("cpf inválido. \n");
	    	        		}
	        	}
	        }else {
	        	
        			sb.append("CPF ou CNPJ inválido. \n");
		        
	        	
	        }
	        
	        email1Valido = isEmailValid(cliente.getEmail1());
	        if (!email1Valido) {
	            sb.append("E-mail 1 inválido. \n");
	        }
	        String email2 = cliente.getEmail2();
	        if (!(email2.isEmpty())){
	        email2Valido = isEmailValid(cliente.getEmail2());
	        if (!email2Valido) {
	            sb.append("E-mail 2 inválido. \n");
	        }
	       }
	        if (sb.toString().isEmpty()) {
	          salvo = cadastroclienteDao.salvar(cliente);
	        } else {
	            sb.append(salvo);
	            return sb.toString();
	        }
	        sb.append(salvo);
	        return sb.toString();
	    }

	    

	    
	    public List<Cliente> listarClientes(){
	        List<Cliente> clientes = new ArrayList<Cliente>();
	        clientes = cadastroclienteDao.listarClientes();
	        return clientes;
	    }
	   
	        public boolean validaCPF(String CPF){

	// considera-se erro CPF's formados por uma sequencia de numeros iguais
	            if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	                    CPF.equals("22222222222") || CPF.equals("33333333333") ||
	                    CPF.equals("44444444444") || CPF.equals("55555555555") ||
	                    CPF.equals("66666666666") || CPF.equals("77777777777") ||
	                    CPF.equals("88888888888") || CPF.equals("99999999999") ||
	                    (CPF.length() != 11))
	                return(false);

	            char dig10, dig11;
	            int sm, i, r, num, peso;

	// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	            try {
	// Calculo do 1o. Digito Verificador
	                sm = 0;
	                peso = 10;
	                for (i=0; i<9; i++) {
	// converte o i-esimo caractere do CPF em um numero:
	// por exemplo, transforma o caractere '0' no inteiro 0
	// (48 eh a posicao de '0' na tabela ASCII)
	                    num = (int)(CPF.charAt(i) - 48);
	                    sm = sm + (num * peso);
	                    peso = peso - 1;
	                }

	                r = 11 - (sm % 11);
	                if ((r == 10) || (r == 11))
	                    dig10 = '0';
	                else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	// Calculo do 2o. Digito Verificador
	                sm = 0;
	                peso = 11;
	                for(i=0; i<10; i++) {
	                    num = (int)(CPF.charAt(i) - 48);
	                    sm = sm + (num * peso);
	                    peso = peso - 1;
	                }

	                r = 11 - (sm % 11);
	                if ((r == 10) || (r == 11))
	                    dig11 = '0';
	                else dig11 = (char)(r + 48);

	// Verifica se os digitos calculados conferem com os digitos informados.
	                if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                    return(true);
	                else return(false);
	            } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }

	        public boolean validaCNPJ(String CNPJ) {
	        	// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
	        	    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
	        	        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
	        	        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
	        	        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
	        	        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
	        	       (CNPJ.length() != 14))
	        	       return(false);

	        	    char dig13, dig14;
	        	    int sm, i, r, num, peso;

	        	// "try" - protege o código para eventuais erros de conversao de tipo (int)
	        	    try {
	        	// Calculo do 1o. Digito Verificador
	        	      sm = 0;
	        	      peso = 2;
	        	      for (i=11; i>=0; i--) {
	        	// converte o i-ésimo caractere do CNPJ em um número:
	        	// por exemplo, transforma o caractere '0' no inteiro 0
	        	// (48 eh a posição de '0' na tabela ASCII)
	        	        num = (int)(CNPJ.charAt(i) - 48);
	        	        sm = sm + (num * peso);
	        	        peso = peso + 1;
	        	        if (peso == 10)
	        	           peso = 2;
	        	      }

	        	      r = sm % 11;
	        	      if ((r == 0) || (r == 1))
	        	         dig13 = '0';
	        	      else dig13 = (char)((11-r) + 48);

	        	// Calculo do 2o. Digito Verificador
	        	      sm = 0;
	        	      peso = 2;
	        	      for (i=12; i>=0; i--) {
	        	        num = (int)(CNPJ.charAt(i)- 48);
	        	        sm = sm + (num * peso);
	        	        peso = peso + 1;
	        	        if (peso == 10)
	        	           peso = 2;
	        	      }

	        	      r = sm % 11;
	        	      if ((r == 0) || (r == 1))
	        	         dig14 = '0';
	        	      else dig14 = (char)((11-r) + 48);

	        	// Verifica se os dígitos calculados conferem com os dígitos informados.
	        	      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
	        	         return(true);
	        	      else return(false);
	        	    } catch (InputMismatchException erro) {
	        	        return(false);
	        	    }
	        	  }

	        public  boolean isEmailValid(String email) {
	            if ((email == null) || (email.trim().length() == 0))
	                return false;

	            String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	            Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(email);
	            return matcher.matches();
	        }

	
}
