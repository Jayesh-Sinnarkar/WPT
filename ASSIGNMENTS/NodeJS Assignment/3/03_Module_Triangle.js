// Create 3 user defined modules that deal with shapes: circle.js, rectangle.js, triangle.js 
// • Circle.js has functions like : calcArea(radius), calcCircumference(radius), calcDiameter(radius) 
// • Rectangle.js – calcArea(length, breadth), calcPerimeter(length, breadth) 
// • Triangle.js – isEquilateral(side1, side2, side3), calcPerimeter() 
// Create a client application that invokes each of these methods


const calcIsEquilateral=(side1, side2, side3) => {
    if(side1===side2 && side1===side3){
        console.log("All sides are equal so Traingle is equilateral") 
    }
    else
    {
        console.log("Sides are not equal so Traingle is not equilateral") 
    }
}

const calcPerimeter=(side1, side2, side3) => {
    return side1 + side2 + side3
}

module.exports={
    isEquilateral:calcIsEquilateral,
    perimeter:calcPerimeter
}