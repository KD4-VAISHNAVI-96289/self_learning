import java.util.Comparator;

public class SelectionSort {

    
    static <T> void selectionSort(T[] arr, Comparator<T> c) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (c.compare(arr[i], arr[j]) > 0) {

                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {55,66,77,88};     
        Comparator<Integer> comp = (a, b) -> a - b;

        selectionSort(arr, comp);

        System.out.println("sorted array:");
        for (int n : arr) {
            System.out.print(n + ",");
        }
    }
}


