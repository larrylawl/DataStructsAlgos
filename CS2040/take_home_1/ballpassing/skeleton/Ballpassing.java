/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Ballpassing {
	private void run() {
		
        
        // initialise linkedlist, size  
        LinkedList<String> circle = new LinkedList<String>();
        int size;

        Scanner sc = new Scanner(System.in);

        // read input and create initial circle
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            String name = sc.next();
            circle.addLast(name);
        }

        // instantiating an iterator, setting it to 0, calling next()
        // so that remove() can be called if the first event is leave
        int numOfEvents = sc.nextInt();
        ListIterator<String> circleIterator = circle.listIterator(0);
        circleIterator.next();
        
        for (int i = 0; i < numOfEvents; i++) {
            String event = sc.next();
            

            if (event.equals("NEXT")) {
                
                if (!circleIterator.hasNext()) {
                    circleIterator = circle.listIterator(0);
                }

                System.out.println(circleIterator.next());

            } else if (event.equals("JOIN")) {
                
                if (!circleIterator.hasNext()) {
                    circleIterator = circle.listIterator(0);
                }

                String newName = sc.next();
                circleIterator.add(newName);

                // add() adds the new element behind the implicit cursor
                // so a previous() is needed in order to call the new element with next in this case
                circleIterator.previous();

                System.out.println(circleIterator.next());

            } else {
                
                // remove() called first since it is reliant on previously called next() or previous() methods
                circleIterator.remove();

                if (!circleIterator.hasNext()){
                    circleIterator = circle.listIterator(0);
                }

                System.out.println(circleIterator.next());

            }
        }
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
