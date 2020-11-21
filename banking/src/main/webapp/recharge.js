
function validate() {
    var operator = document.getElementById("operator").value
    var number = document.getElementById("number").value
    var amount = document.getElementById("amount").value
    var password = document.getElementById("password").value

    bool=/^[6-9]{1}[0-9]{9}$/.test(number)
     bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(password)

    if(operator==""){
        alert("PLEASE SELECT OPERATOR")
        return false
    }
    if (number=="") {
        alert("PLEASE ENTER MOBILE NUMBER")
        return false
    }else if(bool==false){
        alert("MOBILE NUMBER STARTS WITH 6-9 AND MUST BE 10 DIGITS")
        return false
    }
    if (amount=="") {
        alert("PLEASE ENTER RECHARGE AMOUNT")
        return false
    }
    if (password=="") {
        alert("PLEASE ENTER PASSWORD")
        return false
    }else if(bool1==false){
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }

}
