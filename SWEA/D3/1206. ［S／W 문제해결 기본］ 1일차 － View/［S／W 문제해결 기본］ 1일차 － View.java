T = 10
def my_max(*args):
    max_val = args[0]
    for arg in args:
        if arg > max_val:
            max_val = arg
    return max_val
def solve(N, arr):
    total_cnt = 0
    for i in range(2, N-2):
        value1 = arr[i-2]
        value2 = arr[i-1]
        value3 = arr[i+1]
        value4 = arr[i+2]
        cnt = arr[i] - my_max(value1, value2, value3, value4)
        if cnt >= 0:
            total_cnt += cnt
    return total_cnt
for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    print(f"#{test_case} {solve(N, arr)}")
