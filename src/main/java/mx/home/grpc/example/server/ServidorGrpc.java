package mx.home.grpc.example.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServidorGrpc {
    /** Servidor de GRPC. */
    private Server server;
    
    /** Inicia el servidor. 
     * @throws IOException */
    private void start() throws IOException {
        int port = 8095;
        server = ServerBuilder.forPort(port)
                .addService(new ServiceGreeterImpl())
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
    
}
