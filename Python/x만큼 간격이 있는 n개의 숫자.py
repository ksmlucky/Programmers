def solution(x, n):
    arr = []

    answer = x
    while n > 0:
        arr.append(answer)
        answer += x
        n = n - 1

    return arr
