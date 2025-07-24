
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, answer = 0;
	private static int[][] arr;
	
	
	private static void recur(int idx,int price) {
		if (idx > N) {
			return;
		}
		// 조건 식
		if(idx==N) {
			answer = Math.max(answer, price);
			return;
		} 
		
		// 상담을 안하는 경우
		recur(idx+1, price);
		
		// 상담을 하는 경우
		recur(idx+arr[idx][0], price+arr[idx][1]);
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		recur(0,0);
		System.out.println(answer);
	}
}
