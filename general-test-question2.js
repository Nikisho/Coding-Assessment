//General programming test question 2. Language used: javaScript.

const arrayCompare = function(arrayA,arrayB) {

    //Check if the input is two sorted arrays stricly containing integers.
    const checkInput = function(arr) {
        if (!Array.isArray(arr)) {
            throw new Error("The input must be two arrays of integers");
        }

        if ( !arr.every(Number.isInteger)) {
            throw new Error("The arrays must contain integers only ");
        }   

        for (let index = 0; index < arr.length; index++) {
            if (arr[index] > arr[index+1]) {
                throw new Error('The arrays must be sorted');
            }
        }
    };
    checkInput(arrayA);
    checkInput(arrayB);

    //Concatenate the arrays and search for duplicates within the new array.
    const newArray = arrayA.concat(arrayB);
    const uniqueElements = new Set(newArray);

    //Delete elements which occur multiple times in the array.
    const filteredElements = newArray.filter(item => {
        if (uniqueElements.has(item)) {
            uniqueElements.delete(item);
        } else {
            return item;
        }
    });
    return [...new Set(filteredElements)]
};
//test
console.log(arrayCompare([1,2,10,19,39,50,50],[1,1,2,3,7,10,19,39,50]));