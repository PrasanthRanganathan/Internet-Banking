function validate(){
    var id=document.getElementById("id").value
    var bool=/^[0-9A-Za-z]{6,10}$/.test(id)
    var pass=document.getElementById("pass").value
    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(pass)
    if(id==""){
        // document.getElementById("id1").innerHTML=" * enter user id"
        // document.getElementById("id1").style.color="red"
        alert("USER ID REQUIRED")
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
        // document.getElementById("pass1").innerHTML=" * Password required"
        // document.getElementById("pass1").style.color="red"
        alert("PASSWORD REQUIRED")
        return false
    }
   
    else if(bool1==false){
        // document.getElementById("id1").innerHTML=""
        // document.getElementById("pass1").innerHTML=" * Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15"
        // document.getElementById("pass1").style.color="red"
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
       return true
}

