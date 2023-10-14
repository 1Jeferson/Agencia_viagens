package com.agencia.model;

import java.time.LocalDateTime;

public class Passagem {

	private int idPassagem;
	private LocalDateTime dataViagem;
	private double precoPassagem;
	private Cliente cliente;
	private Destinos destinos;
	
	
	public int getIdPassagem() {
		return idPassagem;
	}
	
	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}
	
	public LocalDateTime getDataViagem() {
		return dataViagem;
	}
	
	public void setDataViagem(LocalDateTime dataViagem) {
		this.dataViagem = dataViagem;
	}

	public double getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(double precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	@Override
	public String toString() {
		return "Passagem [idPassagem=" + idPassagem + ", dataViagem=" + dataViagem + ", precoPassagem=" + precoPassagem
				+ ", cliente=" + cliente + ", destinos=" + destinos + "]";
	}
	
	
}
