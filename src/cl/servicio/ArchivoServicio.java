package cl.servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import cl.modelo.Cliente;
import cl.servicio.Exportador;

public abstract class ArchivoServicio extends Exportador{

	public ArchivoServicio(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	
	public ArchivoServicio() {}
	
	public abstract void cargarDatos(String fileName) throws FileNotFoundException, IOException;
	
	
}
