package mx.home.grpc.example.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import mx.home.grpc.generated.helloworld.GreeterGrpc;
import mx.home.grpc.generated.helloworld.HelloReply;
import mx.home.grpc.generated.helloworld.HelloRequest;

public class ServidorGrpc {
	/** Servidor de GRPC. */
	private Server server;
	
	/** Inicia el servidor. 
	 * @throws IOException */
	private void start() throws IOException {
		int port = 8095;
		server = ServerBuilder.forPort(port)
				.addService(new GreeterImpl())
				.build()
				.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				ServidorGrpc.this.stop();
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
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ServidorGrpc server = new ServidorGrpc();
		server.start();
		server.blockUntilShutdown();
	}
	
	
	static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
		@Override
		public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
			HelloReply reply = HelloReply.newBuilder().setMessage("Hola " + request.getName()).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();
		}
	}
	
}
