/*
 * Name       : Chen Yuan Bo
 * Matric No. : A0183156A
 * Plab Acct. : -
 */
import java.util.*;

public class Brackets {
    private void run() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // for loop to go through each test case
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            if (l % 2 != 0) {
                System.out.println("Invalid");
                sc.next();
                continue;
            }

            // creating a stack to store and check brackets
            Stack<Character> stack = new Stack<>();
            boolean valid = true;
            String brackets = sc.next();

            // for loop to look through each bracket
            for (int j = 0; j < l; j++) {

                char bracket = brackets.charAt(j);
                switch (bracket) {
                    
                    case '(':
                    case '[':
                    case '{':
                        stack.push(bracket);
                        break;
                    case ')': {
                        if (stack.empty()) { valid = false; break; }

                        char ch = stack.pop();
                        if (ch != '(') valid = false;
                        break;
                    }
                    case ']': {
                        if (stack.empty()) { valid = false; break; }

                        char ch = stack.pop();
                        if (ch != '[') valid = false;
                        break;
                    }
                    case '}': {
                        if (stack.empty()) { valid = false; break; }

                        char ch = stack.pop();
                        if (ch != '{') valid = false;
                        break;
                    }

                }

                // if already invalid, break out of for loop
                if (!valid) break;
                
            }
            
            if (stack.empty() && valid) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }

        }

    }

    public static void main(String[] args) {
        Brackets newBrackets = new Brackets();
        newBrackets.run();
    }
}
