package mx.home.implicitProvider;

import com.google.inject.ImplementedBy;

@ImplementedBy(DAOPruebaImpl.class)
public interface DAOPrueba {
	
	public String obtenerPrimerDato();
	
	public String obtenerSegundoDato();
	
}
