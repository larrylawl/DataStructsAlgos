
/**
 *
 * author	: 
 * matric no: 
 * 
 */

import java.util.*;

public class HelloWorld {

	public static void handleQuery(String logic, int i, int j) {
		int result = 0;
		switch (logic) {
		case "AND":
			result = i == 1 && j == 1 ? 1 : 0;
			break;
		case "OR":
			result = i == 1 || j == 1 ? 1 : 0;
			break;
		}
		System.out.println(result);
	}

	// Logic to handle what is scanned
	public static void main(String[] args) {
		// switch cases for three different methods
		Scanner sc = new Scanner(System.in);
		int method = sc.nextInt();
		switch (method) {
		case 1:
			int N = sc.nextInt();
			for (int x = 0; x < N; x++) {
				String logic = sc.next();
				int i = sc.nextInt();
				int j = sc.nextInt();
				HelloWorld.handleQuery(logic, i, j);
			}
			break;
		case 2:
			while (sc.hasNext("(OR)|(AND)")) {
				String logic = sc.next();
				int i = sc.nextInt();
				int j = sc.nextInt();
				HelloWorld.handleQuery(logic, i, j);
			}
			break;
		case 3:
			while (sc.hasNext()) {
				String logic = sc.next();
				int i = sc.nextInt();
				int j = sc.nextInt();
				HelloWorld.handleQuery(logic, i, j);
			}
		}
		sc.close();
	}
}
