/**
 * 
 */
package br.edu.uniopet.tds172a.heraldoisrael.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author israel
 *
 */
@Entity
@Table(name="TIPO_USUARIO")
public class TipoUsuario {
	
	@Id
	//@Column(name="IDTIPO_USUARIO", length = 10, nullable = false)
	private Integer IDTIPO_USUARIO;
	
	@Column(name="NM_TIPO_USU", length = 20, nullable = false)
	private String NM_TIPO_USU;
	
	public TipoUsuario() {
		super();
		setIDTIPO_USUARIO(2);
		setNM_TIPO_USU("Cliente");
	}

	public Integer getIDTIPO_USUARIO() {
		return IDTIPO_USUARIO;
	}

	public void setIDTIPO_USUARIO(Integer iDTIPO_USUARIO) {
		IDTIPO_USUARIO = iDTIPO_USUARIO;
	}

	public String getNM_TIPO_USU() {
		return NM_TIPO_USU;
	}

	public void setNM_TIPO_USU(String nM_TIPO_USU) {
		NM_TIPO_USU = nM_TIPO_USU;
	}
	
}
