package mx.home.implicitProvider;

import java.util.List;

import com.google.inject.ImplementedBy;

@ImplementedBy(ASPruebaImpl.class)
public interface ASPrueba {
	
	public List<String> obtenerInformacion();
	
}
