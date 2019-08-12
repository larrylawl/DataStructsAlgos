/**
 *
 * author	: [Larry Law]
 * matric no: []
 * 
 */

import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {

		// declare the necessary variables
        String a, b;
        int diff;

		// declare a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

		// read input and process them accordingly
        a = scanner.next();
        b = scanner.next();

        diff = a.compareToIgnoreCase(b);

        if (diff == 0) {
            System.out.println(diff);
        } else if (diff < 0) {
            System.out.println(1);
        } else {
            System.out.println(2); 
        }
	}
}
