package mx.home.constructor;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Principal {
	/**
	 * Método principal.
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new FirstModule());
		ASPrueba asPrueba = injector.getInstance(ASPrueba.class);
		
		System.out.println(asPrueba);
		System.out.println(asPrueba.obtenerInformacion());
		
	}
	
}
