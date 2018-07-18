package mx.home.implicitProvider;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ASPruebaImpl implements ASPrueba {
	@Inject
	private Provider<DAOPrueba> daoPrueba;
	
	@Override
	public List<String> obtenerInformacion() {
		// Cada que se llama el metodo .get() se obtiene un nuevo objeto
		System.out.println(daoPrueba.get());
		System.out.println(daoPrueba.get());
		List<String> resultado = new ArrayList<>();
		resultado.add(daoPrueba.get().obtenerPrimerDato());
		resultado.add(daoPrueba.get().obtenerSegundoDato());
		return resultado;
	}
	
}
