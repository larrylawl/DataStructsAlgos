import java.util.*;

class CompareStrings {

    boolean isStrictlySmaller(String i, String j) {
        boolean result = false;
        char[] iSortedCharArray = i.toCharArray();
        char[] jSortedCharArray = j.toCharArray();

        Arrays.sort(i.toCharArray());
        Arrays.sort(j.toCharArray());

        int iLength = iSortedCharArray.length;
        int jLength = jSortedCharArray.length;
        int limitingLength = iLength < jLength ? iLength : jLength;

        int index = 0;
        while (index <= limitingLength - 1) {
            char iCurrentChar = iSortedCharArray[index];
            char jCurrentChar = jSortedCharArray[index];
            if (iCurrentChar < jCurrentChar) {
                result = true;
                break;
            }
            index++;
        }

        return result;
    }

    void run() {
        String firstString = "abcd aabc bd";
        String secondString = "aaa aa";
        ArrayList<Integer> result = new ArrayList<>();

        String[] firstStringArr = firstString.split(" ");
        String[] secondStringArr = secondString.split(" ");

        for (String second: secondStringArr) {
            int counter = 0;
            for (String first: firstStringArr) {
                if (isStrictlySmaller(second, first)) {
                    counter++;
                }
            }
            result.add(counter);
        }

        result.forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {
        CompareStrings cs = new CompareStrings();
        cs.run();
    }
}
