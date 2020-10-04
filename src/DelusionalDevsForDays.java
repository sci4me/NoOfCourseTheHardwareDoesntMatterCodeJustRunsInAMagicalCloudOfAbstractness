import java.util.concurrent.ThreadLocalRandom;

public class DelusionalDevsForDays {
    public static void main(String[] args) {
        int N = 10000;

        int[][] data = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                data[i][j] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }

        long sum_a = 0, sum_b = 0;

        long start_a = System.currentTimeMillis();
        {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sum_a += data[i][j];
                }
            }
        }
        long diff_a = System.currentTimeMillis() - start_a;

        long start_b = System.currentTimeMillis();
        {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sum_b += data[j][i];
                }
            }
        }
        long diff_b = System.currentTimeMillis() - start_b;

        System.out.println(sum_a + " " + sum_b);
        System.out.println("a: " + diff_a + " ms");
        System.out.println("b: " + diff_b + " ms");
    }
}