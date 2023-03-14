def solution(arr, divisor):
    tempArr = [i for i in arr if i % divisor == 0]

    if len(tempArr) == 0:
        return [-1]
    else:
        return sorted(tempArr)
