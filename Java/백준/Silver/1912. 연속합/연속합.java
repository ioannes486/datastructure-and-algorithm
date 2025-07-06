
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        prefix[0] = arr[0];
        int answer = arr[0];

        for(int j=1; j<N; j++){
                prefix[j] = Math.max(prefix[j-1] + arr[j], arr[j]);
                answer = Math.max(answer, prefix[j]);
        }

         System.out.println(answer);

    }
}
