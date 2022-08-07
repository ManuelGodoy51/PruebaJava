package cl.servicio;

import java.util.ArrayList;
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
		public void retornoListarClientes(ArrayList<Cliente> clientes) {
			
			for(Cliente cliente: clientes) {
				
				
				System.out.println("Nombre: "+ cliente.getNombreCliente()+" Apellido: "+ cliente.getApellidoCliente()+" Rut: "+ cliente.getRunCliente()+" Edad: "+ cliente.getAniosCliente()+ " Estado: "+cliente.getNombreCategoria());
				System.out.println();
				
				
			}
			 
		}

}
