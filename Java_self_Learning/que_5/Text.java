
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String str = sc.nextLine();

        int v=0,c=0,s=0;

        for(char ch : str.toCharArray()) {

            if("aeiouAEIOU".indexOf(ch) != -1)
                v++;
            else if(Character.isLetter(ch))
                c++;
            else
                s++;
        }

        System.out.println("Vowels="+v);
        System.out.println("Consonants="+c);
        System.out.println("Special="+s);
    }
}