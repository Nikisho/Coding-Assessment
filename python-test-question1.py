# Python programming test question 1.

def generator(n: int, dividend: int) -> list:

    #Check that the input is valid.
    if dividend < 0 or type(dividend) != int:
        raise ValueError("The dividend must be a positive integer")
    if n <= 0 or type(n) != int:
        raise ValueError("The supplied value must be an integer greater than 0")

    output = []
    # looping up to the supplied value and incrementing by the dividend skips the numbers that are 
    # not divisible by the latter.
    for i in range(0, n, dividend):
        output.append(i)
    return list(output)

def main():
    print(sum(generator(102030, 3)))
    return

if __name__ == '__main__':
    main()