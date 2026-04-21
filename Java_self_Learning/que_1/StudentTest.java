import java.util.Scanner;

class Student {
int roll;
String name;


Student(int r, String n) {
    roll = r;
    name = n;
}


Student(Student s) {
    this.roll = s.roll;
    this.name = new String(s.name);
}

void display() {
    System.out.println(roll + " " + name);
}

}

public class StudentTest {


static Scanner sc = new Scanner(System.in);

public static int menuList() {
    System.out.println("0.Exit 1.Create 2.Shallow Copy 3.Deep Copy");
    return sc.nextInt();
}

public static void main(String[] args) {

    Student s1 = null, s2 = null;
    int ch;

    while ((ch = menuList()) != 0) {
        switch (ch) {

            case 1:
                System.out.print("Enter roll name: ");
                s1 = new Student(sc.nextInt(), sc.next());
                break;

            case 2:
                s2 = s1; 
                System.out.println("Shallow Copy:");
                s2.display();
                break;

            case 3:
                s2 = new Student(s1);
                System.out.println("Deep Copy:");
                s2.display();
                break;
        }
    }
}

}