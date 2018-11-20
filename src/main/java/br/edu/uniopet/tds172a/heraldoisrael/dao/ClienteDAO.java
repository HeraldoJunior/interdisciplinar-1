package br.edu.uniopet.tds172a.heraldoisrael.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.uniopet.tds172a.heraldoisrael.model.ICliente;
import br.edu.uniopet.tds172a.heraldoisrael.util.HibernateUtil;
import br.edu.uniopet.tds172a.heraldoisrael.vo.Cliente;
import br.edu.uniopet.tds172a.heraldoisrael.vo.Produto;
import br.edu.uniopet.tds172a.heraldoisrael.vo.TipoUsuario;

/**
 * classe DAO que implementa a interface ICliente, efetua as devidas conex�es
 * com o banco de dados e efetua as a��es necessarias
 * 
 * @author heraldo
 *
 */
public class ClienteDAO implements ICliente {

	/**
	 * 
	 */
	public ClienteDAO() {}

	/**
	 * metodo de inser��o do cliente no banco de dados
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean inserirCliente(Cliente cliente) {
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIDTIPO_USUARIO(2);
		cliente.setTipoUsuario(tipoUsuario);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			if(cliente.getNomeCliente() != null && cliente.getNomeCliente().length() > 2){
				if((cliente.getSenhaUsuario() != null && cliente.getSenhaUsuario().length() > 3) && (cliente.getNomeUsuario() != null && cliente.getNomeUsuario().length() > 3) ) {
					session.save(cliente);
					return true;
				}else {
					return false;
				}
			}else {
				//System.out.println("TA TUDO ERRADO");
				return false;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * * metodo de recupera dos clientes no banco de dados
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createQuery("FROM Produto").list();
	}

	/**
	 * metodo de exclus�o do cliente no banco de dados pelo CPF
	 */
	public boolean excluirCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Query query = session.createQuery("from Cliente where IDTB_CLI = :id");
			query.setParameter("id", cliente.getIdCliente());
			Cliente nCliente = (Cliente) query.uniqueResult();
			
			if(cliente.getConfereCPF().equals(nCliente.getCpfCliente())) {
				session.clear();
				session.delete(cliente);
				return true;
			}else {
				System.out.println("O CPF não confere. Não pode deletar");
				return false;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	public boolean alterarCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Query query = session.createQuery("from Cliente where IDTB_CLI = :id ");
			query.setParameter("id", cliente.getIdCliente());
			Cliente nCliente = (Cliente) query.uniqueResult();
			
			System.out.println("nCliente: "+nCliente.getNomeCliente());
			
			if(nCliente.getSenhaUsuario().equals(cliente.getConfereSenha())) {
				System.out.println("Fará o update");
				session.clear();
				session.update(cliente);
				
				return true;
			}else {
				System.out.println("Não fará o update");
				System.out.println("Senha informada no cliente recebido: "+cliente.getSenhaUsuario());
				System.out.println("Senha retornada do banco de dados: "+nCliente.getSenhaUsuario());
				return false;
			}
		}catch(Exception e1) {
			System.out.println("Gerou exception: "+e1.getMessage());
			return false;
		}
		
	}

	/**
	 * m�todo para confirmar se o cliente existe, e efetuar o login do mesmo.
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente efetuarLogin(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			String nome = cliente.getNomeUsuario();
			String senha = cliente.getSenhaUsuario();
			
			String hql = "from Cliente where NM_USUARIO = '"+nome+"' and SENHA_USUARIO = '"+senha+"'";
			
			Query q = session.createQuery(hql);
			
			Cliente nCliente = (Cliente) q.uniqueResult();
			
			return nCliente;
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public Cliente buscaCliente(Cliente cliente) {
		return new Cliente();
	}
	
	

}
