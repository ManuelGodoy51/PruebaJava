package cl.servicio;

import java.io.IOException;
import java.util.List;
import cl.modelo.Cliente;
import cl.servicio.ClienteServicio;

public abstract class Exportador extends ClienteServicio{

	public Exportador(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	public Exportador() {}
	
	public abstract void exportar(String fileName, List<Cliente> listaClientes) throws IOException;
	
	public abstract void crearCarpeta(String fileName);
	
	public abstract void crearArchivo(String nombreArchivo);
}