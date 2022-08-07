package cl.vista;
import cl.utitlidades.Utilidad;
import cl.modelo.CategoriaEnum;
import cl.servicio.ExportadorTxt;
import cl.servicio.ImportarDatos;
import cl.modelo.Cliente;

import java.io.IOException;
import java.util.Scanner;

import cl.servicio.ArchivoServicio;
import cl.servicio.ClienteServicio;
import cl.servicio.ExportadorCsv;
import cl.servicio.ExportadorTxt;


public class Menu {
	
	ClienteServicio clienteServicio;
	ArchivoServicio archivoServicio;
	ExportadorCsv exportarCsv;
	ExportadorTxt exportarTxt;
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	
	Utilidad utilidad = new Utilidad();
	
	Scanner leer = new Scanner(System.in);
	int opcion = 0;
	String respuesta;
	String ruta;
	
	//constructores
	public Menu() {
	}

	public Menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio, ExportadorCsv exportarCsv,
			ExportadorTxt exportarTxt, String fileName, String fileName1, Utilidad utilidad, Scanner leer, int opcion,
			String respuesta, String ruta) {
		//super();
		this.clienteServicio = clienteServicio;
		this.archivoServicio = archivoServicio;
		this.exportarCsv = exportarCsv;
		this.exportarTxt = exportarTxt;
		this.fileName = fileName;
		this.fileName1 = fileName1;
		this.utilidad = utilidad;
		this.leer = leer;
		this.opcion = opcion;
		this.respuesta = respuesta;
		this.ruta = ruta;
	}
	
	
	public void iniciarMenu() throws IOException {
		do {
			System.out.println("1.- Listar Clientes");
			System.out.println("2.- Agregar Cliente");
			System.out.println("3.- Editar Cliente");
			System.out.println("4.- Cargar Datos");
			System.out.println("5.- Exportar Datos");
			System.out.println("6.- Salir");
			System.out.println("Ingrese una opcion: ");
			opcion = leer.nextInt();

			switch (opcion) {
			case 1: {
				listarCliente();
				break;
			}
			case 2: {
				agregarCliente();
				break;
			}
			case 3: {
				editarCliente();
				break;
			}
			case 4: {
				importarDatos();
				break;
			}
			case 5: {
				exportarDatos();
				break;
			}
			case 6: {
				terminarPrograma();
				break;
			}
			default:
				utilidad.mostrarMensaje();
				break;

			}

		} while (opcion != 6);

	}
	
	
	
	
	public void listarCliente() throws IOException {
		System.out.println("-----------------Datos del Cliente----------------");
		//ClienteServicio sc = new ClienteServicio();
		//sc.retornoListarClientes(clientes);
		utilidad.tiempoEspera();
		utilidad.limpieza();
		utilidad.tiempoEspera();
		iniciarMenu();
		
	}//cierre listar clientes
	
	public void agregarCliente() throws IOException{
		System.out.println("-----------------Crear Cliente----------------");
		System.out.println("Ingresa RUN del Cliente: ");
		String rut = leer.next();
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre = leer.next();
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido = leer.next();
		System.out.println("Ingresa los años como Cliente: ");
		String edad = leer.next();
		
		System.out.println("-----------------------------------------------");

		//Cliente cliente = new Cliente(rut, nombre, apellido, edad, CategoriaEnum.ACTIVO);

		//clientes.add(cliente);
		// System.out.print(clientes);
		//ClienteServicio scc = new ClienteServicio();
		//scc.setListaClientes(clientes);
		//System.out.println(cliente.toString());
		utilidad.tiempoEspera();
		utilidad.limpieza();
		utilidad.tiempoEspera();
		iniciarMenu();
	}//cierre agregar clientes
	
	public void editarCliente() throws IOException {

		System.out.println("-----------------Editar Cliente----------------");

		System.out.println("Ingrese RUN del Cliente a editar:");
		respuesta = leer.next();

		/*Cliente cliente = buscarClientePorRun(respuesta);

		if (cliente == null) {

			System.out.println("Rut no existe");
		} else {
			menuEditarCliente(cliente);
		}*/

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}//cierre editar cliente
	
	private Cliente buscarClientePorRun(String rutCliente) {

		/*for (Cliente cliente : this.clientes) {
			if (rutCliente.equals(cliente.getRunCliente())) { // compara rut con arreglo
				return cliente;
			}
		}*/

		return null;
	}//buscar cliente por run
	
	
	private void menuEditarCliente(Cliente cliente)throws IOException {

		do {
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1.-Cambiar el estado del Cliente");
			System.out.println("2.-Editar los datos ingresados del Cliente");
			System.out.println("Ingrese opcion: ");
			opcion = leer.nextInt();
			switch (opcion) {
			case 1:
				cambiarEstadoCliente(cliente);
				utilidad.tiempoEspera();
				iniciarMenu();
				break;
			case 2:
				cambiarDatosCliente(cliente);
				utilidad.limpieza();
				utilidad.tiempoEspera();
				iniciarMenu();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
				
			}
		}while (opcion<1||opcion>2);
	}//menu editar cliente
	
	private void cambiarEstadoCliente(Cliente cliente) throws IOException {
		
		
		System.out.println("------Actualizando estado del Cliente ");
		System.out.println("El estado actual es: ");
		System.out.println("¿Desea cambiar el estado?");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		System.out.println("Ingrese opcion: ");
		opcion = leer.nextInt();
		do {
			switch(opcion){
				case 1:
					
					/*if(cliente.getNombreCategoria() == CategoriaEnum.ACTIVO) {
						cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
						System.out.println("Se cambio el estado correctamente a: "+cliente.getNombreCategoria());
					}else {
						cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
						
					}*/
					utilidad.tiempoEspera();
					iniciarMenu();
					break;
				case 2:
					System.out.println("Se mantuvo el estado actual del Cliente");
					utilidad.tiempoEspera();
					iniciarMenu();
					break;
				default:
					utilidad.mostrarMensaje();
					break;
			}
		}while(opcion <1 || opcion>2);
		utilidad.tiempoEspera();
		utilidad.limpieza();
		
		
	}//cambiar estado cliente
	
	
	private void cambiarDatosCliente(Cliente cliente) throws IOException {
		
		System.out.println("------Actualizando estado del Cliente------");
		System.out.println("1.- El RUN del Cliente es: "  );
		System.out.println("2.- El Nombre del Cliente es: ");
		System.out.println("3.- El Apellido del Cliente es: ");
		System.out.println("4.- Los años del Cliente son: ");
		System.out.println("Ingrese opcion a editar: ");
		opcion = leer.nextInt();
		System.out.println("-------------------------------------------");
		 do{
			switch (opcion) {
			case 1:
				System.out.println("1.- Ingrese nuevo RUN del Cliente: ");
				respuesta = leer.next();
				//cliente.setRunCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 2:
				System.out.println("2.- Ingrese nuevo Nombre del Cliente: ");
				respuesta = leer.next();
				//cliente.setNombreCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 3:
				System.out.println("3.- Ingrese nuevo Apellido del Cliente: ");
				respuesta = leer.next();
				//cliente.setApellidoCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				break;
			case 4:
				System.out.println("4.- Ingrese nuevos años como Cliente: ");
				respuesta = leer.next();
				//cliente.setAniosCliente(respuesta);
				System.out.println("Datos cambiados con éxito");
				utilidad.tiempoEspera();
				iniciarMenu();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion <1||opcion>4);
		 System.out.println("salir");
		System.out.println("-------------------------------------------");
	}//cambiar datos
		
	public void importarDatos() throws IOException {
			System.out.println("---------------------Cargar Datos---------------------");
			System.out.println("1.-Linux o Mac");
			System.out.println("2.-Windows");
			System.out.println("Ingrese Opcion: ");
			opcion = leer.nextInt();
			do {
				switch (opcion) {
				case 1:
					System.out.println("-----------Cargar Datos en Linux o MAC--------------");
					System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
					ruta = leer.next();
					utilidad.tiempoEspera();
					utilidad.limpieza();
					utilidad.mostrarMensaje2();
					break;
				case 2:
					System.out.println("-----------Cargar Datos en Windows--------------");
					System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
					ruta = leer.next();
					/*ImportarDatos imp = new ImportarDatos();
					try {
						imp.cargarDatos(ruta+"/"+fileName1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					
					utilidad.tiempoEspera();
					utilidad.limpieza();
					utilidad.mostrarMensaje2();
					utilidad.tiempoEspera();
					iniciarMenu();
					break;
				default:
					utilidad.mostrarMensaje();
					break;
				}
			} while (opcion != 2);

			System.out.println("Datos Cargados Correctamente");
		}// cierre del metodo importar
	
	public void exportarDatos() throws IOException {
		System.out.println("-----------Exportar Datos--------------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar: ");
		opcion = leer.nextInt();
		do {
			switch (opcion) {
			case 1:
				System.out.println("------------------Exportar Datos en Linux o MAC------------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.csv: ");
				ruta = leer.next().toString();
				/*ExportadorCsv ecsv = new ExportadorCsv();
				ecsv.crearCarpeta(ruta);
				ecsv.crearArchivo(ruta+"/"+fileName+".csv");
				ecsv.exportar(ruta+"/"+fileName+".csv", clientes);*/
				utilidad.tiempoEspera();
				utilidad.limpieza();
				System.out.println("Datos de Clientes exoportados correctamente en formato csv.");
				utilidad.tiempoEspera();
				iniciarMenu();
				break;
			case 2:
				System.out.println("----------------------Exportar Datos en Windows-----------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.txt: ");
				//Scanner ss = new Scanner();
				ruta = leer.next().toString();
				/*ExportadorTxt ett = new ExportadorTxt();
				ett.crearCarpeta(ruta);
				ett.crearArchivo(ruta+"/"+fileName+".txt");
				ett.exportar(ruta+"/"+fileName+".txt", clientes);*/
				utilidad.tiempoEspera();
				utilidad.limpieza();
				System.out.println("Datos de Clientes exoportados correctamente en formato txt.");
				utilidad.tiempoEspera();
				iniciarMenu();
				break;
			default:
				utilidad.mostrarMensaje();
				break;
			}
		} while (opcion != 2);

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}// cierre del metodo exportar
	
	
	public void terminarPrograma() {
		System.out.println("Saliendo del sistema de gestion de los clientes...");
		System.out.println("Acaba de salir del sistema.");
		System.exit(0);
	}
	
}

