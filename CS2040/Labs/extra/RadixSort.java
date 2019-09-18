import java.util.*;

class RadixSort {

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

        radixSort(sorted, sorted.length, 3);

        System.out.println("Sorted array: " + Arrays.toString(sorted));

    }

    public static void main(String[] args) {

        RadixSort radix = new RadixSort();
        radix.run();

    }

}
