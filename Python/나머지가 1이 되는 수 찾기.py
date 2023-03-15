def solution(x):
    if x % sum([int(i) % 10 for i in str(x)]) == 0:
        return True
    else:
        return False
