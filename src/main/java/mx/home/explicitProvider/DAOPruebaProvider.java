package mx.home.explicitProvider;

import java.util.Random;

import com.google.inject.Provider;

public class DAOPruebaProvider implements Provider<DAOPrueba> {
	
	@Override
	public DAOPrueba get() {
		DAOPrueba instance = null;
		Random random = new Random();
		switch(random.nextInt(2)) {
			case 0:
				instance = new DAOPruebaImpl();
				break;
			case 1:
				instance = new DAOPruebaImpl2();
				break;
			default:
				instance = new DAOPruebaImpl();
				break;
		}
		return instance;
	}
	
}
