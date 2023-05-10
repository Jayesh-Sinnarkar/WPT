var circle = require("./03_Module_Circle")
var rectangle = require("./03_Module_Rectangle")
var triangle = require("./03_Module_Triangle")


//Circle
console.log("Area of Circle is: ",circle.area(7))
console.log("Circumference of Circle is: ",circle.cir(7))
console.log("Diameter of Circle is: ",circle.diam(7))
console.log(" ")

// Rectangle
console.log("Area of Rectangle is: ",rectangle.area(7,7))
console.log("Perimeter of Rectangle is: ",rectangle.perimeter(7,7))
console.log(" ")


//Triangle
triangle.isEquilateral(7,7,7)
triangle.isEquilateral(7,8,7)
console.log("Perimeter of Triangle is: ",triangle.perimeter(7,7,7))



