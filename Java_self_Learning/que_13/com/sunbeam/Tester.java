package com.sunbeam;
import java.util.*;

public class Tester {

    public static void main(String[] args) {

        Student[] arr = {
            new Student(1, "virat", "london", 85),
            new Student(2, "rohit", "Mumbai", 90),
            new Student(3, "kl", "benguluru", 90),
            new Student(4, "shreyas", "mumbai", 80)
        };

        Arrays.sort(arr, (a, b) -> {

            
            int cityCompare = b.getCity().compareTo(a.getCity());
            if (cityCompare == 0) {

             
                int marksCompare = Double.compare(b.getMarks(), a.getMarks());
                if (marksCompare == 0) {

                    return a.getName().compareTo(b.getName());
                }
                return marksCompare;
            }
            return cityCompare;
        });

        System.out.println("sorted students:");
        for (Student s : arr) {
            System.out.println(s);
        }
    }
}