package mx.home.singleImplementation;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class ASPruebaImpl implements ASPrueba {
	@Inject
	private DAOPrueba daoPrueba;
	
	@Override
	public List<String> obtenerInformacion() {
		System.out.println(daoPrueba);
		List<String> resultado = new ArrayList<>();
		resultado.add(daoPrueba.obtenerPrimerDato());
		resultado.add(daoPrueba.obtenerSegundoDato());
		return resultado;
	}
	
}
