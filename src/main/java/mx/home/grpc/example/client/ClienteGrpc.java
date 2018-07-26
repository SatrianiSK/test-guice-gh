package mx.home.grpc.example.client;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mx.home.grpc.generated.helloworld.GreeterGrpc;
import mx.home.grpc.generated.helloworld.HelloReply;
import mx.home.grpc.generated.helloworld.HelloRequest;

public class ClienteGrpc {
	private final ManagedChannel channel;
	private final GreeterGrpc.GreeterBlockingStub blockingStub;
	
	public ClienteGrpc(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
	}
	
	public ClienteGrpc(ManagedChannel channel) {
		this.channel = channel;
		blockingStub = GreeterGrpc.newBlockingStub(channel);
	}
	
	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public void greet(String name) {
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		HelloReply response = null;
		response = blockingStub.sayHello(request);
		System.out.println("Mensaje de servidor: " + response.getMessage());
	}
	
	public static void main(String[] args) {
		ClienteGrpc cliente = new ClienteGrpc("localhost", 8095);
		String name = "Rodrigo";
		try {
			cliente.greet(name);
			cliente.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
