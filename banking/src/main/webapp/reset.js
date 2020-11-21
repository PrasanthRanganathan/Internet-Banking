function validate(){
    var npwd=document.getElementById("npwd").value
    var bool=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}$/.test(npwd)
    var cpwd=document.getElementById("cpwd").value
    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(cpwd)
    if(npwd==""){
        // document.getElementById("id1").innerHTML=" * Must enter password"
        // document.getElementById("id1").style.color="red"
        alert("PASSWORD REQUIRED")
        return false
    }
    else if (bool==false) {
        // document.getElementById("id1").innerHTML=" * Password must contain A-Z, a-z, 0-9 and special char"
        // document.getElementById("id1").style.color="red"
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
    if (cpwd=="") {
        // document.getElementById("id1").innerHTML=""
        // document.getElementById("number1").innerHTML=" * Must enter conform password"
        // document.getElementById("number1").style.color="red"
        alert("CONFORM PASSWORD REQUIRED")
        return false
    }
   
    else if(bool1==false){
        // document.getElementById("id1").innerHTML=""
        // document.getElementById("number1").innerHTML=" * Password must contain A-Z, a-z, 0-9 and special char"
        // document.getElementById("number1").style.color="red"
        alert("Conform password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
    if(npwd!=cpwd){
    	// document.getElementById("number1").innerHTML=" * Password and conform password must be same"
        // document.getElementById("number1").style.color="red"
        alert("PASSWORD AND CONFORM PASSWORD MUST BE SAME")
    		return false
    }
    return true
}