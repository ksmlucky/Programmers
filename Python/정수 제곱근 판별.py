def solution(n):
    answer = -1

    for i in range (0, int(n ** 0.5) + 1):
        if i * i == n:
            answer = (i + 1) * (i + 1)
            break

    return answer
