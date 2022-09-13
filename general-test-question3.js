//General programming test question 3. 

const checkOddDigits = function(n) {

    //Check that the input is an integer.
    if (!Number.isInteger(n)) throw new Error("Parameter must be an integer");

    //Odd numbers end with the digits 1, 3, 5, 7, or 9. So return false if the number is odd.
    if ( n % 2 != 0 ) return false;

    //Check the remainder when dividing by 10. Return false if it's odd, otherwise move to the next decimal.
    while (n > 0) {
        let  remainder = n % 10;
        if ( remainder % 2 != 0) {
            return false;
        }
        n  = Math.floor(n / 10);
    }
    return true;

}
console.log(checkOddDigits(0930))