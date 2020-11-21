function validate() {
    var card = document.getElementById("card").value
    var reason = document.getElementById("reason").value
    var pass = document.getElementById("pwd").value

    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(pass)
   

    if(card==""){
        // document.getElementById("msg1").innerHTML=" * please select the card type"
        // document.getElementById("msg1").style.color="red"
        alert("PLEASE SELECT THE CARD TYPE")
        return false
    }
    if(reason==""){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * please select the reason"
        // document.getElementById("msg2").style.color="red"
        alert("PLEASE SELECT THE REASON")
        return false
    }
    if (pass=="") {
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=" * Password required"
        // document.getElementById("msg3").style.color="red"
        alert("PASSWORD REQUIRED")
        return false
    }
   
    else if(bool1==false){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=" * Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15"
        // document.getElementById("msg3").style.color="red"
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
}