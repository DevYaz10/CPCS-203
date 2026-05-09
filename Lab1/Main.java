public class Main {
    public static void main(String[] args) {
        String[] key = { "D", "B", "D", "C", "C", "D", };

        String[][] studentAnswers = {
                { "A", "B", "A", "C", "C", "D", },
                { "D", "B", "A", "B", "C", "A", },
                { "E", "D", "D", "A", "C", "B", },
                { "C", "B", "A", "E", "D", "C", }
        };

        for (int i = 0; i < studentAnswers.length; i++) {
            int score = 0;
            for (int j = 0; j < studentAnswers[i].length; j++) {
                if (studentAnswers[i][j].equals(key[j])) {
                    score++;
                }
            }
            System.out.printf("Strudent's %d's correct count is %d out of 6%n", studentAnswers.length, score);
        }
    }
}
