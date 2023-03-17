def solution(a, b):
    if a > b:
        a ,b = b, a
    return sum([i for i in range(a, b + 1)])

# def solution(a, b):
#     answer = 0
    
#     if a > b:
#         temp = a
#         a = b
#         b = temp
    
#     for i in range(a, b + 1):
#         answer += i
    
#     return answer
