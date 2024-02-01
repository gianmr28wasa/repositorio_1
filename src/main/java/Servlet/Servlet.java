package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuarioService;
import service.UsuarioServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import entity.Request;
import entity.Response;

/**
 * Servlet implementation class Servlet
 */

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService service = new UsuarioServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int prueba = 0;
		
		PrintWriter out = response.getWriter();
		Response responseApi = new Response();
		
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		Request parametros = gson.fromJson(reader, Request.class);
		
		System.out.println("Nombre : " + parametros.getNombre());
		System.out.println("Apellido : " + parametros.getApellido());
		System.out.println("Edad : " + parametros.getEdad());
		System.out.println("Oficio : " + parametros.getOficio());
		
		try {
			Object[] values = new Object[4];
			values[0] = parametros.getNombre();
			values[1] = parametros.getApellido();
			values[2] = parametros.getEdad();
			values[3] = parametros.getOficio();
			int result = service.registrarUsuario(values);
			if(result > 0) {
				responseApi.setEstado("OK");
				responseApi.setMensaje("Se registro correctamente");
			}else {
				responseApi.setEstado("ERROR");
				responseApi.setMensaje("No se pudo registrar");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String resultFront = gson.toJson(responseApi);
		out.print(resultFront);
		
		
		
//		System.out.println(reader);
//		
//		String line;
//        while((line = reader.readLine()) != null){
//           	System.out.println(line);
//        }
		
	}

}
