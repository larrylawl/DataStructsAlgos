/*
 * Name       : Chen Yuan Bo
 * Matric No. : A0183156A
 * Plab Acct. : -
 */
import java.util.*;

public class PandaChess {
	
    ArrayList<ArrayList<Integer>> ajl = new ArrayList<>();
    ArrayList<Integer> topoSort = new ArrayList<>();
    int[] indeg;

    private class Pair {
        boolean isCyclic;
        boolean isUnique;

        Pair(boolean isCyclic, boolean isUnique) {
            this.isCyclic = isCyclic;
            this.isUnique = isUnique;
        }
    }

    private Pair uniqueTopoSort() {
        indeg = new int[this.ajl.size()];
        for (int i = 0; i < indeg.length; i++) {
            indeg[i] = 0;
        }

        for (ArrayList<Integer> list : this.ajl) {
            for (Integer vertex : list) {
                indeg[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < indeg.length; i++) {
            if (indeg[i] == 0) queue.add(i);
        }

        if (queue.isEmpty()) return new Pair(true, false);

        boolean isCyclic = false;
        boolean isUnique = true;
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (!queue.isEmpty()) isUnique = false;
            this.topoSort.add(vertex);
            for (Integer neighbour : this.ajl.get(vertex)) {
                if (indeg[neighbour] > 0) indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            indeg[vertex] = -1;
        }

        for (int i = 1; i < indeg.length; i++) {
            if (indeg[i] != -1) isCyclic = true;;
        }

        return new Pair(isCyclic, isUnique);

    }

	private void run() {
		 
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            this.ajl.add(new ArrayList<Integer>());
        }

        // adding matches to adjacency list
        for (int j = 0; j < m; j++) {
            int winner = sc.nextInt();
            int loser = sc.nextInt();
            this.ajl.get(winner).add(loser);
        }

        Pair p = uniqueTopoSort();

        if (p.isCyclic) {
            System.out.println("No possible ranking.");
        } else if(!p.isUnique) {
            System.out.println("Ranking is not unique.");
        } else {
            for (Integer vertex : this.topoSort) {
                System.out.println(vertex);
            }
        }

	}
	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}
