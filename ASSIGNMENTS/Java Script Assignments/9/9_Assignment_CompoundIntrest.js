const calCompound = ()=> {
    var p = parseInt(document.getElementById("pri").value)
    var r = parseFloat(document.getElementById("roi").value)
    var n = parseFloat(document.getElementById("yrs").value)
    var ci = 0
    
    clearMessages()
    
    if(validations(p,r,n))
    { 

    ci= parseFloat((Math.pow(1+(r/100),n)*p)-p).toFixed(2)
    
    document.getElementById("out").style.display = "block"
    
    document.getElementById("out").innerHTML = " <td  id=\"output\" align=\"center\" colspan=\"2\">Compound Intrest = "+ci+"</td>"

    }
}

const clearMessages = () =>
{
    document.getElementById("errp").style.display = "none"
    document.getElementById("errr").style.display = "none"
    document.getElementById("erry").style.display = "none"
}

const validations = (p,r,n) => {

    if(isNaN(p))
    {
        document.getElementById("errp").style.display = "block"
        return false;

    }
    else if(isNaN(r))
    {
        document.getElementById("errr").style.display = "block"
        return false;

    }
    else if(isNaN(n))
    {
        document.getElementById("erry").style.display = "block"
        return false;

    }

    return true;
}