package mx.home.implicitProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Principal {
	/**
	 * Método principal.
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		ASPrueba asPrueba = injector.getInstance(ASPrueba.class);
		System.out.println(asPrueba);
		System.out.println(asPrueba.obtenerInformacion());
		System.out.println();
		
		System.out.println(asPrueba);
		System.out.println(asPrueba.obtenerInformacion());
		
	}
	
}
