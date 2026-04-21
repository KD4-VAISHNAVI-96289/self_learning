
public class findMini {
	

    public static <T extends Number> T findMin(T[] arr) {

        T min = arr[0];
        for (T val : arr) {
            if (val.doubleValue() < min.doubleValue()) {
                min = val;
            }
        }

        
        return min;
    }

    
    
    public static void main(String[] args) {

        Integer[] arr1 = {25,20,50,100};
        Double[] arr2 = {75.25,25.50,60.70};

        System.out.println("Min Integer = " + findMin(arr1));
        System.out.println("Min Double = " + findMin(arr2));
    }
}