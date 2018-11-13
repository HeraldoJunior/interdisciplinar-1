
package br.edu.uniopet.tds172a.heraldoisrael.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.uniopet.tds172a.heraldoisrael.controller.ClienteController;
import br.edu.uniopet.tds172a.heraldoisrael.vo.Cliente;

@ManagedBean(name = "cadastroBean")
@SessionScoped
public class CadastroBean implements Serializable {

	private ClienteController clienteController;
	private Cliente cliente;
	
	@ManagedProperty(value="#{resumoBean}")
	private ResumoBean resumoBean;
	
	private static final long serialVersionUID = 2166274126620784954L;

	/**
	 * Inializa��o de cliente e clientecontroller
	 */
	public CadastroBean() {
		this.setCliente(new Cliente());
		this.setClienteController(new ClienteController());
		//this.setCliente(new Cliente());
	}
	
	@PostConstruct
	public void iniciaCadastro() {
		if(this.getResumoBean().getCliente()!=null) {
			System.out.println("Entrou no if do PostConstruct em CadastroBean");
			this.cliente = this.getResumoBean().getCliente();
		}else {
			System.out.println("Entrou no else do PostConstruct em CadastroBean");
			this.cliente = new Cliente();
		}
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo de inser��o de clientes e devidas mensagens de informa��o.
	 * 
	 * @return
	 */
	public String inserirCliente() {

		FacesContext contexto = FacesContext.getCurrentInstance();
		
		System.out.println("SERÁ QUE JÁ EXISTE UM CLIENTE AQUI?????");
		System.out.println(cliente.getNomeCliente());

		boolean deuCerto;
		deuCerto = this.clienteController.inserirCliente(cliente);

		if (deuCerto == false) {

			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cliente não cadastrado, verifique os dados e tente novamente!", null));

			return "/pages/cadastro";

		} else {

			contexto.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente cadastrado com sucesso! Faça o login", null));
			return "/pages/login";
		}

	}

	/**
	 * m�todo do bot�o voltar para retornar ao login.
	 * 
	 * @return
	 */
	public String voltarLogin() {
		this.cliente = new Cliente();

		return "/pages/login";

	}

	/*
	 * 
	 * metodo para encaminha para a area de exclusao do cliente
	 */
	public String excluirCadastroProprio() {
		return "/pages/exclusaocadastro";
	}

	/**
	 * construtor da controler para utiliza��o
	 * 
	 * @return the clienteController
	 */
	public ClienteController getClienteController() {
		return clienteController;
	}

	/**
	 * @param clienteController the clienteController to set
	 */
	public void setClienteController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}
	
	public ResumoBean getResumoBean() {
		return resumoBean;
	}

	public void setResumoBean(ResumoBean resumoBean) {
		this.resumoBean = resumoBean;
	}

	/**
	 * metodo para excluir o cliente.
	 * 
	 * @param cpfCliente
	 * @return
	 */
	public String excluirCliente() {
		cliente = this.getCliente();
		FacesContext contexto = FacesContext.getCurrentInstance();
		boolean deuCerto;
		deuCerto = this.clienteController.excluirCliente(cliente);
		if (deuCerto == false) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cliente não deletado, verifique e tente novamente!", null));
			return "/pages/resumo";
		} else {
			contexto.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente deletado com sucesso!", null));
			return "/pages/login";
		}

	}

	/**
	 * 
	 * Metodo de altera��o de cliente
	 * 
	 * @return
	 */
	public String alterarCliente() {
		System.out.println("nome: "+cliente.getNomeCliente());
		FacesContext contexto = FacesContext.getCurrentInstance();
		//this.cliente = this.clienteController.alterarCliente(cliente);
		boolean deuCerto = this.clienteController.alterarCliente(cliente);
		if (deuCerto == false) {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Cliente não Alterado, verifique e tente novamente!", null));
			return "/pages/resumo";
		} else {
			contexto.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente alterado com sucesso!", null));
			System.out.println("Cliente alterado com sucesso");
			System.out.println("Cliente: "+cliente.getNomeCliente());
			resumoBean.setCliente(cliente);
			return "/pages/resumo";
		}
	}
}