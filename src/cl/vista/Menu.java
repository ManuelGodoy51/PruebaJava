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
	ClienteServicio clienteServicio = new ClienteServicio();
	ImportarDatos importarDatos = new ImportarDatos();
	ExportadorCsv exportarCsv =new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	
	Utilidad utilidad = new Utilidad();
	Cliente cliente = new Cliente();
	Scanner leer = new Scanner(System.in);
	int opcion = 0;
	boolean valid = true;
	String respuesta;
	String ruta;
	
	//constructores
	public Menu() {
	}

	/*
	 * public Menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio,
	 * ExportadorCsv exportarCsv, ExportadorTxt exportarTxt, String fileName, String
	 * fileName1, Utilidad utilidad, Scanner leer, int opcion, String respuesta,
	 * String ruta) { //super(); this.clienteServicio = clienteServicio;
	 * this.archivoServicio = archivoServicio; this.exportarCsv = exportarCsv;
	 * this.exportarTxt = exportarTxt; this.fileName = fileName; this.fileName1 =
	 * fileName1; this.utilidad = utilidad; this.leer = leer; this.opcion = opcion;
	 * this.respuesta = respuesta; this.ruta = ruta; }
	 */
	
	
	public void iniciarMenu() throws IOException {
		do {
			System.out.println("1.- Listar Clientes");
			System.out.println("2.- Agregar Cliente");
			System.out.println("3.- Editar Cliente");
			System.out.println("4.- Cargar Datos");
			System.out.println("5.- Exportar Datos");
			System.out.println("6.- Salir");
			System.out.println("Ingrese una opcion: ");
			
			do {
				try {
					opcion = leer.nextInt();
					valid = true;
					if(opcion <1||opcion>6) {
						System.out.println("El numero ingresado sale del parametro");
						System.out.println("Intente nuevamente");
					}
				}catch(Exception e){
					valid = false;
					System.out.println("el dato ingresado no es válido");
					System.out.println("Intente nuevamente");
					leer.next();
				}
			}while(opcion <1||opcion>6||valid==false);
			

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
		
		clienteServicio.retornoListarClientes();
		//System.out.println(cliente.toString());
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

		clienteServicio.crearCliente(rut, nombre, apellido, edad, CategoriaEnum.ACTIVO);
		utilidad.tiempoEspera();
		utilidad.limpieza();
		utilidad.tiempoEspera();
		iniciarMenu();
	}//cierre agregar clientes
	
	public void editarCliente() throws IOException {

		System.out.println("-----------------Editar Cliente----------------");

		clienteServicio.retornoEditarCliente();

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}//cierre editar cliente
	
	
		
	public void importarDatos() throws IOException {
			System.out.println("---------------------Cargar Datos---------------------");
			System.out.println("1.-Linux o Mac");
			System.out.println("2.-Windows");
			System.out.println("Ingrese Opcion: ");
			
			do {
				try {
					opcion = leer.nextInt();
					valid=true;
					if(opcion<0||opcion>2) {
						System.out.println("La opcion ingresada sale del parametro");
						System.out.println("Intente nuevamente");
					}
				}catch(Exception e) {
					valid=false;
					System.out.println("El dato ingresado no es valido");
					System.out.println("Intente nuevamente");
					leer.next();
				}
			}while(opcion<0||opcion>2||valid==false);
			
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
					
					try {
						importarDatos.cargarDatos(ruta+"/"+fileName1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
			

			System.out.println("Datos Cargados Correctamente");
		}// cierre del metodo importar
	
	public void exportarDatos() throws IOException {
		System.out.println("-----------Exportar Datos--------------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("Ingrese una opción para exportar: ");
		
		do {
			try {
				opcion = leer.nextInt();
				valid=true;
				if(opcion<1||opcion>2) {
					System.out.println("La opcion ingresada sale del parametro");
					System.out.println("Intente nuevamente");
				}
			}catch(Exception e) {
				valid = false;
				System.out.println("La opcion ingresada no es valida");
				System.out.println("Intente nuevamente");
				leer.next();
			}
		}while(opcion<0||opcion>2||valid==false);
		
			switch (opcion) {
			case 1:
				System.out.println("------------------Exportar Datos en Linux o MAC------------------------");
				System.out.println("Ingresa la ruta en donde se desea exportar el archivo clientes.csv: ");
				ruta = leer.next().toString();
				ExportadorCsv ecsv = new ExportadorCsv();
				ecsv.crearCarpeta(ruta);
				ecsv.crearArchivo(ruta+"/"+fileName+".csv");
				
				ecsv.exportar(ruta+"/"+fileName+".csv", clienteServicio.getListaClientes());
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
				ExportadorTxt ett = new ExportadorTxt();
				ett.crearCarpeta(ruta);
				ett.crearArchivo(ruta+"/"+fileName+".txt");
				ett.exportar(ruta+"/"+fileName+".txt", clienteServicio.getListaClientes());
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
		

		utilidad.tiempoEspera();
		utilidad.limpieza();
	}// cierre del metodo exportar
	
	
	public void terminarPrograma() {
		System.out.println("Saliendo del sistema de gestion de los clientes...");
		System.out.println("Acaba de salir del sistema.");
		System.exit(0);
	}
	
}

