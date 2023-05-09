// Create a module by name mymodule.js  to store three functions 
// • factorial – to find factorial of a number. 
// • myprime - Check prime number 
// • printable – to display table of a number 
// display a form to accept a number from user. If number is < 5 then call factorial function 
// if the number is > 5 and < 10 then call printable function 
// otherwise call myprime

const factorial = (n) => {
    var fact = 1;
    for(let i=1; i<=n; i++)
    {
        fact = fact*i
    }
    return fact;
}

const myPrime = (n) => {

    console.log("Table: ")

    for(let i=2;i<n/2;i++)
    {
        if(n%i==0)
        {
            console.log(n+" is not a prime number")
            return false;
        }
    }
    console.log(n+" is a prime number")
    
}

const printable = (n) => {
    for(let i=1;i<=n;i++)
    {
        var res = i*n;
        console.log(n+" * "+i+" = "+res)
    }
}

module.exports = {
    fact:factorial,
    prime:myPrime,
    table:printable
}