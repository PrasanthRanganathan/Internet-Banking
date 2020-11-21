function validate() {
    var pass = document.getElementById("pwd").value
    var cpass = document.getElementById("cpwd").value
    var card =document.getElementById("card").value

    var bool1=/[0-9]{4}/.test(pass)
    var bool2=/[0-9]{4}/.test(cpass)
   
    if(card==""){
        // document.getElementById("msg3").innerHTML=" * please select the card type"
        // document.getElementById("msg3").style.color="red"
        alert("PLEASE SELECT THE CARD TYPE")
        return false
    }
    if(pass==""){
        // document.getElementById("msg1").innerHTML=" * password required"
        // document.getElementById("msg1").style.color="red"
        alert("PASSWORD REQUIRED")
        return false
    }
    else if(bool1==false){
        // document.getElementById("msg1").innerHTML=" * Password must be 4 digit number"
        // document.getElementById("msg1").style.color="red"
        alert("PASSWORD MUST BE 4 DIGIT NUMBER")
        return false
    }
    if(cpass==""){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * conform password required"
        // document.getElementById("msg2").style.color="red"
        alert("CONFORM PASSWORD REQUIRED")
        return false
    }
    else if(bool2==false){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * Password must be 4 digit number"
        // document.getElementById("msg2").style.color="red"
        alert("PASSWORD MUST BE 4 DIGIT NUMBER")
        return false
    }
    else if(pass!=cpass){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * Password and conform password must be same"
        // document.getElementById("msg2").style.color="red"
        alert("PASSWORD AND CONFORM PASSWORD MUST BE SAME")
        return false
    }
}