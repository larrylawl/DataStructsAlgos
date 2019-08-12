/*
 * Name       : Larry Law
 * Matric No. : 
 * Plab Acct. : -
 */
import java.util.*;

public class PandaIslands {

    private ArrayList<Island> ajl = new ArrayList<>();
    private Pair[] colour;
    private boolean[] visited;

    private class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", this.first, this.second);
        }
    }

    private class Island {

        ArrayList<Integer> bridges;
        int area;

        Island(int area) {
            this.area = area;
            this.bridges = new ArrayList<Integer>();
        }

    }

    private int modifiedBFS(int source) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);

        visited[source] = true;
        colour[source] = new Pair(0, 1);

        Pair minComponentArea = new Pair(0, 0);

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            int c = colour[vertex].first;

            if (c == 1) {
                minComponentArea.first += this.ajl.get(vertex).area;
            } else {
                minComponentArea.second += this.ajl.get(vertex).area;
            }
            
            for (Integer neighbour : this.ajl.get(vertex).bridges) {
                if (!visited[neighbour]) {
                    if (c == 0) colour[neighbour] = new Pair(1, 0);
                    else colour[neighbour] = new Pair(0, 1);
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        if (minComponentArea.first < minComponentArea.second) {
            return minComponentArea.first;
        } else {
            return minComponentArea.second;
        }

    }

    private void run() {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int e = sc.nextInt();

        this.ajl.add(new Island(0)); // dummy island 

        // getting island areas
        for (int i = 0; i < n; i++) {
            this.ajl.add(new Island(sc.nextInt()));
        }
        
        // getting bridges
        for (int i = 0; i < e; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            this.ajl.get(A).bridges.add(B);
            this.ajl.get(B).bridges.add(A);
        }

        // initializing visited array
        colour = new Pair[this.ajl.size()];
        visited = new boolean[this.ajl.size()];

        for (int i = 0; i < visited.length; i++) {
            colour[i] = new Pair(-1, -1);
            visited[i] = false;
        }

        int result = 0;
        int count = 0;

        // running bfs on all nodes that are not visited
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                if (this.ajl.get(i).bridges.isEmpty()) continue;
                result += modifiedBFS(i);
            }
        }
        
        //System.out.println("count: " + count);
        System.out.println(result);

    }
    public static void main(String[] args) {
        PandaIslands newPandaIslands = new PandaIslands();
        newPandaIslands.run();
    }
}
