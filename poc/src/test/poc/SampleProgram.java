package test.poc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SampleProgram {

	public static void main(String[] args) {
		
		System.out.println("Retrieving Name.");
		CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {
		    return getName();
		});
		
		System.out.println("Retrieving weight.");
		CompletableFuture<Double> weightFuture = CompletableFuture.supplyAsync(() -> {
		    return getWeight();
		});

		System.out.println("Retrieving height.");
		CompletableFuture<Double> heightFuture = CompletableFuture.supplyAsync(() -> {
		    return getHeight();
		});

		System.out.println("Get Details.");
		CompletableFuture combinedFuture = CompletableFuture.allOf(nameFuture, weightFuture, heightFuture);
		
		try {
			combinedFuture.get();
			System.out.println("Your Deatils are - Name : " + nameFuture.get() + " Weight : " + weightFuture.get() + " Height : "+heightFuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static Double getHeight() {
		try {
		    TimeUnit.SECONDS.sleep(5);
		    System.out.println(" height calculated");
		} catch (InterruptedException e) {
		   throw new IllegalStateException(e);
		}
		return 173.5;
	}

	private static Double getWeight() {
		try {
		    TimeUnit.SECONDS.sleep(10);
		    System.out.println(" weight calculated");
		} catch (InterruptedException e) {
		   throw new IllegalStateException(e);
		}
		return 75.0;
	}
	
	private static String getName() {
		try {
		    TimeUnit.SECONDS.sleep(15);
		    System.out.println(" Name is Pradeep");
		} catch (InterruptedException e) {
		   throw new IllegalStateException(e);
		}
		return "Pradeep";
	}

}
