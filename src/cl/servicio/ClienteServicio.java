package cl.servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
				System.out.println("PRODUCTO");
				System.out.println("Run del Cliente: "+ cliente.getRunCliente());
				System.out.println("Precio: "+ cliente.getNombreCliente());
				System.out.println("Descripcion: "+ cliente.getApellidoCliente());
				System.out.println("Codigo: "+ cliente.getAniosCliente());
				System.out.println("Talla: "+ cliente.getNombreCategoria());

			}
			
			/*
			 * for(Cliente cliente: clientes) { System.out.println("Nombre: "+
			 * cliente.getNombreCliente()+" Apellido: "+
			 * cliente.getApellidoCliente()+" Rut: "+ cliente.getRunCliente()+" Edad: "+
			 * cliente.getAniosCliente()+ " Estado: "+cliente.getNombreCategoria());
			 * System.out.println(); }
			 */
			 
		}
		public void crearCliente(Cliente cliente) {
			listaClientes.add(cliente);
		} 
}
