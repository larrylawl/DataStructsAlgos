class TSum {

    private void run() {
        // Idea:
        // Using 2 nested for loops, get all possible combinations of the first
        // 2 lists and the second 2 lists. Name them L1 & L2. Complexity = 2N^2.
        // Store L2 inside a HashSet. Iterate through L1 and find its remaining
        // component in the HashSet. If there output "YES" else "NO".
        // Complexity = N^2 + 1. Total complexity = O(N^2).
        //
        // For extended question:
        // if 1, use TreeSet. Complexity = O(logN)
        // if 2, use TreeSet for 1, iterate other. Complexity = O(NlogN)
        // if 3, use TreeSet for 1, iterate other 2. Complexity = O(N^2logN)
        // if 4, use TreeSet for N^2, iterate N^2. Complexity = O(N^2logN) as
        // well
    }

    public static void main(String[] args) {

        TSum tsum = new TSum();
        tsum.run();

    }

}
