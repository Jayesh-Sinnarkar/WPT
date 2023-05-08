var empName = [];

$(document).ready(function(){

$('#btn').click(function(){

for(var i=0; i<6; i++)
{
    empName[i]=document.getElementsByName("ename")[i].value
}
sortEmpData(empName)
})

const sortEmpData = (empName) =>{
    var res = empName.sort()
    $('#output').css("display","block")

    $('span').html("Names in Sorted Order:"+res)
    
}













})