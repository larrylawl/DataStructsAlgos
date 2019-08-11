/**
 * Name         : Chen Yuan Bo
 * Matric. No   : A0183156A
 * PLab Acct.   : -
 */

import java.util.*;

public class Boxes {

    // helper class
    private class Cat {
        int x;
        int y;

        Cat(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cat)) {
                return false;
            }
            Cat c = (Cat) o;
            return this.x == c.getX() && this.y == c.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

	private void run() {
        
        // reading in inputs
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        HashSet<Cat> box = new HashSet<>();

        // creating two additional hashsets to facillitate "ROW" and
        // "COL" commands
        HashSet<Integer> storeX = new HashSet<>();
        HashSet<Integer> storeY = new HashSet<>();

        for (int i = 0; i < q; i++){
            String command = sc.next();
            switch (command) {
                case "SIT": {
                    // records that there is a cat sitting at x,y
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    box.add(new Cat(x, y));
                    if (!storeX.contains(x)) {
                        storeX.add(x);
                    }
                    if (!storeY.contains(y)) {
                        storeY.add(y);
                    }
                    break;
                }
                case "BOX": {
                    // checks if there is cat at x,y
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    System.out.println(box.contains(new Cat(x, y)) ? "Y"
                    : "N");
                    break;
                }
                case "ROW": {
                    // checks if there is cat sitting in row x
                    int x = sc.nextInt();

                    System.out.println(storeX.contains(x) ? "Y" : "N");
                    break;
                }
                default: {
                    // checks if there is cat sitting in col y
                    int y = sc.nextInt();

                    System.out.println(storeY.contains(y) ? "Y" : "N");
                    break;
                }
            }
        }

	}

	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}
