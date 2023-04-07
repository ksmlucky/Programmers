def solution(nums):
    answer = len(set(nums))

    if answer > int(len(nums) / 2):
        return int(len(nums) / 2)
    else:
        return answer
