/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class HelloWorld {
	private void run() {
        Scanner sc = new Scanner(System.in);
        String check = "Hello World";
        String input = sc.nextLine();
        if (check.equals(input)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
	}

	public static void main(String[] args) {
		HelloWorld newHelloWorld = new HelloWorld();
		newHelloWorld.run();
	}
}
