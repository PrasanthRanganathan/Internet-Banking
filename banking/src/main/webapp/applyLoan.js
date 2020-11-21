function validate() {
    var name = document.getElementById("name").value
    var dob = document.getElementById("dob").value
    var number = document.getElementById("number").value
    var address = document.getElementById("address").value

    bool = /^[A-Za-z]{3,15}$/.test(name)
    bool1=/^[6-9]{1}[0-9]{9}$/.test(number)

    if (name=="") {
        alert("PLEASE ENTER NAME")
        return false
    }
    else if(bool==false){
        alert("NAME MUST CONTAIN A-Z, a-z AND MIN 3 UPTO 15")
        return false
    }
    if(dob==""){
        alert("PLEASE ENTER DATE OF BIRTH")
        return false
    }
    if(number==""){
        alert("PLEASE ENTER PHONE NUMBER")
        return false
    }
    else if(bool1==false){
        alert("NUMBER MUST STARTS WITH 6-9 AND MUST BE 10 DIGITS")
        return false
    }
    if (address=="") {
        alert("PLEASE ENTER ADDRESS")
        return false
    }
    
   
}