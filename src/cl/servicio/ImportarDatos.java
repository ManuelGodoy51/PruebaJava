package cl.servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.modelo.CategoriaEnum;
import cl.modelo.Cliente;
import cl.servicio.ArchivoServicio;
import cl.servicio.ClienteServicio;

public class ImportarDatos extends ArchivoServicio{

	public ImportarDatos(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	public ImportarDatos() {}
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearCarpeta(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		
	}
//////////////solo se trabaja el metodo cargar datos///////////////////7
	@Override
	public void cargarDatos(String fileName) throws IOException {
		// TODO Auto-generated method stub
		//leer el archivo
				FileReader leerArchivo = new FileReader(fileName);
				BufferedReader memoriaLectura = new BufferedReader(leerArchivo);
				/*
				 * System.out.println("El contenido del archivo es: ");
				 * System.out.println(memoriaLectura.readLine());
				 */
				String contenidoArchivo = memoriaLectura.readLine();
				while(contenidoArchivo !=null) {

					  String[] lista = contenidoArchivo.split(",");

					  Cliente cl = new Cliente();
					  
					  String r = lista[0];
					  String n = lista[1];
					  String a = lista[2];
					  String anio = lista[3];
					  String NombreCategoria = lista[4].trim();
					  
					  System.out.println(NombreCategoria);
					  
					  if(NombreCategoria.equalsIgnoreCase("Activo")) {
						  Cliente clientes = new Cliente(r, n, a, anio, CategoriaEnum.ACTIVO);
						  List<Cliente> listaClientes = new ArrayList<>();
						  listaClientes.add(clientes);
						  System.out.println(listaClientes);
						  ClienteServicio cS = new ClienteServicio();
						  cS.setListaClientes(listaClientes);
						  
						  
					  }else{
						  Cliente clientes = new Cliente(r, n, a, anio, CategoriaEnum.INACTIVO);
						  List<Cliente> listaClientes = new ArrayList<>();
						  listaClientes.add(clientes);
						  
						  ClienteServicio cS = new ClienteServicio();
						  cS.setListaClientes(listaClientes);
					  }

					  contenidoArchivo = memoriaLectura.readLine();
				}
				memoriaLectura.close();
	}

	
}

