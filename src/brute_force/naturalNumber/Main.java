package brute_force.naturalNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for (int i=0; i<=N; i++){
            int temp = i;
            int sum = 0;
            while (temp != 0){
                sum += temp % 10;
                temp/=10;
            }
            if (sum + i == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
