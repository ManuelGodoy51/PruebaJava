package cl.modelo;

public enum CategoriaEnum {
	ACTIVO, INACTIVO;
	public static CategoriaEnum parse(String text){
        if(ACTIVO.name().equalsIgnoreCase(text)){
            return ACTIVO;
        } else {
            return INACTIVO;
        }
	}
}