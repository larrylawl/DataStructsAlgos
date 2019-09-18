
/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */
import java.time.Year;

import java.util.*;

// helper class
class Cat {
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
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Cat) {
            Cat otherCat = (Cat) obj;
            result = otherCat.getX() == this.getX() && otherCat.getY() == this.getY();
        } else {
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

class Boxes {
    private void run() {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Cat> cats = new HashSet<>();
        String result;
        int Q = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String command = sc.next();
            switch (command) {
            // hashset for row and column and cats
            // sit -> add into cats
            case "SIT":
                int row = sc.nextInt();
                int col = sc.nextInt();
                cats.add(new Cat(row, col));
                rows.add(row);
                cols.add(col);
                break;
            case "BOX":
                result = cats.contains(new Cat(sc.nextInt(), sc.nextInt())) ? "Y" : "N";
                System.out.println(result);
                break;
            case "ROW":
                result = rows.contains(sc.nextInt()) ? "Y" : "N";
                System.out.println(result);
                break;
            case "COL":
                result = cols.contains(sc.nextInt()) ? "Y" : "N";
                System.out.println(result);
                break;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        Boxes newBoxes = new Boxes();
        newBoxes.run();
    }
}
