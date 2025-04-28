package executors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheWithReadWriteLock {

    private Map<Long, String> cache = new HashMap<>();

    public String put(Long key, String value){
        return cache.put(key, value);
    }

    public String get(Long key){
        return cache.get(key);
    }

    public static void main(String[] args) {
        CacheWithReadWriteLock cache  = new CacheWithReadWriteLock();

        class Producer implements Callable<String> {

            private Random rand = new Random();

            public String call() throws InterruptedException{
                while(true){
                    long key = rand.nextInt(1_000);
                    cache.put(key , Long.toString(key));
                    if(cache.get(key) == null){
                        System.out.println("Key " + key + "has not yet been put in the cache");
                    }
                }
            }
        }

        ExecutorService executors = Executors.newFixedThreadPool(4);

        try{
            for(int i=0;i<4;i++){
                executors.submit(new Producer());
            }
        }finally {
            executors.shutdown();
        }
    }
}
