package service;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioDAO dao = new UsuarioDAOImpl();
	
	@Override
	public int registrarUsuario(Object[] values) throws Exception {
		return dao.registrarUsuario(values);
	}

}
