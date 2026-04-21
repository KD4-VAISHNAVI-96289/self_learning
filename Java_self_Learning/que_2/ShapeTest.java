import java.util.Scanner;

abstract class Shape {
    abstract double area();
}
abstract class Shape3D extends Shape {
    abstract double volume();
}


class Circle extends Shape {
    double r;
    Circle(double r)
    {
    	this.r=r; 
    }

    double area() 
    { 
    	return Math.PI*r*r; 
    }
}


class Rectangle extends Shape {
    double l,b;
    Rectangle(double l,double b)
    { 
    	this.l=l; this.b=b; 
    }

    double area()
    { 
    	return l*b; 
    }
}

class Sphere extends Shape3D {
    double r;
    Sphere(double r){ 
    	this.r=r; 
    	}

    double area(){ 
    	return 4*Math.PI*r*r; 
    	}
    double volume(){ 
    	return (4.0/3)*Math.PI*r*r*r; 
    	}
}

public class ShapeTest {
    static Scanner sc = new Scanner(System.in);
    public static int menuList() {
        System.out.println("0.Exit 1.Circle 2.Rectangle 3.Sphere");
        return sc.nextInt();
    }

    
    public static void main(String[] args) {

        int ch;
        while ((ch = menuList()) != 0) {
            switch (ch) {

            
            
                case 1:
                    System.out.print("enter radius: ");
                    Circle c = new Circle(sc.nextDouble());
                    System.out.println("Area = " + c.area());
                    break;

                    
                    
                    
                case 2:
                    System.out.print("enter length, breadth: ");
                    Rectangle r = new Rectangle(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Area = " + r.area());
                    break;

                    
                    
                case 3:
                    System.out.print("enter radius: ");
                    Sphere s = new Sphere(sc.nextDouble());
                    System.out.println("area = " + s.area());
                    System.out.println("volume = " + s.volume());
                    break;
            }                
        }
}
}
