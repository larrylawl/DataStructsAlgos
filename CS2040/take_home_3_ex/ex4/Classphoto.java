/*
 * Name       : Chen Yuan Bo
 * Matric No. : A0183156A
 * Plab Acct. : -
 */
import java.util.*;

public class Classphoto {
	
    private class Student {
        String name;
        int height;
        int order;

        Student(String name, int height, int order) {
            this.name = name;
            this.height = height;
            this.order = order;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

	private void run() {

        Scanner sc = new Scanner(System.in);
        TreeSet<Student> line = new TreeSet<>((s1, s2) -> {
            int diff = s1.height - s2.height;
            if (diff == 0) return s2.order - s1.order;
            return diff;
        });

        line.add(new Student("Rar", 0, -1));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Student s = new Student(sc.next(), sc.nextInt(), i);
            System.out.println(line.lower(s));
            line.add(s);
        }

        ArrayList<Student> output = new ArrayList<>(line);
        for (int i = 0; i < output.size(); i++) {
            if (i == output.size() - 1) {
                System.out.println(output.get(i));
            } else {
                System.out.print(output.get(i) + " ");
            }
        }
		
	}
	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}
