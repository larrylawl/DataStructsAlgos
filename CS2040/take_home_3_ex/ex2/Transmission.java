/*
 * Name       : Larry Law
 * Matric No. : 
 * Plab Acct. : -
 */
import java.util.*;

public class Transmission {
    private void run() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        TreeSet<Integer> sleepingCats = new TreeSet<>();

        for (int i = 0; i < q; i++) {
            String command = sc.next();

            switch (command) {
                case "SLEEP": {
                    int cat = sc.nextInt();
                    sleepingCats.add(cat);
                    break;
                }
                case "WAKE": {
                    int cat = sc.nextInt();
                    sleepingCats.remove(cat);
                    break;
                }
                default: {
                    int first = sc.nextInt();
                    int last = sc.nextInt();

                    Optional<Integer> cat = Optional.ofNullable(sleepingCats.lower(last + 1));
                    if (!cat.isPresent()) {
                        System.out.println("YES");
                    } else if (cat.get() >= first) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }

                    break;
                }
            }
        }

    }
    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}
