# Python programming test question 2.

def generateArray(n: int, result: list = []) -> list:
    #initial case for f(0).
    if n == 0:
        return []
        
    array: list = list(range(1, n + 1))
    result.append(array)

    #Use recursion and save the result of the previous iteration.
    generateArray(n - 1, result)
    
    #As work backwards from n to 0, we return the array reversed to get the desired output.
    return result[::-1]

#test
def main() -> None :
    print(generateArray(6))
    
if __name__ == '__main__':
    main()