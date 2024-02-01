package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection {
	public static Connection getConexion() {
		Connection con=null;
		try { Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost/pruebas_2024?useTimezOne=true&serverTimezone=UTC";
		String usr="root";
		String psw="1234";
		con=DriverManager.getConnection(url,usr,psw);
		System.out.println("Conexion OK");
		}catch(ClassNotFoundException ex)
		{System.out.println("No hay drivers");}
		catch(SQLException ex) {System.out.println("Error con esta DB");}
		return con;
	}
	public static void closeConexion(Connection con) {
		try {
			con.close();
		}catch(SQLException e){
			System.out.println("Problemas al cerrar conexion");
		}
	}
}
