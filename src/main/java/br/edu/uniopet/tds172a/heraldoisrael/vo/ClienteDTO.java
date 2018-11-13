package br.edu.uniopet.tds172a.heraldoisrael.vo;

public class ClienteDTO {
	private Cliente cliente;
	private String confereCPF;
	private String confereSenha;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getConfereCPF() {
		return confereCPF;
	}
	public void setConfereCPF(String confereCPF) {
		this.confereCPF = confereCPF;
	}
	public String getConfereSenha() {
		return confereSenha;
	}
	public void setConfereSenha(String confereSenha) {
		this.confereSenha = confereSenha;
	}
	
	
}
