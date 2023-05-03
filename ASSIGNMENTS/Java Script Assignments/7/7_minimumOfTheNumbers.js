var arr=[]
var arrSize

const displayForm = ()=>{

    arrSize = parseInt(document.getElementById("no").value) 

    for(var i=1;i<=arrSize;i++) {
    document.getElementById("output").innerHTML += 
    "<label for=\"no\">Enter No"+i+":</label> &nbsp;&nbsp; <input type=\"text\" name=\"num\"><br><br>"
    }
    document.getElementById("output").innerHTML += "&nbsp; <button type=\"button\" id=\"btn3\" onclick=\"getMin()\">Get Minimum</button>"
}


const getArray = ()=>{
    
    for(var i=0;i<arrSize;i++){

        arr[i] = parseInt(document.getElementsByName("num")[i].value)
    }

    document.getElementById("output").innerHTML += "<br><br><br> Input Array is ["+arr+"] <br><br>"
}

const getMin = ()=>{
    getArray();
    var min = arr.reduce((acc,val)=>acc<val?acc:val)
    document.getElementById("output").innerHTML += "Minimum Value is: "+min+"<br><br>"
    document.getElementById("no").value=""
}