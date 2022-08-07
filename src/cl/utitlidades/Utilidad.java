package cl.utitlidades;

import java.util.concurrent.TimeUnit;

public class Utilidad {
	
	
	public Utilidad() {}
	
	
	public void mostrarMensaje() {
		System.out.println("Opcion no valida");
	}
	
	public void mostrarMensaje1() {
		System.out.println("Datos cambiados con exito");
	}
	
	public void mostrarMensaje2() {
		System.out.println("Datos cargados correctamente en la lista");
	}
//	public  String mostrarMensaje(String mensaje) {
//		mensaje = "opcion no valida";
//		//System.out.println();
//		return mensaje;
//	}
	public void limpieza() {
		System.out.println("------------------------------");
	}
	
	public void tiempoEspera() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}

