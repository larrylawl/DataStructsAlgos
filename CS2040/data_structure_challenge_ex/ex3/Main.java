import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MBST avl = new MBST();

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String command = sc.next();

            switch (command) {
                
                case "I": {
                    avl.insert(sc.nextInt());
                    break;
                }
                default: {
                    System.out.println(avl.getRank(sc.nextInt()));
                    break;
                }

            }
        }

    }

}
