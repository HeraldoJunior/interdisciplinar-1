package br.edu.uniopet.tds172a.heraldoisrael.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="TB_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator_sequence")
	@SequenceGenerator(name = "generator_sequence", sequenceName="TB_CLIENTE_AUTO_INCR")
	@Column(name="IDTB_CLI", length = 38, nullable = false)
	private int idCliente;
	
	@Column(name="NM_CLI", length = 50, nullable = false)
	private String nomeCliente;

	@Column(name="CPF_CLI", length = 15, nullable = false)
	private String cpfCliente;
	
	@Column(name="END_CLI", length = 80, nullable = false)
	private String enderecoCliente;
		
	@Column(name="DATA_NASC_CLI", nullable = false)
	@Temporal(TemporalType.DATE) 
	private Date dataNascCliente;
	
	@Column(name="DDD_TELCEL", length = 3, nullable = false)
	private String dddCelCliente;
	
	@Column(name="DDD_TELFIXO", length = 3, nullable = false)
	private String dddFixoCliente;
	
	@Column(name="TELCEL_CLI", length = 15, nullable = false)
	private String telCelCliente;
	
	@Column(name="TELFIXO_CLI", length = 15, nullable = false)
	private String telFixoCliente;
	
	@Column(name="NM_USUARIO", length = 15, nullable = false)
	private String nomeUsuario;
	
	@Column(name="SENHA_USUARIO", length = 20, nullable = false)
	private String senhaUsuario;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IDTIPO_USUARIO")
	private TipoUsuario tipoUsuario;
	
	@Transient
	private String confereCPF;
	@Transient
	private String confereSenha;

	/**
	 * 
	 */
	public Cliente() {
		System.out.println("ENTROU PELO CONSTRUTOR SEM PARAMETROS");
	}

	/**
	 * @param nomeCliente
	 * @param cpfCliente
	 * @param enderecoCliente
	 * @param dataNascCliente
	 * @param dddCelCliente
	 * @param dddFixoCliente
	 * @param telCelCliente
	 * @param telFixoCliente
	 * @param nomeUsuario
	 * @param senhaUsuario
	 */
	public Cliente(int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, Date dataNascCliente, String dddCelCliente,
			String dddFixoCliente, String telCelCliente, String telFixoCliente, String nomeUsuario, String senhaUsuario,
			TipoUsuario tipoUsuario) {
		super();
		setIdCliente(idCliente);
		setNomeCliente(nomeCliente);
		setCpfCliente(cpfCliente);
		setEnderecoCliente(enderecoCliente);
		setDataNascCliente(dataNascCliente);
		setDddCelCliente(dddCelCliente);
		setDddFixoCliente(dddFixoCliente);
		setTelCelCliente(telCelCliente);
		setTelFixoCliente(telFixoCliente);
		setNomeUsuario(nomeUsuario);
		setSenhaUsuario(senhaUsuario);
		setTipoUsuario(tipoUsuario);
		
		System.out.println("ENTROU PELO CONSTRUTOR COM PARAMETROS");
	}

	/**
	 * 
	 * @param cliente
	 */
	public Cliente(Cliente cliente) {
		System.out.println("ENTROU PELO CONSTRUTOR COM CLIENTE COMO PARAMETROS");
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente
	 *            the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the cpfCliente
	 */
	public String getCpfCliente() {
		return cpfCliente;
	}

	/**
	 * @param cpfCliente
	 *            the cpfCliente to set
	 */
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	/**
	 * @return the enderecoCliente
	 */
	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	/**
	 * @param enderecoCliente
	 *            the enderecoCliente to set
	 */
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	/**
	 * @return the dataNascCliente
	 */
	public Date getDataNascCliente() {
		return dataNascCliente;
	}

	/**
	 * @param dataNascCliente
	 *            the dataNascCliente to set
	 */
	public void setDataNascCliente(Date dataNascCliente) {
		this.dataNascCliente = dataNascCliente;
	}

	/**
	 * @return the dddCelCliente
	 */
	public String getDddCelCliente() {
		return dddCelCliente;
	}

	/**
	 * @param dddCelCliente
	 *            the dddCelCliente to set
	 */
	public void setDddCelCliente(String dddCelCliente) {
		this.dddCelCliente = dddCelCliente;
	}

	/**
	 * @return the dddFixoCliente
	 */
	public String getDddFixoCliente() {
		return dddFixoCliente;
	}

	/**
	 * @param dddFixoCliente
	 *            the dddFixoCliente to set
	 */
	public void setDddFixoCliente(String dddFixoCliente) {
		this.dddFixoCliente = dddFixoCliente;
	}

	/**
	 * @return the telCelCliente
	 */
	public String getTelCelCliente() {
		return telCelCliente;
	}

	/**
	 * @param telCelCliente
	 *            the telCelCliente to set
	 */
	public void setTelCelCliente(String telCelCliente) {
		this.telCelCliente = telCelCliente;
	}

	/**
	 * @return the telFixoCliente
	 */
	public String getTelFixoCliente() {
		return telFixoCliente;
	}

	/**
	 * @param telFixoCliente
	 *            the telFixoCliente to set
	 */
	public void setTelFixoCliente(String telFixoCliente) {
		this.telFixoCliente = telFixoCliente;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario
	 *            the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @return the senhaUsuario
	 */
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	/**
	 * @param senhaUsuario
	 *            the senhaUsuario to set
	 */
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
