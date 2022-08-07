package cl.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import cl.modelo.Cliente;
import cl.servicio.Exportador;

public class ExportadorTxt extends Exportador{
	//String nombreArchivo = "Cliente.txt";
	public ExportadorTxt(List<Cliente> listaClientes) {
		super(listaClientes);
		// TODO Auto-generated constructor stub
	}
	
	public ExportadorTxt() {
		
	}
	
	@Override
	public void exportar(String nombreArchivo, List<Cliente> listaClientes) throws IOException {
		// TODO Auto-generated method stub
		File archivo = new File(nombreArchivo);
		FileWriter escribir = new FileWriter(archivo,true);
		BufferedWriter memoriaEscritura= new BufferedWriter(escribir);
		for(Iterator<Cliente> iterador = listaClientes.iterator(); iterador.hasNext();) {
			Cliente cliente = (Cliente)iterador.next();
			memoriaEscritura.write("-----------------------------------------");
			memoriaEscritura.newLine();
			memoriaEscritura.write("Rut: "+cliente.getRunCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Nombre: "+cliente.getNombreCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Apellido: "+cliente.getApellidoCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Años como cliente: "+cliente.getAniosCliente());
			memoriaEscritura.newLine();
			memoriaEscritura.write("Categoria: "+cliente.getNombreCategoria());
			memoriaEscritura.newLine();
			memoriaEscritura.write("-----------------------------------------");
		}
		
		memoriaEscritura.close();


	}
	@Override
	public void crearCarpeta(String ruta) {
		// TODO Auto-generated method stub
		File carpeta = new File(ruta);
		if(!carpeta.exists()) {
			try{
				carpeta.mkdirs();
				System.out.println("Carpeta Creada");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void crearArchivo(String nombreArchivo) {
		// TODO Auto-generated method stub
		File archivo = new File(nombreArchivo);
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

