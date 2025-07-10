import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static int N;
    private static ArrayList<Integer> arr = new ArrayList<>();

    private static int getHansu(int N){
        int count = 0;

        out:
        for (int i=1; i<=N; i++){  //count확인 루프


            // N이하의 수 전체에 대해서
            int mods = i;

            // 각 자리수를 구하고
            while(mods != 0){
                arr.add(mods % 10);
                mods /= 10; //
            }


            if(arr.size() == 1){
                count++;
                arr.clear();
            } else {
                int d = arr.get(1) - arr.get(0);

                // 각 자리수의 공차가 일정한지 확인
                for (int j = 1; j < arr.size(); j++) { // 공차확인 루프

                    // 각 자리수의 루프를 도는 도중 공차가 다른 수열이 있다면
                    if(d != arr.get(j) - arr.get(j - 1)){
                        arr.clear();
                        continue out;
                    }
                }
                count++;
                arr.clear();
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(getHansu(N));
    }
}
