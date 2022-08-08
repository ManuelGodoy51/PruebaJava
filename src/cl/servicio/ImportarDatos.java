package cl.servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
					  String rut = lista[0];
					  String nombre = lista[1];
					  String apellido = lista[2];
					  String anios = lista[3];
					  CategoriaEnum categoria = CategoriaEnum.parse(lista[4].trim());
					  contenidoArchivo = memoriaLectura.readLine();
					  //clienteServicio.crearCliente(lista[0].trim(), lista[1].trim(), lista[2].trim(), lista[3].trim(), CategoriaEnum.parse(lista[4].trim()));
					  Cliente clientes = new Cliente(rut, nombre, apellido, anios, categoria);
					  List<Cliente> lista2 = new ArrayList<>();
					  lista2.add(clientes);
					 // System.out.println(lista2);
					  for (Iterator<Cliente> iterador = lista2.iterator(); iterador.hasNext();) {
							Cliente cliente = (Cliente) iterador.next();
							String run= cliente.getRunCliente();
							String nombreC = cliente.getNombreCliente();
							String apellidoC = cliente.getApellidoCliente();
							String aniosC = cliente.getAniosCliente();
							CategoriaEnum categoriaC = cliente.getNombreCategoria();
							System.out.println("--------------------------------------------------------------");
							
							clienteServicio.crearCliente(run, nombreC, apellidoC, aniosC, categoriaC);
						}
				}
				memoriaLectura.close();
	}

	
}

