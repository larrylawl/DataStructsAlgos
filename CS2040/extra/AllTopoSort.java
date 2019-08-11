class AllTopoSort {

    private ArrayList<ArrayList<Edge>> ajl = new ArrayList<>();
    private int[] indeg;
    private int[] path;
    private ArrayList<Integer> topoSort = new ArrayList();

    private class Edge {
        int current;
        int next;

        Edge(int current; int next) {
            this.current = current;
            this.next = next;
        }
    }

    private void run() {
        
        Scanner sc = new Scanner(System.in);
        
        int numVertices = sc.nextInt();
        int numEdges = sc.nextInt();

        for (int i = 0; i < numEdges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            this.ajl.get(x).add(new Edge(x, y));
            this.ajl.get(y).add(new Edge(y, x));
        }

        // initialize variables here
        indeg = new int[numVertices];
        path = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            indeg[i] = 0;
            path[i] = -1;
        }

        for (ArrayList<Edge> l : this.ajl) {
            for (Edge e : l) {
                int vertex = e.next;
                indeg[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            
            // each time before a vertex is polled, create a new topo list for
            // each vertex inside the current queue, and add the polled vertex
            // inside the new list. Each vertex corresponds to a new topo order
            int vertex = queue.poll();
            topoSort.add(vertex);

            for (Edge e : this.ajl.get(vertex)) {
                int neighbour = e.next;
                if (indeg[neighbour] == 0) {
                    path[neighbour] = vertex;
                    queue.offer(neighbour);
                } else {
                    indeg[neighbour]--;
                }
            }

        }

    }

    public static void main(String[] args) {

        AllTopoSort allSorts = new AllTopoSort();
        allSorts.run();

    }

}
