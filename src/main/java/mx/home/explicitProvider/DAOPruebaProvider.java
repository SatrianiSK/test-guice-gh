package mx.home.explicitProvider;

import java.util.Random;

import com.google.inject.Provider;

public class DAOPruebaProvider implements Provider<DAOPrueba> {
	
	@Override
	public DAOPrueba get() {
		Random random = new Random();
		switch(random.nextInt(2)) {
			case 0:
				return new DAOPruebaImpl();
			case 1:
				return new DAOPruebaImpl2();
			default:
				return new DAOPruebaImpl();
		}
	}
	
}
