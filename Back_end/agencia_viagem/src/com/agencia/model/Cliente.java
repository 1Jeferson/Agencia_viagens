package com.agencia.model;

public class Cliente {

	private int idCliente;
	private String nomeCliente;
	private String enderecoCliente;
	private String telefoneCliente;
	private String cpfCliente;
	private String emailCliente;

	public Cliente() {

	}

	public Cliente(String nomeCliente, String enderecoCliente, String telefoneCliente, String cpfCliente,
			String emailCliente) {
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente= " + nomeCliente + ", enderecoCliente="
				+ enderecoCliente + ", telefoneCliente=" + telefoneCliente + ", cpfCliente=" + cpfCliente
				+ ", emailCliente=" + emailCliente + "]";
	}

}
