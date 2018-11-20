/**
 * 
 */
package br.edu.uniopet.tds172a.heraldoisrael.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.uniopet.tds172a.heraldoisrael.controller.ClienteController;
import br.edu.uniopet.tds172a.heraldoisrael.vo.Cliente;
import br.edu.uniopet.tds172a.heraldoisrael.bean.LoginBean;


@ManagedBean(name = "resumoBean")
@SessionScoped
public class ResumoBean implements Serializable {

	private ClienteController clienteController;
	private Cliente cliente;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2975115685667011660L;

	/**
	 * contrutor vazio do resumo bean
	 */
	public ResumoBean(){
		
	}
	
	/**
	 * constructor inicializando cliente e controler
	 * @param cliente
	 */
	public ResumoBean(Cliente cliente) {
		System.out.println("Entrou em resumo bean pelo construtor com parâmetros");
		System.out.println("Cliente: "+cliente.getNomeCliente());
		this.cliente = cliente;
		this.setClienteController(new ClienteController());
	}
	
	@PostConstruct
	public void iniciaResumo() {
		System.out.println("Passou pelo POSTCONSTRUCT");
		
		System.out.println("Cliente retornado do loginBean: "+this.getLoginBean().getCliente().getNomeCliente());
		this.cliente = this.getLoginBean().getCliente();
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
	/**
	 * fun��o de retorno para ir para a parte de altera��o de cadastro
	 * @return
	 */
	public String alteraCadastro() {
		System.out.println("Clicou na função de alterar cadastro.");
		System.out.println("Cliente no momento do clique: "+cliente.getNomeCliente());
		//cliente = loginBean.getCliente();
		System.out.println("Cliente após receber loginBean.getCliente: "+cliente.getNomeCliente());
		return "/pages/alteracadastro";
	}

	/**
	 * fun��o de retorno da pagina de produtos
	 * @return
	 */
	public String catalogoProdutos() {
		
		return "/pages/produtos";
	}

	/** metodo que retorna  pagina do login para o cliente
	 * 
	 * @return
	 */
	public String efetuarLogout() {

		FacesContext fc = FacesContext.getCurrentInstance();   
		HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);   
		session.invalidate();
		return "/pages/login";

	}

	/**
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

}