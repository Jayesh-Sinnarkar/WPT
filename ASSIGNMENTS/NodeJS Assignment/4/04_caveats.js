// Write a Node program that prints all the numbers between 1 and 100, each on a separate line. A 
// few caveats:  
// o if the number is divisible by 3, print “fizz”  
// o if the number is divisible by 5, print “buzz”  
// o if the number is divisible by both 3 and 5, print “fizzbuzz” 

const http = require("http")
const fs = require("fs")
const url = require("url")

var server = http.createServer(function(req,resp){
    var q = url.parse(req.url)
    var ws = fs.createWriteStream("printNum.html")
    ws.write("<html><head><title>printNum</title></head><body><h1>Numbers from 1 to 100:</h1></br>")
    
    for(let i=1; i<=100; i++)
    {
        if(i%5===0 && i%3==0)
        ws.write("fizzbuzz<br>")
        else if(i%5===0)
        ws.write("buzz<br>")
        else if (i%3===0)
        ws.write("fizz<br>")
        else    
            ws.write(i+"<br>")

    }

    ws.end();
    console.log(q.pathname)
    const rs = fs.createReadStream("printNum.html")
    rs.pipe(resp)

    ws.on("finish",function(){
    console.log("finish event occur")
    })

    ws.on("error", function(){
    console.log("error event occur") 
    })

})

server.listen(3001,function(){
    console.log("server is running on port 3001")

})
