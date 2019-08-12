/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

// MergeSort

private void mergeSort(int[] array, int start, int end) {

    // if start == end, no need to sort array of 1 element
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, mid, start, end);
    }

}

private void merge(int[] arr, int mid, int start, int end) {

    // temporary array for storage
    int[] temp = new int[end-start+1];

    int left = start; int right = mid + 1; int ptr = start;

    // while the pointers are still in range of the arrays
    while (left <= mid && right <= end) {
        if (arr[left] <= arr[right]) {
            temp[ptr++] = arr[left++];
        } else {
            temp[ptr++] = arr[right++];
        }
    }

    // copying the remaining values into the temp array. only one of the two
    // loops below will execute
    while (left <= mid) temp[ptr++] = arr[left++];
    while (right <= end) temp[ptr++] = arr[right++];

    // copying the values over
    for (int i = 0; i < temp.length; i++) {
        arr[start + i] = temp[i];
    }

}


// QuickSort

private void quickSort(int[] arr, int start, int end) {

    if (start < end) {
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot+1, end);
    }
}

private int partition(int[] arr, int start, int end) {

    int pivot = arr[start];
    int pivotIndex = start;
    // for loop to loop through every single element
    for (int ptr = start+1; ptr < end+1; ptr++) {
        if (arr[ptr] <= pivot) {
            pivotIndex++;
            swap(arr, ptr, pivotIndex);
        } else {}
    }

    // put the pivot into its right place
    swap(arr, start, pivotIndex);
    return pivotIndex;

}

private void swap(int[] arr, i, j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


// Radix sort

private void radixSort(int[] arr, int n, int d) {

    // start with digit in the least significant position
    for (int exp = 1; exp <= d; exp++) {
        countingSort(arr, exp);
    }

}

private void countingSort(int[] arr, int exp) {

    int[] count = new int[10];

    for (int i = 0; i < count.length; i++) {
        count[i] = 0;
    }

    for (int i = 0; i < arr.length; i++) {
        count[(int)(arr[i] / Math.pow(10, exp - 1)) % 10]++;
    }

    for (int i = 1; i < count.length; i++) {
        count[i] += count[i-1];
    }

    // loop through the elements of input array and put them in their right
    // position. operate in reverse order to make it stable
    int[] output = new int[arr.length];
    for (int i = arr.length-1; i >= 0; i--) {
        output[count[(int)(arr[i] / Math.pow(10, exp - 1)) % 10] - 1] = arr[i];
        count[(int)(arr[i] / Math.pow(10, exp - 1)) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
        arr[i] = output[i];
    }

}


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
    int current;
    int next;
    int weight;

    Edge(int current, int next, int weight) {
        this.current = current;
        this.next = next;
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
        int vertex = frontier.poll();
        for (Edge e : this.ajl.get(vertex)) {
            int neighbour = e.next;
            if (visited[neighbour]) continue;
            visited[neighbour] = true;
            path[neighbour] = vertex;
            // distanceFromOne[neighbour] = distanceFromOne[v] + e.weight;
            frontier.offer(Integer.valueOf(neighbour));
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

    // for every neighbour of the current vertex
    for (Edge e : this.ajl.get(vertex)) {
        int neighbour = e.next;
        if (this.visited[neighbour]) continue;
        // distanceFromOne[neighbour] = distanceFromOne[v] + e.weight;
        this.path[neighbour] = vertex;
        dfs(neighbour)
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
        backtrack(p[source]);
        System.out.println(p[source]);
    }
}

//Reachability
private boolean reachable(int v) {
    bfs(s); // or dfs
    return visited[v];
}


/* 
 * Topological Sort (DFS)
 */

private ArrayList<Integer> topoSort = new ArrayList<>();
private boolean[] visited = new boolean[n + 1];
private int[] path = new int[n + 1];

private void topoDFS (int vertex) {
    this.visited[vertex] = true;

    for (Edge e : this.ajl.get(vertex)) {
        int neighbour = e.next;

        if (this.visited[neighbour]) continue;

        this.path[neighbour] = vertex;
        dfs(neighbour)
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
        topoDFS(i);
    }
}

// reverse the topological sort to get the correct order
Collections.reverse(topoSort);

for (int v : topoSort) {
    System.out.println(v);
}


/*
 * Topological Sort (BFS a.k.a. Khan's Algo)
 */

ArrayList<Integer> vertices = new ArrayList<>();
ArrayList<ArrayList<Edge>> ajl = new ArrayList<>();
ArrayList<Integer> topoSort = new ArrayList<>();
int[] indeg = new int[vertices.size()];
int[] path = new int[vertices.size()];
Queue<Integer> queue = new LinkedList<>();

// initializing indegree & path array
for (Integer v : vertices) {
    indeg[v] = 0;
    p[v] = -1;
}

// Get the indegree of all vertices by looking through all edges
for (ArrayList<Edge> l : this.ajl) {
    for (Edge e : l) {
        indeg[e.next]++;
    }
}

// add vertices with indegree == 0 inside the queue
for (Integer v : vertices) {
    if (indeg[v] == 0) {
        queue.offer(v);
    }
}

while (!queue.isEmpty()) {
    int vertex = queue.poll();
    topoSort.add(vertex);

    for (Edge e : this.ajl.get(vertex)) {
        int neighbour = e.next;

        if (indeg[neighbour] > 0) indeg[neighbour]--;
        if (indeg[neighbour] == 0) {
            path[neighbour] = vertex;
            queue.offer(neighbour);
        }
    }
}

System.out.println(topoSort.toString());


//SSSP (essentially BFS since graph is unweighted)
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
        int vertex = queue.poll();
        for (Edge e: this.ajl.get(vertex)) {
            int neighbour = e.next;
            if (D[neighbour] == INF) { // i.e. not visited before
                D[neighbour] = D[vertex] + 1; // because to use this algo, the graph has to be unweighted
                p[neighbour] = vertex;
                queue.offer(neighbour);
            }
        }
    }
}

//Cyclic (NEED TO CHANGE!)
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


/*
 * Bellman Ford
 * 
 * General Idea: relax all edges for a total of v - 1 times
 * Implementation: for v in vertices, for all e in edges, relax(e)
 * Complexity: O(VE)
 *
 */

for (int i = 0; i < V - 1; i++) { // V-1 times
    for (int vertex = 0; vertex < V; vertex++) { // two loops below is O(E)
        for (Edge e : this.ajl.get(vertex)) {
            // relax function
            if (D[e.next] != INF && D[e.next] > D[e.current] + e.weight) {
                D[e.next] = D[e.current] + e.weight;
                path[e.next] = e.current;
            }
        }
    }
}

// Side effect of Bellman Ford: can check negative weight cycle if D[v] fails to
// converge after running the algorithm

hasNegativeCycles = false;
for (int vertex = 0; vertex < V; vertex++) {
    for (Edge e : this.ajl.get(vertex)) {
        if (D[e.next] != INF && D[e.next] > D[e.current] + e.weight) {
            hasNegativeCycles = true;
            break;
        }
    }
}

// One-pass Bellman Ford
// if graph is weighted, and a DAG, can get shortest path by first getting the
// topological ordering of the graph and subsequently running Bellman Ford once
// (i.e. relaxing the edges of vertices in topological order)

