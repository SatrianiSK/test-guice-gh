package mx.home.grpc.example;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerTest {
	/** Servidor de GRPC. */
	private Server server;
	
	/** Inicia el servidor. 
	 * @throws IOException */
	private void start() throws IOException {
		int port = 8095;
		server = ServerBuilder.forPort(port)
				.build()
				.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				ServerTest.this.stop();
			}
		});
	}
	
	/** Detiene el servidor. */
	private void stop() {
		if(server != null) {
			server.shutdown();
		}
	}
	
	/** Hace que el servidor espere. */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
	
	/** Main 
	 * @throws IOException 
	 * @throws InterruptedException */
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerTest server = new ServerTest();
		server.start();
		server.blockUntilShutdown();
	}
	
}
