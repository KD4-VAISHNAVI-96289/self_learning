import java.util.Scanner;




class Animal {
 String name;

 Animal(String name) {
     this.name = name;
 }

 void sound() {
     System.out.println("Animal makes sound");
 }
}





class Lion extends Animal {

 Lion(String name) {
     super(name);
 }

 void sound() {
     System.out.println(name + " roars");
 }
}





class Tiger extends Animal {

 Tiger(String name) {
     super(name);
 }

 void sound() {
     System.out.println(name + " growls");
 }
}




//--association
class ZooMange {

 Animal a;   
 void addAnimal(Animal a) {
     this.a = a;
 }

 void showAnimal() {
     if (a != null) {
         a.sound();
     } else {
         System.out.println("No Animal in Zoo");
     }
 }
}





//Test 
public class Zoo {

 static Scanner sc = new Scanner(System.in);

 public static int menuList() {
     System.out.println("0.Exit 1.Add Lion 2.Add Tiger 3.Show Animal ");
     return sc.nextInt();
 }

 public static void main(String[] args) {

     ZooMange zm = new ZooMange();
     int ch;

     while ((ch = menuList()) != 0) {

         switch (ch) {

             case 1:
                 System.out.print("lion name: ");
                 zm.addAnimal(new Lion(sc.next()));
                 break;

             case 2:
                 System.out.print("tiger name: ");
                 zm.addAnimal(new Tiger(sc.next()));
                 break;

             case 3:
                 zm.showAnimal();
                 break;
         }
     }
 }
}