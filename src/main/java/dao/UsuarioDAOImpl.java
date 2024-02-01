package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.Constantes;
import Util.MYSQLConnection;


public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public int registrarUsuario(Object[] values) throws Exception {
		System.out.println("registrarUsuario");
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		int resultado = 0;
		try {
			miConexion=MYSQLConnection.getConexion();
			String SQL="INSERT INTO "+Constantes.TBL_USUARIO+" (nombre,apellido,edad,oficio) VALUES (?,?,?,?)";
			miStatement=miConexion.prepareStatement(SQL);
			miStatement.setString(1, values[0].toString());
			miStatement.setString(2, values[1].toString());
			miStatement.setString(3, values[2].toString());
			miStatement.setString(4, values[3].toString());
			resultado = miStatement.executeUpdate();
//			miStatement.execute();
//			miStatement.executeQuery();
		}catch(Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		finally {
			miStatement.close();
			miConexion.close();
			}
		return resultado;
	}

}
