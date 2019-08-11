/*
 * Name       : Chen Yuan Bo
 * Matric No. : A0183156A
 * Plab Acct. : -
 */
import java.util.*;

public class Supplies {
    
    private ArrayList<ArrayList<Edge>> ajl = new ArrayList<>();
    private int[] D;

    private static int inf = 2000000000;

    private class Edge {
        int current;
        int next;
        int weight;

        Edge(int c, int n, int w) {
            this.current = c;
            this.next = n;
            this.weight = w;
        }
    }

    private class Pair {
        int d;
        int v;

        Pair(int distance, int vertex) {
            this.d = distance;
            this.v = vertex;
        }
    }

    private void dijkstra(int source) {
    
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.d - p2.d);

        for (int i = 0; i < this.ajl.size(); i++) {
            D[i] = inf;
        }

        queue.offer(new Pair(0, source));
        D[source] = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = pair.d;
            int vertex = pair.v;
            if (distance == D[vertex]) {
                for (Edge edge : this.ajl.get(vertex)) {
                    int neighbour = edge.next;
                    int weight = edge.weight;
                    if (D[neighbour] > D[vertex] + weight) {
                        D[neighbour] = D[vertex] + weight;
                        queue.offer(new Pair(D[neighbour], neighbour));
                    }
                }
            }
        }

    }
        
    private void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();


        D = new int[n];
        for (int i = 0; i < n; i++) {
            this.ajl.add(new ArrayList<Edge>());
        }

        // adding edges
        for (int i = 0; i < e; i++) {
            int current = sc.nextInt();
            int next = sc.nextInt();
            int weight = sc.nextInt();
            this.ajl.get(current).add(new Edge(current, next, weight));
        }
        
        dijkstra(h);
        
        if (D[t] == inf) {
            System.out.println(-1);
        } else {
            int distance = D[t];
            dijkstra(t);
            if (D[h] == inf) {
                System.out.println(-1);
            } else {
                System.out.println(distance + D[h]);
            }
        }
    }
    public static void main(String[] args) {
        Supplies newSupplies = new Supplies();
        newSupplies.run();
    }
}
