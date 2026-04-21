package com.sunbeam;

public class Student {

    private int roll;
    private String name;
    private String city;
    private double marks;

    public Student(int roll, String name, String city, double marks) {
        this.roll = roll;
        this.name = name;
        this.city = city;
        this.marks = marks;
    }

    public String getName() 
    { 
    	return name; 
    }
    public String getCity() 
    { 
    	return city; 
    }
    public double getMarks() 
    { 
    	return marks; 
    }

    public String toString() {
        return "[" + roll + " " + name + " " + city + " " + marks + "]";
    }
}