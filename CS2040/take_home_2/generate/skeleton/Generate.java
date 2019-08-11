/**
* Name         : Chen Yuan Bo
* Matric. No   : A0183156A
* PLab Acct.   : -
*/

import java.util.*;

// NChooseK
private void nChoosek(ArrayList<Integer> array, int k, ArrayList<ArrayList<Integer>> result) {

    // take the array, look at each element
    // either want it, or don't want it
    if (k == 0) {
        ArrayList<Integer> empty = new ArrayList<>();
        result.add(empty);
    } else if (array.isEmpty()) {
    } else {
        int first = array.get(0);
        array.remove(0);
        nChoosek(array, k - 1, result);
        for (ArrayList<Integer> arr: result) {
            arr.add(first);
        }
        nChoosek(array, k, result);
    }

}

// String permutation and subsequences
private ArrayList<String> permutations = new ArrayList<>();

private void permutate(String result, String input) {

    if (input.isEmpty()) {
        this.permutations.add(result);
    } else {
        for (int i = 0; i < input.length(); i++) {
            char ele = input.charAt(i);
            String newStr = input.substring(0, i) + input.substring(i+1);
            permutate(result + ele, newStr);
        }
    }

}

private ArrayList<String> subsequences = new ArrayList<>();

private void subsequence(String result, String input) {

    if (input.isEmpty()) {
        if (result.isEmpty()) {}
        else {
            this.subsequences.add(result + input);
        }
    } else {
        char ele = input.charAt(0);
        String remainder = input.substring(1);
        subsequence(result + ele, remainder);
        subsequence(result, remainder);
    }

}

// Object list permutations
private ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

private void permutate(ArrayList<Integer> result, ArrayList<Integer> numbers) {
    if (numbers.isEmpty()) {
        this.permutations.add(result);
    } else {
        int size = numbers.size();

        // cycling through each element inside the list of numbers
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
            ArrayList<Integer> newResult = new ArrayList<>(result);

            int ele = newNumbers.remove(i);
            newResult.add(ele);

            permutate(newResult, newNumbers);
        }
    }
}

// Object list subsets
private ArrayList<ArrayList<Rook>> possibleWays = new ArrayList<>();

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

        // recursively calling subsets with and witout element
        subsets(withoutResult, newList);
        subsets(withResult, newList);
    }

}

// Overriding equals & hashCode for hashing
public class User {

    private String name;
    private int age;
    private String passport;

    //getters and setters, constructor

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passport);
    }

}

// Graphs (use recursion to output path)
private ArrayList<ArrayList<Edge>> ajl = new ArrayList<>();
private long[] distanceFromOne;
private int[] path;

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

// For bfs
private void bfs(int vertex, int n) {

    boolean[] visited = new boolean[n + 1];
    Queue<Integer> frontier = new LinkedList<>();

    // this.distanceFromOne = new long[n + 1];
    this.path = new int[n + 1];

    for (int i = 1; i < n + 1; i++) {
        visited[i] = false;
        this.path[i] = -1;
    }

    visited[vertex] = true;
    frontier.offer(Integer.valueOf(vertex));

    // distanceFromOne[1] = 0; MUST run bfs from vertex 1

    while (!frontier.isEmpty()) {
        int u = frontier.poll();
        for (Edge e : this.ajl.get(u)) {
            if (visited[e.to]) continue;
            visited[e.to] = true;
            path[e.to] = u;
            // distanceFromOne[e.to] = distanceFromOne[v] + e.weight;
            frontier.offer(Integer.valueOf(e.to));
        }
    }

}

// For dfs

// Initialize on top
private boolean[] visited = new boolean[n + 1];
// this.distanceFromOne = new long[n + 1];
private int[] path = new int[n + 1];

// run in run() method
for (int i = 1; i < n + 1; i++) {
    this.visited[i] = false;
    this.path[i] = -1;
}

private void dfs(int vertex) {
    this.visited[vertex] = true;

    for (Edge e : this.ajl.get(vertex)) {
        if (this.visited[e.to]) continue;
        // distanceFromOne[e.to] = distanceFromOne[v] + e.weight;
        this.path[e.to] = vertex;
        dfs(e.to)
    }
}

private void run() {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

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

//Count components
int counter = 0;
// initialise visited
for (int v: list of all vertices) {
    if (!visited[v]) {
        counter++;
        dfs(v); // or bfs(v) also can
    }
}

//Backtrack
// assuming p is populated
private void backtrack(int source) {
    if (source != -1) {
        backtrack(p[source])
        System.out.println(p[source]);
    }
}

//Reachability
private boolean reachable(int v) {
    bfs(s); // or dfs
    return visited[v];
}

// Topological Sort
// Initialize on top
private ArrayList<Integer> topoSort = new ArrayList<>();
private boolean[] visited = new boolean[n + 1];
private int[] path = new int[n + 1];

private void topoDFS(int vertex){
    this.visited[vertex]=true;

    for(Edge e:this.ajl.get(vertex)){
        if(this.visited[e.to])continue;
        this.path[e.to]=vertex;
        dfs(e.to)
    }
    topoSort.add(vertex);
}

// run in run() method
for (int i = 1; i < n + 1; i++) {
    this.visited[i] = false;
    this.path[i] = -1;
}

for (int i = 1; i < n + 1; i++) {
    if (!visited[i]) {
        topoDFS(i)
    }
}

Collections.reverse(topoSort);

for (int v : topoSort) {
    System.out.println(v);
}

//SSSP
Queue<Vertex> queue = new LinkedList<>();
List<Vertex> V = new ArrayList<>(); // will contain all vertices

public void SSSP(int source) {
    // initialising
    for (int v: list of all vertices) {
        D[v] = INF; // use 1B to represent INF
        p[v] = -1; // don't know the predecessor yet
    }

    queue.offer(source);
    D[source] = 0; //distance of source from itself = 0

    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (Edge e: this.ajl.get(u)) {
            if (D[e.to] == INF) {
                D[e.to] = D[u] + 1; // because to use this algo, the graph has to be unweighted
                p[e.to] = u;
                queue.offer(e.to);
            }
        }
    }
}

//Cyclic
boolean[] visited = new boolean[n+1]; // assuming 1-base, n = #vertices
//start with parent = -1
public boolean isCyclic(int v, boolean[] visited, int parent) {
    visited[v] = true;
    for (int neighbour: neighbours.get(v)) {
        if (!visited[neighbour]) {
            return isCyclic(neighbour, visited, v);
        } else if (neighbour != parent) {
            return true;
        }
    }
    return false;
}