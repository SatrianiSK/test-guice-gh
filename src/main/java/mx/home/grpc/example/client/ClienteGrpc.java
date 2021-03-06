package mx.home.grpc.example.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mx.home.grpc.generated.helloworld.GreeterGrpc;
import mx.home.grpc.generated.helloworld.HelloReply;
import mx.home.grpc.generated.helloworld.HelloRequest;

public class ClienteGrpc {
    private final ManagedChannel channel;
    //private final GreeterGrpc.GreeterBlockingStub blockingStub; // Previamente usado para llamada síncrona
    private final GreeterGrpc.GreeterFutureStub futureStub;
    private final ExecutorService threadPool;
    
    @Inject
    public ClienteGrpc(String host, int port, ExecutorService executor) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build(), executor);
    }
    
    public ClienteGrpc(ManagedChannel channel, ExecutorService executor) {
        this.channel = channel;
        //blockingStub = GreeterGrpc.newBlockingStub(channel); // Previamente usado para llamada síncrona
        futureStub = GreeterGrpc.newFutureStub(channel);
        threadPool = executor;
    }
    
    public void shutdown() throws InterruptedException {
        Thread.sleep(2000);
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        threadPool.shutdown();
    }
    
    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        //response = blockingStub.sayHello(request); // Previamente usado para llamada síncrona
        ListenableFuture<HelloReply> future = futureStub.sayHello(request);
        future.addListener(() -> {
            HelloReply response = null;
            try {
                response = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Mensaje de servidor: " + response.getMessage());
            System.out.println("Hilo de ejecución en la respuesta: " + Thread.currentThread().getName());
        }, threadPool);
        System.out.println("Hilo fuera de la respuesta: " + Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ClientModule());
        ClienteGrpc cliente = injector.getInstance(ClienteGrpc.class);
        
        String name = "Rodrigo";
        try {
            cliente.greet(name);
            cliente.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
