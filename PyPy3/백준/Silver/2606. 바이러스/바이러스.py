
def dfs(graph, v, visited):
    visited[v] = True

    for node_idx in graph[v]:
        if not visited[node_idx]:
            dfs(graph, node_idx, visited)

def solve(N, graph):
    visited  = [False for _ in range(N+1)]

    dfs(graph, 1, visited)

    linked_cnt = 0
    for v in visited:
        if v:
            linked_cnt += 1

    return linked_cnt - 1


# 입력
N = int(input())
M = int(input())

# 1번노드부터 시작하므로 +1해주기
graph = [[] for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 출력
print(solve(N,graph))