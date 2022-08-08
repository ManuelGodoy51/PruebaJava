package cl.servicio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import cl.modelo.CategoriaEnum;
import cl.modelo.Cliente;
import cl.utitlidades.Utilidad;

public class ClienteServicio {
	// creacion de lista
    boolean valid=true;
	String respuesta;
	int opcion = 0;
	int opcion2 = 0;
	Scanner leer = new Scanner(System.in);
	Cliente modeloclientes = new Cliente();
	Utilidad utilidad = new Utilidad();

	List<Cliente> listaClientes = new ArrayList<>();

	// constructor
	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public ClienteServicio() {

	}

	// getter de listaClientes
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	// metodo recorre listaclientes y muestra
	public void retornoListarClientes() {
		for (Iterator<Cliente> iterador = getListaClientes().iterator(); iterador.hasNext();) {
			Cliente cliente = (Cliente) iterador.next();
			System.out.println("Rut del Cliente: " + cliente.getRunCliente());
			System.out.println("Nombre del cliente: " + cliente.getNombreCliente());
			System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
			System.out.println("Años como cliente: " + cliente.getAniosCliente());
			System.out.println("Estado del cliente: " + cliente.getNombreCategoria());
			System.out.println("--------------------------------------------------------------");
		}

	}

public void crearCliente(String run, String nombre, String apellido, String anio, CategoriaEnum enum1) {
		
		
		if(run.equals(null) && nombre.equals(null) && apellido.equals(null) && anio.equals(null)) {
			System.out.println("entro aca");
			Cliente modeloClienteNulo = new Cliente(null,null,null,null,null);
			//System.out.println(modeloClienteNulo);
		}else {
			
			Cliente modeloclientes = new Cliente(run, nombre, apellido, anio, enum1);
			listaClientes.add(modeloclientes);
			//System.out.println(listaClientes);
			
		}
		
		
	} 


	public void retornoListaImportado(List<Cliente> lista2) {
		
		for (Iterator<Cliente> iterador =lista2.iterator(); iterador.hasNext();) {
			Cliente cliente2 = (Cliente) iterador.next();
			String rutImp = cliente2.getRunCliente();
			String nombreImp = cliente2.getNombreCliente();
			String apellidoImp = cliente2.getApellidoCliente();
			String aniosImp = cliente2.getAniosCliente();
			CategoriaEnum CategoriaImp = cliente2.getNombreCategoria();
			
			modeloclientes.setRunCliente(rutImp);
			modeloclientes.setNombreCliente(nombreImp);
			modeloclientes.setApellidoCliente(apellidoImp);
			modeloclientes.setAniosCliente(aniosImp);
			modeloclientes.setNombreCategoria(CategoriaImp);
			
		}
	
		String rut = modeloclientes.getRunCliente();
		String nombre = modeloclientes.getNombreCliente();
		String apellido = modeloclientes.getApellidoCliente();
		String aniosCliente = modeloclientes.getAniosCliente();
		CategoriaEnum categoriaImportada = modeloclientes.getNombreCategoria();
		
		Cliente modeloC = new Cliente(rut, nombre, apellido, aniosCliente, categoriaImportada);
		listaClientes.add(modeloC);
		
	}

	public void retornoEditarCliente() {

		System.out.println("Ingrese RUN del Cliente a editar:");
		
		
			respuesta = leer.next();
			

		Cliente cliente = buscarClientePorRun(respuesta);

		if (cliente == null) {

			System.out.println("Rut no existe");
		} else {
			

			do {
				System.out.println("Seleccione que desea hacer: ");
				System.out.println("1.-Cambiar el estado del Cliente");
				System.out.println("2.-Editar los datos ingresados del Cliente");
				System.out.println("Ingrese opcion: ");
				try {
					opcion = leer.nextInt();
					valid = true;
					if(opcion<0||opcion>2) {
						System.out.println("La respuesta sale del parametro");
						System.out.println("Ingrese nuevamente");
					}
				}catch(Exception e) {
					valid=false;
					System.out.println("dato ingresado no es valido");
					System.out.println("Ingrese nuevamente");
					leer.next();
				}
				
				switch (opcion) {
				case 1:
					System.out.println("------Actualizando estado del Cliente ");
					System.out.println("El estado actual es: ");
					System.out.println("¿Desea cambiar el estado?");
					System.out.println("1 - Si");
					System.out.println("2 - No");
					System.out.println("Ingrese opcion: ");
					
					
					
					do {
						try {
							opcion = leer.nextInt();
							valid = true;
							if(opcion<1||opcion>2) {
								System.out.println("La opcion ingresada sale del parametro");
								System.out.println("Ingrese nuevamente");
							}
						}catch(Exception e) {
							valid = false;
							System.out.println("El dato ingresado no es valido");
							System.out.println("Intente nuevamente");
							leer.next();
						}
					 }while (opcion < 1 || opcion > 2||valid==false);
						
						switch (opcion) {
						case 1:

							if (cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) {
								cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
								System.out.println(
										"Se cambio el estado correctamente a: " + cliente.getNombreCategoria());
							} else {
								cliente.setNombreCategoria(CategoriaEnum.ACTIVO);

							}
							utilidad.tiempoEspera();
							// menu.iniciarMenu();
							break;
						case 2:
							System.out.println("Se mantuvo el estado actual del Cliente");
							utilidad.tiempoEspera();
							// menu.iniciarMenu();
							break;
						default:
							utilidad.mostrarMensaje();
							break;
						}
					
					utilidad.tiempoEspera();
					utilidad.limpieza();
					break;
				case 2:
					System.out.println("------Actualizando estado del Cliente------");
					System.out.println("1.- El RUN del Cliente es: " + cliente.getRunCliente());
					System.out.println("2.- El Nombre del Cliente es: " + cliente.getNombreCliente());
					System.out.println("3.- El Apellido del Cliente es: " + cliente.getApellidoCliente());
					System.out.println("4.- Los años del Cliente son: " + cliente.getAniosCliente());
					System.out.println("Ingrese opcion a editar: ");
					opcion2 = leer.nextInt();
					System.out.println("-------------------------------------------");
					do {
						switch (opcion2) {
						case 1:
							System.out.println("1.- Ingrese nuevo RUN del Cliente: ");
							respuesta = leer.next();
							cliente.setRunCliente(respuesta);
							System.out.println("Datos cambiados con éxito");
							break;
						case 2:
							System.out.println("2.- Ingrese nuevo Nombre del Cliente: ");
							respuesta = leer.next();
							cliente.setNombreCliente(respuesta);
							System.out.println("Datos cambiados con éxito");
							break;
						case 3:
							System.out.println("3.- Ingrese nuevo Apellido del Cliente: ");
							respuesta = leer.next();
							cliente.setApellidoCliente(respuesta);
							System.out.println("Datos cambiados con éxito");
							break;
						case 4:
							System.out.println("4.- Ingrese nuevos años como Cliente: ");
							respuesta = leer.next();
							cliente.setAniosCliente(respuesta);
							System.out.println("Datos cambiados con éxito");
							utilidad.tiempoEspera();
							// menu.iniciarMenu();
							break;
						default:
							System.out.println("Opcion no valida");
							break;
						}
					} while (opcion2 < 1 || opcion2 > 4);
					System.out.println("salir");
					System.out.println("-------------------------------------------");
					utilidad.limpieza();
					utilidad.tiempoEspera();

					// menu.iniciarMenu();
					break;
				default:
					System.out.println("Opcion no valida");
					break;

				}
			} while (opcion < 1 || opcion > 2);
		}

		utilidad.tiempoEspera();
		utilidad.limpieza();

	}

	
	private Cliente buscarClientePorRun(String rutCliente) {// compara rut con arreglo

		for (Cliente cliente : this.listaClientes) {
			if (rutCliente.equals(cliente.getRunCliente())) {
				return cliente;
			}
		}

		return null;
	}

}
