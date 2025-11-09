import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] parents, size;
    static List<Integer>[] tree;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        parents = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i < N + 1; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }

        countSubtreeNodes(R);
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            System.out.println(size[U]);
        }
    }
    
    static void countSubtreeNodes(int currentNode) {
        size[currentNode] = 1; // 자신 포함하므로 1로 초기화
        for (int node : tree[currentNode]) {
            // 부모 노드가 아니라면 재귀 호출
            if (size[node] == 0) { // 아직 방문하지 않은 노드인 경우
                countSubtreeNodes(node);
                size[currentNode] += size[node]; // 자식 서브트리의 크기를 더함
            }
        }
    }
}

