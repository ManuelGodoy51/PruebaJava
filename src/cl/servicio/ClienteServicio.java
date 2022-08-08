package cl.servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cl.modelo.CategoriaEnum;
import cl.modelo.Cliente;


public class ClienteServicio {
	//creacion de lista
		
		List<Cliente> listaClientes = new ArrayList<>();
	//constructor 
		public ClienteServicio(List<Cliente> listaClientes) {
			super();
			this.listaClientes = listaClientes;
		}
		public ClienteServicio() {
			
		}

	//getter de listaClientes	
		public List<Cliente> getListaClientes() {
			return listaClientes;
		}
		
		
	public void setListaClientes(List<Cliente> listaClientes) {
			this.listaClientes = listaClientes;
		}


		//metodo recorre listaclientes y muestra
		public void retornoListarClientes() {
			for(Iterator<Cliente> iterador = getListaClientes().iterator(); iterador.hasNext();) {
				Cliente cliente = (Cliente)iterador.next();
				System.out.println("Rut del Cliente: "+ cliente.getRunCliente());
				System.out.println("Nombre del cliente: "+ cliente.getNombreCliente());
				System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
				System.out.println("Años como cliente: "+ cliente.getAniosCliente());
				System.out.println("Estado del cliente: "+ cliente.getNombreCategoria());
				System.out.println("--------------------------------------------------------------");
			}
			
			
			 
		}
		public void crearCliente(String run, String nombre, String apellido, String anio) {
			Cliente modeloclientes = new Cliente(run, nombre, apellido, anio, CategoriaEnum.ACTIVO);
			Cliente modeloClienteNull = new Cliente(null, null, null, null,null);
			listaClientes.add(modeloclientes);
			listaClientes.add(modeloClienteNull);
		} 
}
