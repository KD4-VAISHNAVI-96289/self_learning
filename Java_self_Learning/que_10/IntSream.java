import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntSream {

    public static void main(String[] args) {

    
        IntStream stream = IntStream.rangeClosed(1, 10);

       
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum = " + sum);

       
        IntSummaryStatistics stats = IntStream
        		.rangeClosed(1, 10)
        		.summaryStatistics();

        System.out.println("count = " + stats.getCount());
        System.out.println("min = " + stats.getMin());
        System.out.println("max = " + stats.getMax());
        System.out.println("average = " + stats.getAverage());
        System.out.println("sum = " + stats.getSum());
    }


}
