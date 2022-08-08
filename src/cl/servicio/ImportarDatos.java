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

import cl.servicio.ClienteServicio;

public class ImportarDatos extends ArchivoServicio{
	ClienteServicio clienteServicio = new ClienteServicio();
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

					  contenidoArchivo = memoriaLectura.readLine();
					  clienteServicio.crearCliente(lista[0].trim(), lista[1].trim(), lista[2].trim(), lista[3].trim(), CategoriaEnum.parse(lista[4].trim()));
				}
				memoriaLectura.close();
	}

	
}

