package mx.home.constructor;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class ASPruebaImpl implements ASPrueba {
	private DAOPrueba daoPrueba;
	private String info;
	
	@Inject
	public ASPruebaImpl(DAOPrueba daoPrueba, String info) {
		System.out.println("Ejecutando Constructor");
		this.daoPrueba = daoPrueba;
		this.info = info;
	}
	
	@Inject
	public void setInfo(String info) {
		System.out.println("Ejecutando Set");
		this.info = info;
	}
	
	@Override
	public List<String> obtenerInformacion() {
		System.out.println(daoPrueba);
		System.out.println("".equals(info));
		List<String> resultado = new ArrayList<>();
		resultado.add(daoPrueba.obtenerPrimerDato());
		resultado.add(daoPrueba.obtenerSegundoDato());
		return resultado;
	}
	
}
