const calCompound = ()=> {
    var p = parseInt(document.getElementById("pri").value)
    var r = parseFloat(document.getElementById("roi").value)
    var n = parseFloat(document.getElementById("yrs").value)
    var ci = 0

    if(isNaN(p)==true)
    {
        
    }

    ci= parseFloat((Math.pow(1+(r/100),n)*p)-p).toFixed(2)
    
    document.getElementById("out").style.display = "block"
    
    document.getElementById("out").innerHTML = " <td  id=\"output\" align=\"center\" colspan=\"2\">Compound Intrest = "+ci+"</td>"

}