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
			
			
			Iterator<Cliente> it = listaClientes.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			 
		}
		public void crearCliente(String run, String nombre, String apellido, String anio) {
			Cliente modeloclientes = new Cliente(run, nombre, apellido, anio, CategoriaEnum.ACTIVO);
			listaClientes.add(modeloclientes);
			
			//System.out.println(cliente);
			
			//listaClientes.add(cliente);
			//System.out.println(listaClientes);
		} 
}
