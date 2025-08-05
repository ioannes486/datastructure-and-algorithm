
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,K, answer;
	static int[][] arr;
	static int[][] dp;
	static int value;
	
	static int recur(int idx, int weight) {
				
		// 조건을 큰 조건부터 분기할 것
		if (weight > K) return -9999999 ;
		
		if (idx == N) return 0;
				
		if (dp[idx][weight] != -1){
			return dp[idx][weight];
		}
		
		dp[idx][weight] = Math.max(recur(idx+1, weight), recur(idx+1, weight + arr[idx][0])+ arr[idx][1]);
						// 선택하지 않는경우 인덱스가 늘어나고, 무게 늘어나지 않음		// 선택하는 경우 인덱스가 늘어나고, 무게가 늘어나고 값이 늘어남
		return dp[idx][weight];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][2];
		dp = new int[N+1][100001];
		
		for (int i=0; i<N+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i=0; i<N;  i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(recur(0, 0));
		
	}
}
