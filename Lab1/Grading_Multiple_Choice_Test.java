public class Grading_Multiple_Choice_Test {

    public static void main(String[] args) {
        char[] key = { 'D', 'B', 'D', 'C', 'C', 'D' };
        char[][] answers = {
                { 'A', 'B', 'A', 'C', 'C', 'D' },
                { 'D', 'B', 'A', 'B', 'C', 'A' },
                { 'E', 'D', 'D', 'A', 'C', 'B' },
                { 'C', 'B', 'A', 'E', 'D', 'C' },
        };

        for (int i = 0; i < answers.length; i++) {
            int score = 0;
            for (int j = 0; j < answers[i].length; j++)
                if (answers[i][j] == key[j])
                    score++;
            System.out.printf("Student %d's correct count is %d out of 6%n", i, score);
        }
    }
}