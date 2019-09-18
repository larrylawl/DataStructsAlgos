/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

// add ranking as attribute
// update ranking with loop
// print

class Student {
    // Implement comparable
    String name;
    int score;
    int rank;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // @Override
    // public int compareTo(Student o) {
    //     return o.score - this.score;
    // }

    @Override
    public String toString() {
        return String.format("%s %d", name, rank);
    }
}

public class Ranking {

	private void run() {
        // Input students to array list
        Scanner sc = new Scanner(System.in);
        List<Student> sorted = new ArrayList<>();
        List<Student> original = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            Student s = new Student(name, score);
            sorted.add(s);
            original.add(s);
        }
        // Sort
        Collections.sort(sorted, (x, y) -> y.score - x.score);

        // sets rank
        for (int i = 0; i < sorted.size(); i++) {
            // first guy -> set rank
            Student current = sorted.get(i);
            if (i == 0) {
                current.rank = i + 1;
            } else {
                Student previous = sorted.get(i - 1);
                if (current.score == previous.score) {
                    current.rank = previous.rank;
                } else {
                    current.rank = i + 1;
                }
            }
        }

        original.forEach(student -> System.out.println(student));
	}

	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}
