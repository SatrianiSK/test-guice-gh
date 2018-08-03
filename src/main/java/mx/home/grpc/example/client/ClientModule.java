package mx.home.grpc.example.client;

import java.util.concurrent.Executors;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ClientModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		
	}
	
	@Provides
	public ClienteGrpc getServerGrpc() {
		ClienteGrpc cliente = new ClienteGrpc("localhost", 9000, Executors.newCachedThreadPool());
		return cliente;
	}

}
