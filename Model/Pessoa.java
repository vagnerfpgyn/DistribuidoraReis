package Model;

import java.time.LocalDate;

public abstract class Pessoa {
	
	private int id;
	private String cpf_cpnj;
	private String razao_social;
	private String nome_fantasia;
	private String insc_estadual;
	private String insc_municipal;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private int dddtel1;
	private String telefone1;
	private int dddtel2;
	private String telefone2;
	private int dddtel3;	
	private String telefone3;
	private String email1;
	private String email2;
	private LocalDate dt_cadastro;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf_cpnj() {
		return cpf_cpnj;
	}
	public void setCpf_cpnj(String cpf_cpnj) {
		this.cpf_cpnj = cpf_cpnj;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getInsc_estadual() {
		return insc_estadual;
	}
	public void setInsc_estadual(String insc_estadual) {
		this.insc_estadual = insc_estadual;
	}
	public String getInsc_municipal() {
		return insc_municipal;
	}
	public void setInsc_municipal(String insc_municipal) {
		this.insc_municipal = insc_municipal;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getTelefone3() {
		return telefone3;
	}
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public LocalDate getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(LocalDate dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public int getDddtel1() {
		return dddtel1;
	}
	public void setDddtel1(int dddtel1) {
		this.dddtel1 = dddtel1;
	}
	public int getDddtel2() {
		return dddtel2;
	}
	public void setDddtel2(int dddtel2) {
		this.dddtel2 = dddtel2;
	}
	public int getDddtel3() {
		return dddtel3;
	}
	public void setDddtel3(int dddtel3) {
		this.dddtel3 = dddtel3;
	}
	
	
	
		

}
