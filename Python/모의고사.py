student1 = [1, 2, 3, 4, 5]
student2 = [2, 1, 2, 3, 2, 4, 2, 5]
student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]


def solution(answers):
    answer = [[1, 0], [2, 0], [3, 0]]
    for i in range(0, len(answers)):
        if answers[i] == student1[i % len(student1)]:
            answer[0][1] += 1
        if answers[i] == student2[i % len(student2)]:
            answer[1][1] += 1
        if answers[i] == student3[i % len(student3)]:
            answer[2][1] += 1

    answer.sort(key=lambda x: x[1], reverse=True)

    isMaxArr = []
    for i in answer:
        isMaxArr.append(i[1])

    temp = max(isMaxArr)

    realAnswer = []
    for i in answer:
        if temp == i[1]:
            realAnswer.append(i[0])

    return realAnswer
