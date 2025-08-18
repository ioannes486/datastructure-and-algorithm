from collections import deque


di = [0,1,0,-1]
dj = [1,0,-1,0]
def solve(N, M, treasure_map):
    maximum_duration = 0
    for i in range(N):
        for j in range(M):
            if treasure_map[i][j] == 'L':
                visited = [[0 for _ in range(M)] for _ in range(N)]
                visited[i][j] = 1;
                distances = [[0 for _ in range(M)] for _ in range(N)]
                start = [i, j]
                q = deque([start])

                while q:
                    i_idx, j_idx = q.popleft()
                    for idx in range(4):
                        ni = i_idx + di[idx]
                        nj = j_idx + dj[idx]
                        if 0<=ni<N and 0<=nj<M:
                            if treasure_map[ni][nj] == 'L':
                                if visited[ni][nj] != 1:
                                    visited[ni][nj] = 1
                                    distances[ni][nj] = distances[i_idx][j_idx] + 1
                                    q.append([ni,nj])
                                    maximum_duration = max(maximum_duration, distances[ni][nj])



    return maximum_duration

# 입력
N, M = map(int, input().split()) # 지도 세로, 가로
treasure_map = [list(input()) for _ in range(N)]

# 출력
print(solve(N, M, treasure_map))