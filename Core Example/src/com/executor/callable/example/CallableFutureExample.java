package com.executor.callable.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
 
class SumIntegerCallable implements Callable<Integer> {
 
    Integer n;
 
    SumIntegerCallable(Integer n) {
           this.n = n;
    }
 
    @Override
    public Integer call() throws Exception {
           Integer sum = 0;
           for (int i = 0; i <= n; i++) {
                  sum += i;
           }
           return sum;
    }
 
}
 
 
class SquareDoubleCallable implements Callable<Double> {
 
    Double n;
 
    SquareDoubleCallable(Double n) {
           this.n = n;
    }
 
    @Override
    public Double call() throws Exception {
           return n*n;
    }
 
}
 
 
 
 
public class CallableFutureExample {
  private static final int NTHREDS = 10;
 
  public static void main(String[] args) throws InterruptedException, ExecutionException {
 
    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
    Future<Integer> futureInteger=executor.submit(new SumIntegerCallable(4));
    Future<Double> futureDouble=executor.submit(new SquareDoubleCallable(2.2));
   
    System.out.println("SumIntegerCallable has returned > "+futureInteger.get());
    System.out.println("SquareDoubleCallable has returned > "+futureDouble.get());
        
    executor.shutdown();
  }
}
 
/*OUTPUT
 
SumIntegerCallable has returned > 10
SquareDoubleCallable has returned > 4.840000000000001
 
*/
