import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L;
    static int[] trucks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    static int solve() {
        Queue<Integer> bridge = new ArrayDeque<>(); 
        Queue<Integer> waiting = new ArrayDeque<>(); 

        for (int truck : trucks) {
            waiting.offer(truck);
        }

        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int currentWeight = 0; 
        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;

            int leavingTruck = bridge.poll();
            currentWeight -= leavingTruck;

            if (!waiting.isEmpty()) {
                int nextTruck = waiting.peek();
                if (currentWeight + nextTruck <= L) {
                    bridge.offer(waiting.poll());
                    currentWeight += nextTruck;
                } else {
                    bridge.offer(0);
                }
            }
        }
        return time;
    }
}
