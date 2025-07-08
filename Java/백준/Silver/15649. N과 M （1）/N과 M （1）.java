import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
     static int N;
     static int M;
     static ArrayList<Integer> arr = new ArrayList<>();  // 컬렉션 프레임워크와 잘 ArrayList의 메서드를 잘 알아둘 것 List에는 어떤 것들이 있는가?

    static void recur(int number){
        if (number == M){
            // M이면 함수를 종료하므로 숫자 출력은 M-1번 하게 됨 따라서 함수의 최초 실행은 0부터 시작
            // 항상된 for 문
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 자연수 중에서 M개를 고른 수열
        for (int i=1; i<N+1; i++) {
            if(arr.contains(i)) continue;
            arr.add(i);
            recur(number+1); // 재귀함수에 의해 M-1중 for문으로 바뀐다. 오키 그러면 재귀함수는 중첩으로 이해하면 되겠다.
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        recur(0);
    }
}
