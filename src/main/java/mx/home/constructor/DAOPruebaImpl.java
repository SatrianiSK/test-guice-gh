package mx.home.constructor;

public class DAOPruebaImpl implements DAOPrueba {
	
	@Override
	public String obtenerPrimerDato() {
		return "Primer dato";
	}
	
	@Override
	public String obtenerSegundoDato() {
		return "Segundo dato";
	}
	
	@Override
	public String toString() {
		String result = super.toString() + "-" + this.getClass();
		return result;
	}
	
}
