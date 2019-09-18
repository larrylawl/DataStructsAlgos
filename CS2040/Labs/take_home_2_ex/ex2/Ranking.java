/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Ranking {

    private class Student {

        private String name;
        private int score;
        private int rank;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        int getScore() {
            return this.score;
        }

        void setRank(int r) {
            this.rank = r;
        }

        @Override
        public String toString() {
            return String.format("%s %d", this.name, this.rank);
        }

    }

	private void run() {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> originalOrder = new ArrayList<>();
        PriorityQueue<Student> ranking = new PriorityQueue<>((s1, s2) -> s2.getScore() - s1.getScore());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Student s = new Student(sc.next(), sc.nextInt());
            originalOrder.add(s);
            ranking.offer(s);
        }

        int size = ranking.size();
        int rank = 1;
        int currentScore = ranking.peek().getScore();

        for (int i = 0; i < size; i++) {
            Student currentS = ranking.poll();
            if (currentS.getScore() < currentScore) {
                rank = i + 1;
                currentS.setRank(rank);
                currentScore = currentS.getScore();
            } else {
                currentS.setRank(rank);
            }
        }

        for (Student student : originalOrder) {
            System.out.println(student);
        }

	}

	public static void main(String[] args) {
		Ranking newRanking = new Ranking();
		newRanking.run();
	}
}

