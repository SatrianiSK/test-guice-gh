package mx.home.explicitProvider;

import com.google.inject.AbstractModule;

public class FirstModule extends AbstractModule {
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(ASPrueba.class).to(ASPruebaImpl.class);
		bind(DAOPrueba.class).toProvider(DAOPruebaProvider.class);
	}
	
}
