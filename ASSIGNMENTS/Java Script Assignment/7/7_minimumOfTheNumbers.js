var arr=[]
var arrSize

const displayForm = ()=>{

    document.getElementById("output").innerHTML = "" 

    arrSize = parseInt(document.getElementById("no").value) 

    var printOut = "<fieldset><legend>Give Input</legend>"
            for(var i=1;i<=arrSize;i++) {
            printOut += "<label for=\"no\">Enter No "+i+":</label> &nbsp;&nbsp; <input type=\"text\" name=\"num\"><br><br>"
            }
    printOut += "&nbsp; &nbsp; &nbsp;<button type=\"button\" id=\"btn3\" onclick=\"getMin()\">Get Minimum</button>"
    printOut +="</fieldset>"
    
    document.getElementById("output").innerHTML = printOut
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