/*
 * Name       : Chen Yuan Bo
 * Matric No. : A0183156A
 * Plab Acct. : -
 */
import java.util.*;

public class Height {
    
    private ArrayList<ArrayList<Edge>> ajl = new ArrayList<>();
    private long[] distanceFromOne;

    private class Edge {
        int from;
        int to;
        int weight;
        
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    private void bfs(int vertex, int n) {

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> frontier = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }

        visited[1] = true;
        frontier.offer(Integer.valueOf(1));
        distanceFromOne[1] = 0;

        while (!frontier.isEmpty()) {
            int v = frontier.poll();
            for (Edge e : this.ajl.get(v)) {
                if (visited[e.to] == true) continue;
                visited[e.to] = true;
                distanceFromOne[e.to] = distanceFromOne[v] + e.weight;
                frontier.offer(Integer.valueOf(e.to));
            }
        }

    }

    private void run() {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        distanceFromOne = new long[n + 1];

        for (int i = 0; i < n + 1 ; i++) {
            this.ajl.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = sc.nextInt();
            this.ajl.get(x).add(new Edge(x, y, distance));
            this.ajl.get(y).add(new Edge(y, x, -1 * distance));
        }

        bfs(1, n);
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(distanceFromOne[y] - distanceFromOne[x]);
        }

    }

    public static void main(String[] args) {
        Height newHeight = new Height();
        newHeight.run();
    }
}
