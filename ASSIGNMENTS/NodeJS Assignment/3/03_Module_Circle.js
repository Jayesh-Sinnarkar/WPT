// Create 3 user defined modules that deal with shapes: circle.js, rectangle.js, triangle.js 
// • Circle.js has functions like : calcArea(radius), calcCircumference(radius), calcDiameter(radius) 
// • Rectangle.js – calcArea(length, breadth), calcPerimeter(length, breadth) 
// • Triangle.js – isEquilateral(side1, side2, side3), calcPerimeter() 
// Create a client application that invokes each of these methods

const calcArea = (r) => {
    return 3.14*r*r
}

const calcCircumference = (r) => {
    return 2*3.14*r
}


const calcDiameter = (r) => {
    return 2*r
} 





module.exports = {

    area:calcArea,
    cir:calcCircumference,
    diam:calcDiameter
}