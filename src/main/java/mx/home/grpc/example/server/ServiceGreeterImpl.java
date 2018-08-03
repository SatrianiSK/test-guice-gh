package mx.home.grpc.example.server;

import io.grpc.stub.StreamObserver;
import mx.home.grpc.generated.helloworld.GreeterGrpc;
import mx.home.grpc.generated.helloworld.HelloReply;
import mx.home.grpc.generated.helloworld.HelloRequest;

public class ServiceGreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hola " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
