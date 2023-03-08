def solution(phone_number):
    length = len(phone_number)
    temp = phone_number[-4:]
    return "*" * (length - 4) + temp
