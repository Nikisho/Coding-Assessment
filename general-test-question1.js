//General programming test question 1. Language used: javaScript.

const Fibonacci = function(n, previousValues = []) {
    //Check that the input is an integer.
    if (!Number.isInteger(n)) throw new Error("The input must be an integer");
    let output;   

    if (previousValues[n] != null) {
        return previousValues[n];
    } 

    if ( n <= 1 ) {
        output = 1;
    } else {
        output =  Fibonacci(n - 1, previousValues) + Fibonacci( n - 2, previousValues);
    }
    //Use memoisation to retain the output and avoid recomputing the sequence for each iteration
    previousValues[n] = output;
    return output;
} 

const sumEvenFibonacci = function(count=100) {

    if (!Number.isInteger(count)) throw new Error("The input must be an interger");
    let n = 0;
    let evenFibNumberCount = 0;
    let sum = 0;

    //If the Fibonacci number is divisible by two, add to the sum and increment the count.
    while ( evenFibNumberCount < count ) {
        if (Fibonacci(n) % 2 == 0) {
            sum += Fibonacci(n);
            evenFibNumberCount++;
        }
        n++;
    }
    return sum;
}

//test
console.log(sumEvenFibonacci());
console.log(Fibonacci(2));