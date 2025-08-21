
from collections import deque

di = [0,1,0,-1]
dj = [1,0,-1,0]

def solve(N, M, arr):
    q = deque()

    # 시작 점 찾아서 큐에 넣기
    distance = [[-1 for _ in range(M)] for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                q.append([i,j])
                distance[i][j] = 0



    while q:
        i_idx, j_idx = q.popleft()

        for p in range(4):
            ni = i_idx + di[p]
            nj = j_idx + dj[p]
            if 0<=ni<N and 0<=nj<M:
                if distance[ni][nj] == -1 and arr[ni][nj] == 0:
                    distance[ni][nj] = distance[i_idx][j_idx] + 1
                    q.append([ni, nj])

    result = 0
    for i in range(N):
        for j in range(M):
            # 익지 않은 토마토 발견 > 실패
            if arr[i][j] != -1 and distance[i][j] == -1:
                return -1
            # 최대 날짜 구하기
            if distance[i][j] > result:
                result = distance[i][j]
    return result

# 입력
M, N = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]


# 출력
print(solve(N, M, arr))