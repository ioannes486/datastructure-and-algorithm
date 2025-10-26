
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] arr;
    
    static final int[] di = {0, 0, 1, -1};
    static final int[] dj = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int initialLocation_i = Integer.parseInt(st.nextToken()) - 1;
        int initialLocation_j = Integer.parseInt(st.nextToken()) - 1;
        int initialDirection = Integer.parseInt(st.nextToken()) - 1;
        
        st = new StringTokenizer(br.readLine());
        int targetLocation_i = Integer.parseInt(st.nextToken()) - 1;
        int targetLocation_j = Integer.parseInt(st.nextToken()) - 1;
        int targetDirection = Integer.parseInt(st.nextToken()) - 1;

        int result = bfs(initialLocation_i, initialLocation_j, initialDirection, 
                        targetLocation_i, targetLocation_j, targetDirection);
        System.out.println(result);
    }

    static int bfs(int initialLocation_i, int initialLocation_j, int initialDirection,
                   int targetLocation_i, int targetLocation_j, int targetDirection) {
        boolean[][][] visited = new boolean[M][N][4];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {initialLocation_i, initialLocation_j, initialDirection, 0});
        visited[initialLocation_i][initialLocation_j][initialDirection] = true;

        while (!q.isEmpty()) {
            int[] v = q.poll();
            int i = v[0];
            int j = v[1];
            int dir = v[2];
            int cnt = v[3];
            
            if (i == targetLocation_i && j == targetLocation_j && dir == targetDirection) {
                return cnt;
            }

            for (int k = 1; k <= 3; k++) {
                int ni = i + di[dir] * k;
                int nj = j + dj[dir] * k;
                
                if (ni < 0 || ni >= M || nj < 0 || nj >= N) break;
                
                if (arr[ni][nj] == 1) break;
                
                if (!visited[ni][nj][dir]) {
                    visited[ni][nj][dir] = true;
                    q.offer(new int[] {ni, nj, dir, cnt + 1});
                }
            }

            int leftDir = turnLeft(dir);
            if (!visited[i][j][leftDir]) {
                visited[i][j][leftDir] = true;
                q.offer(new int[] {i, j, leftDir, cnt + 1});
            }

            int rightDir = turnRight(dir);
            if (!visited[i][j][rightDir]) {
                visited[i][j][rightDir] = true;
                q.offer(new int[] {i, j, rightDir, cnt + 1});
            }
        }

        return -1;
    }

    static int turnLeft(int dir) {
        if (dir == 0) return 3;
        if (dir == 1) return 2;
        if (dir == 2) return 0;
        return 1;
    }

    static int turnRight(int dir) {
        if (dir == 0) return 2;
        if (dir == 1) return 3;
        if (dir == 2) return 1;
        return 0;
    }
}
