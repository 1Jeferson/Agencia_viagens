package com.agencia.model;

public class Destinos {

	private int idDestino;
	private String nomeDestino;
	private String localizacaoDestino;
	private String descricaoDestino;
	private double precoDestino;
	
	
	public Destinos() {
		
	}
	
	public Destinos(String nomeDestino, String localizacaoDestino, String descricaoDestino, double precoDestino) {
		super();
		this.nomeDestino = nomeDestino;
		this.localizacaoDestino = localizacaoDestino;
		this.descricaoDestino = descricaoDestino;
		this.precoDestino = precoDestino;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getLocalizacaoDestino() {
		return localizacaoDestino;
	}

	public void setLocalizacaoDestino(String localizacaoDestino) {
		this.localizacaoDestino = localizacaoDestino;
	}

	public String getDescricaoDestino() {
		return descricaoDestino;
	}

	public void setDescricaoDestino(String descricaoDestino) {
		this.descricaoDestino = descricaoDestino;
	}

	public double getPrecoDestino() {
		return precoDestino;
	}

	public void setPrecoDestino(double precoDestino) {
		this.precoDestino = precoDestino;
	}

	@Override
	public String toString() {
		return "Destinos [idDestino=" + idDestino + ", nomeDestino=" + nomeDestino + ", localizacaoDestino="
				+ localizacaoDestino + ", descricaoDestino=" + descricaoDestino + ", precoDestino=" + precoDestino
				+ "]";
	}
	
	
	
	
}
