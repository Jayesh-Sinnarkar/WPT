// Create a user defined local module calc.js that exposes the following functions: add(a,b), 
// subtract(a,b), multiply(a,b), divide(a,b), square(a), sum(a,b,c...)

const add = (a,b) => {
    return a+b;
}


const substract = (a,b) => {
    return a-b;
}

const multiply = (a,b) => {
    return a*b;
}

const division = (a,b) => {
    return a/b;
}

const square = (a) => {
    return a*a;
}

const sum = (...a) => {
    
    var res=0
    for(var val of a)
    {
        res = res+val;
    }

    return res;
}

module.exports = {

    add:add,
    sub:substract,
    mul:multiply,
    div:division,
    sq:square,
    sum:sum


}