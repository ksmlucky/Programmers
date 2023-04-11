def solution(array, commands):
    return [sorted(array[i - 1:j])[k - 1] for i, j, k in commands]

    # answer = []
    #
    # for arr in commands:
    #     i = arr[0]
    #     j = arr[1]
    #     k = arr[2] - 1
    #
    #     temp = sorted(array[i - 1 : j])
    #     answer.append(temp[k])
    #
    # return answer
