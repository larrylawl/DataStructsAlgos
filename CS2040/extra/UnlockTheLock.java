import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class UnlockTheLock {

    private int[] D;
    private int[] path;
    private ArrayList<Integer> neighbours = new ArrayList<>();
    private int u;
    private int l;
    private int r;

    private static int inf = 1000000000;

    private void SSSP(int source) {
        
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        D[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Integer edge : neighbours) {
                int neighbour = vertex + edge;
                if (neighbour > 9999) {
                    neighbour %= 10000; 
                }
                if (D[neighbour] == inf) {
                    D[neighbour] = D[vertex] + 1;
                    path[neighbour] = vertex;
                    queue.offer(neighbour);
                }
            }
        }

    }

    private String pathTaken(int vertex) {
        if (path[vertex] == -1) {
            return String.valueOf(vertex);
        } else {
            return pathTaken(path[vertex]) + String.format("-> %d", vertex);
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);

        u = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        
        for (int i = 0; i < r; i++) {
            neighbours.add(sc.nextInt());
        }

        D = new int[10000];
        path = new int[10000];

        for (int i = 0; i < 10000; i++) {
            D[i] = inf;
            path[i] = -1;
        }

        SSSP(l);

        System.out.println("Minimum number of button presses is: " + D[this.u]);
        System.out.println(pathTaken(this.u));
    }

    public static void main(String[] args) {
        
        UnlockTheLock file = new UnlockTheLock();
        file.run();

    }

}
