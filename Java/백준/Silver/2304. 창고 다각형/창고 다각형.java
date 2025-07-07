
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr =  new int[1000];
        int[] dp1 =  new int[1000];

        // 입출력받기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }

        // dp 초기화
        dp1[0] = arr[0];

        int max = 0;
        // 왼쪽에서 오기
        for(int j=1; j<1000; j++){
            dp1[j] = Math.max(dp1[j-1], arr[j]);
            max = dp1[j];
        }

        // 오른쪽에서 오기
        dp1[999] = arr[999];
        for(int k=998; k>=0; k--){
            if(arr[k]==max) break;
            dp1[k] = Math.max(dp1[k+1], arr[k]);
        }
        int answer = 0;
        for(int h=0; h<1000; h++){
            answer += dp1[h];
        }

        System.out.println(answer);
    }
}
