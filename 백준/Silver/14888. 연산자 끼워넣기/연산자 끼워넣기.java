import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

    static int N, min_val, max_val;
    static int[] operands;
    static int[] operators;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        operands = new int[N];
        operators = new int[4];
        min_val = Integer.MAX_VALUE;
        max_val = Integer.MIN_VALUE;

        for (int i = 0; i < N; i ++){
            operands[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < 4; i ++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
// 최소, 최대 초기화 안했음
        recur(1, operands[0]);
        System.out.println(max_val);
        System.out.println(min_val);

    }


    static void recur(int idx, int curresult){
        // idx == 1부터 시작하기

        if( idx == N ){
            min_val = Math.min(min_val, curresult);
            max_val = Math.max(max_val, curresult);
            return;
        }

        for (int i = 0; i < 4 ; i ++){
            if (operators[i] > 0){
                operators[i]--;
                if (i == 0) recur(idx + 1, curresult + operands[idx]);
                else if (i == 1) recur(idx + 1, curresult - operands[idx]);
                else if (i == 2) recur(idx + 1, curresult * operands[idx]);
                else{
                    if (curresult < 0) {
                        int processedResult = curresult * -1;
                        recur(idx + 1, processedResult / operands[idx] * -1);
                    } else recur(idx + 1, curresult / operands[idx]);
                }
                operators[i]++;
            }
        }
    }
}
