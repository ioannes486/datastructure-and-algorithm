package brute_force.simultaneous_equation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가지고 있는 토큰의 개수만큼의 크기를 가지고 있는 배열 생상
        int[] numbers = new int[st.countTokens()];
        int idx = 0;
        while (st.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(st.nextToken());
        }

        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        int d = numbers[3];
        int e = numbers[4];
        int f = numbers[5];

        outerLoop:
        for(int x=-10000; x<=10000; x++){
            for (int y=-10000; y<=10000; y++){
                if(a*x + b*y == c){
                    if(d*x + e*y == f){
                        System.out.printf("%d %d", x, y);
                        break outerLoop;
                    }
                }
            }
        }
    }
}
