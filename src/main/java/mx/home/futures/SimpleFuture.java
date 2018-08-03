package mx.home.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleFuture {
    /**
     * Función principal.
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        Future<String> future = fixedThreadPool.submit(() -> {
            Thread.sleep(2000);
            return "Finish";
        });
        
        System.out.println("Write something");
        System.out.println("Future state: " + future.isDone());
        String result = null;
        try {
            result = future.get(); // So, when we use get the main thread gets blocked
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Future state: " + future.isDone());
        System.out.println("Result: " + result);
    }
}
