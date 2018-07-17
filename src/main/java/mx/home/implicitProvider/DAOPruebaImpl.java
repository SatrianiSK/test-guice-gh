package mx.home.implicitProvider;

public class DAOPruebaImpl implements DAOPrueba {
	
	@Override
	public String obtenerPrimerDato() {
		return "Primer dato";
	}
	
	@Override
	public String obtenerSegundoDato() {
		return "Segundo dato";
	}
	
}
