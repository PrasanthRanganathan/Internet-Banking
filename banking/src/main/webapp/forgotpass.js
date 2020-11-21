function validate(){
    var id=document.getElementById("id").value
    var bool=/^[0-9A-Za-z]{6,10}$/.test(id)
    var pass=document.getElementById("number").value
    var bool1=/^[6-9]{1}[0-9]{9}$/.test(pass)
    if(id==""){
        // document.getElementById("id1").innerHTML=" * Must enter user ID"
        // document.getElementById("id1").style.color="red"
        alert("ENTER USER ID")
        return false
    }
    else if (bool==false) {
        // document.getElementById("id1").innerHTML=" * User ID must be min of 6 characters"
        // document.getElementById("id1").style.color="red"
        alert("USER ID MUST BE 6 CHARACTERS")
        return false
    }
    if (pass=="") {
        // document.getElementById("id1").innerHTML=""
        // document.getElementById("number1").innerHTML=" * Number must required"
        // document.getElementById("number1").style.color="red"
        alert("ENTER MOBILE NUMBER")
        return false
    }
   
    else if(bool1==false){
        // document.getElementById("id1").innerHTML=""
        // document.getElementById("number1").innerHTML=" * Number starts with 6-9 and must be 10 digits"
        // document.getElementById("number1").style.color="red"
        alert("NUMBER STARTS WITH 6-9 AMD MUST BE 10 DIGITS")
        return false
    }
    return true
}