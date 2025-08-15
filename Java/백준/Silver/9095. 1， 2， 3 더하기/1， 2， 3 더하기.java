
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            result = 0;
            recur(0);
            System.out.println(result);
        }
    }

    private static void recur(int sum) {

        if (sum == N ) {
            result++;
            return;
        }

        if (sum > N) return;
        
        recur(sum+1);
        recur(sum+2);
        recur(sum+3);
    }
}
