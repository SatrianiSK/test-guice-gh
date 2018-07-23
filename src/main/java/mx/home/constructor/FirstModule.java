package mx.home.constructor;

import java.util.Random;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class FirstModule extends AbstractModule {
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ASPrueba.class).to(ASPruebaImpl.class);
	}
	
	@Provides
	public DAOPrueba getDaoPrueba() {
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
	
//	@Provides
//	public ASPrueba getAsPrueba() {
//		ASPrueba asPrueba = new ASPruebaImpl(getDaoPrueba());
//		return asPrueba;
//	}
	
}
