
import java.util.Scanner;
import java.util.stream.IntStream;

	public class Sum {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number: ");
	        int n = sc.nextInt();
	        int sum = IntStream.rangeClosed(1, n).sum();

	        System.out.println("Sum = " + sum);
	    }
	}
	
	
	
	

	
