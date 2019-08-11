/**
 * Name         : Chen Yuan Bo
 * Matric. No   : A0183156A
 * PLab Acct.   : -
 */

import java.util.*;

public class Pandachess {

    private ArrayList<ArrayList<Rook>> possibleWays = new ArrayList<>();

    private class Rook {
        int row;
        int col;

        Rook(int r, int c) {
            this.row = r;
            this.col = c;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", this.row, this.col);
        }
    }

    private void subsets(ArrayList<Rook> result, ArrayList<Rook> list) {
        if (list.isEmpty()) {
            ArrayList<Rook> newResult = new ArrayList<>(result);
            this.possibleWays.add(newResult);
        } else {
            ArrayList<Rook> newList = new ArrayList<>(list);
            ArrayList<Rook> newResult = new ArrayList<>(result);

            Rook ele = newList.remove(0);

            ArrayList<Rook> withoutResult = new ArrayList<>(newResult);
            newResult.add(ele);
            ArrayList<Rook> withResult = new ArrayList<>(newResult);

            subsets(withoutResult, newList);
            subsets(withResult, newList);
        }

    }

    /*
    private static void checkValidity(ArrayList<ArrayList<Rook>> ls, int n) {
        
        for (ArrayList<Rook> subls : ls) {
            if (subls.size() == 0 || subls.size() == n) continue;
            
        }

    }
    */

	private void run() {
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        ArrayList<Rook> rooks = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            rooks.add(new Rook(sc.nextInt(), sc.nextInt()));
        }

        subsets(new ArrayList<Rook>(), rooks);
        for (ArrayList<Rook> ls : this.possibleWays) {
            System.out.println(ls.toString());
        }
        //checkValidity(possibleWays, rooks.size());

	}

	public static void main(String[] args) {
		Pandachess newPandachess = new Pandachess();
		newPandachess.run();
	}
}
