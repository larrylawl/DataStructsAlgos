
/**
 * author	:
 * matric no:
 */

import java.util.*;

public class HelloWorld {

    public int handleQuery(String logic, int firstOperand, int secondOperand) {
        int result = 999;
        switch (logic) {
        case "AND":
            if (firstOperand == 1 && secondOperand == 1) {
                result = 1;
            } else {
                result = 0;
            }
            break;
        case "OR":
            if (firstOperand == 0 && secondOperand == 0) {
                result = 0;
            } else {
                result = 1;
            }
            break;
        }
        return result;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int parse = sc.nextInt();
        switch (parse) {
        case 1:
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String logic = sc.next();
                int firstOperand = sc.nextInt();
                int secondOperand = sc.nextInt();
                int result = handleQuery(logic, firstOperand, secondOperand);
                System.out.println(result);
            }
            break;
        case 2:
            while (sc.hasNext("AND|OR")) {
                String logic = sc.next();
                int firstOperand = sc.nextInt();
                int secondOperand = sc.nextInt();
                int result = handleQuery(logic, firstOperand, secondOperand);
                System.out.println(result);
            }
            break;
        case 3:
            while (sc.hasNext()) {
                String logic = sc.next();
                int firstOperand = sc.nextInt();
                int secondOperand = sc.nextInt();
                int result = handleQuery(logic, firstOperand, secondOperand);
                System.out.println(result);
            }
            break;
        // scan 1, 2, and 3
        // for each case, read differently
        // for 1, read n lines
        // for 2, while the next value is not special character, continue reading
        // for 3, read until no more line
        // funciton to handle logic
        }
        sc.close();
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.run();
    }
}
