package syntax.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.util.Scanner;

public class UserInputOutputTest {

    //taking input from console is not allowed from junit test
    public static void main(String[] args) {
        System.out.println("enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("user name is "+name);

        System.out.println("enter your name: ");
        name = sc.nextLine();
        System.out.println("user name is "+name);
        sc.close();
    }
}
