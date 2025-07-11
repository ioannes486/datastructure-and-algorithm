
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] hint;
    private static int count = 0;

    private static void numberBaseball(int N, int[][] arr) {
        recur(0,100);
        System.out.println(count);
    }

    private static void recur(int hint_idx, int number) {
        if (hint_idx==N) {
            count++;
            recur(0,number+1);
            return;
        }

        if (number == 1000) return;

        if (checker(hint_idx, number)) {
            recur(hint_idx+1, number);
        } else {
            recur(0, number + 1);
        }

    }

    private static boolean checker(int idx, int number) {
        int _number = hint[idx][0];
        int _strike = hint[idx][1];
        int _ball = hint[idx][2];

        int strike = 0;
        int ball = 0;

        // 힌트의 숫자 분할
        int _A = _number/100;
        int _B = (_number-(_A*100)) / 10;
        int _C = _number%10;

        // 판별할 숫자 분할
        int A = number / 100;
        int B = (number-(A*100)) / 10;
        int C = number % 10;

        // abc는 1~9의 자연수임
        if(A==0||B==0||C==0) return false;
        if(A==B||B==C||C==A) return false;

        if (A==_A) strike++;
        if (B==_B) strike++;
        if (C==_C) strike++;

        if(A==_B || A==_C) ball++;
        if(B==_C || B==_A) ball++;
        if(C==_A || C==_B) ball++;

        return strike == _strike && ball == _ball;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hint = new int[N][3];

        for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                hint[i][0] = Integer.parseInt(st.nextToken());
                hint[i][1] = Integer.parseInt(st.nextToken());
                hint[i][2] = Integer.parseInt(st.nextToken());
        }

         numberBaseball(N, hint);

    }
}
