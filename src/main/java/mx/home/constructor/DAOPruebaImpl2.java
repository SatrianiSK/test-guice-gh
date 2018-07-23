package mx.home.constructor;

public class DAOPruebaImpl2 implements DAOPrueba {
	
	@Override
	public String obtenerPrimerDato() {
		return "IMPL2-DATO1";
	}
	
	@Override
	public String obtenerSegundoDato() {
		return "IMPL2-DATO2";
	}
	
	@Override
	public String toString() {
		String result = super.toString() + "-" + this.getClass();
		return result;
	}
	
}
