package brute_force.checker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] coord = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(coord[0]);
            arr[i][1] = Integer.parseInt(coord[1]);
        }

        System.out.println(Arrays.toString(arr));
    }
}
