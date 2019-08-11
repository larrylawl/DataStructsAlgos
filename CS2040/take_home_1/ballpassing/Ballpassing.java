
/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Ballpassing {
    // missing usage of size to reset linkedlist

    private void run() {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> circle = new LinkedList<>();
        int n = sc.nextInt();

        // Append students to linked list
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            circle.add(s);
        }

        int q = sc.nextInt();
        ListIterator<String> li = circle.listIterator(0);
        // initialise
        li.next();
        for (int i = 0; i < q; i++) {
            // Switch cases for different commands
            String e = sc.next();
            switch (e) {
            case "NEXT":
                System.out.println(li.next());
                break;
            case "JOIN":
                String s = sc.next();
                System.out.println(s);
                li.add(s);
                break;
            case "LEAVE":
                li.remove();
                System.out.println(li.next());
                break;
            }
        }
    }

    public static void main(String[] args) {
        Ballpassing newBallpassing = new Ballpassing();
        newBallpassing.run();
    }
}
