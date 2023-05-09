var emp = [{empID:"emp1", ename:"Jayesh", salary:300000},
            {empID:"emp2", ename:"Divyanshu", salary:200000},
            {empID:"emp3", ename:"Harshad", salary:100000}]

$(document).ready(function(){


    

$('#btn').click(function(){

        getData(emp)
        dispTable(emp)
    })

})


const getData = (emp) => {

    var empID = document.getElementById("empid").value
    var ename = document.getElementById("ename").value
    var salary = parseInt(document.getElementById("salary").value)

    var employee = {empID,ename,salary}

    emp.push(employee)

}



const dispTable = (emp) => {

     
    document.getElementById("output").innerHTML = ""
    $('#output').css("display","block")
    var str = "<table border=\"2\"> <tr> <th colspan=\"3\">Employee Data </th> </tr> <tr><th>Emp ID</th><th>Emp Name</th><th>Emp Salary</th></tr>"

    for(var ob of emp){
        str+=`<tr><td>${ob.empID}</td><td>${ob.ename}</td><td>${ob.salary}</td></tr>`
    }

    str += "</table>"


    document.getElementById("output").innerHTML += str
}