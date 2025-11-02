import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] book = new int[N];
        for (int i = 0; i < N; i++) {
            book[i] = Integer.parseInt(br.readLine());
        }
        int max = N;
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (book[i] == max) {
                max--;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }
}
