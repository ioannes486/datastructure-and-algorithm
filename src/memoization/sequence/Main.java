package memoization.sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[A];
        for (int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int[] prefix = new int[A+1];
        int answer = 0;
        for (int i=0; i<A; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        for(int j=B; j<A+1; j++){
            int number = prefix[j] - prefix[j-B];
            answer = Math.max(answer, number);
        }

        System.out.println(answer);
    }
}
