var empName = [];

$(document).ready(function(){

$('#btn').click(function(){
    alert("Hello")

for(var i=0; i<6; i++)
{
    empName[i]=document.getElementsByName("ename")[i].value
}
sortEmpData(empName)
})

})

function sortEmpData(empName){

    var res = empName.sort()

    $('#output').css("display","block")

    $('span').html("Names in Sorted Order:"+res)
    
}
