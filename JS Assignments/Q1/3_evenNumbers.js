function evenNumbersTillN(){
    document.getElementById("output").innerHTML=""
    var num= parseInt(document.getElementById("num").value)

    while(num!==0){
        document.getElementById("output").innerHTML+= (num%2==0?num:"<br>")+""
        num--
    }
}

function clrScr(){
        document.getElementById("output").innerHTML=""
        document.getElementById("num").value=""
    }
