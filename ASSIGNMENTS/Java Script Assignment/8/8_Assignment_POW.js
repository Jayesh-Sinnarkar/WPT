var num
var pow
const displayArea = ()=> {

    document.getElementById("resDiv").innerHTML = ""
    
    num = parseInt(document.getElementById("num").value)
    pow = parseInt(document.getElementById("pow").value)
    var inDiv = document.getElementById("resDiv")
    
    inDiv.style.display = "block" 

    document.getElementById("resDiv").innerHTML += "<span id=\"span\">Result of  ("+num+") <sup> "+pow+" </sup>is "+calculatePow()+"</span>";
}

const calculatePow = () => {
    var res = 1;
    document.getElementById("num").value = ""
    document.getElementById("pow").value = ""

    for(var i=1;i<=pow;i++)
    {
        res = res*num       
    }

    return res;
}