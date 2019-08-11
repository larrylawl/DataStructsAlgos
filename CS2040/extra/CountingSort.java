import java.util.*;

class CountingSort {

    private void countingSort(int[] arr) {

        int[] count = new int[10];

        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int num = 0; num < arr.length; num++) {
            count[arr[num]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        // loop through the elements of input array and put them in their right
        // position
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }

    }

    private void run() {
    
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> unsorted = new ArrayList<>();

        while (sc.hasNext()) {
            unsorted.add(sc.nextInt());
        }
        
        int[] sorted = new int[unsorted.size()];

        for (int i = 0; i < unsorted.size(); i++) {
            sorted[i] = unsorted.get(i);
        }

        countingSort(sorted);

        System.out.println("Sorted array: " + Arrays.toString(sorted));

    }

    public static void main(String[] args) {

        CountingSort prog = new CountingSort();
        prog.run();

    }

}
