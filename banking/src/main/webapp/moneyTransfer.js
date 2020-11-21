function validate() {
  var fromAcc = document.getElementById("saccno").value
  var toAcc = document.getElementById("accno").value
  var ctoAcc = document.getElementById("caccno").value
    var name= document.getElementById("name").value
    var amount = document.getElementById("amt").value
    var pmode = document.getElementById("mode").value

    bool=/[0-9]{16}/.test(fromAcc)
    bool1=/^[0-9]{16}$/.test(toAcc)
    bool2=/^[0-9]{16}$/.test(ctoAcc)
    bool3=/^[A-Za-z]{3,15}$/.test(name)
    
    if(fromAcc==""){
        // document.getElementById("msg1").innerHTML=" * Payer account number required"
        alert("PAYER ACCOUNT NUMBER REQUIRED")
        return false
    }
    else if(bool==false){
        // document.getElementById("msg1").innerHTML=" * Payer account number must be 16 digits "
        alert("PAYER ACCOUNT NUMBER MUST BE 16 DIGITS")
        return false
    }

    if(toAcc==""){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * Payee account number required"
        alert("PAYEE ACCOUNT NUMBER REQUIRED")
        return false
    }
    else if(bool1==false){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * Payee account number must be 16 digits "
        alert("PAYEE ACCOUNT NUMBER MUST BE 16 DIGITS")
        return false
    }
    else if(fromAcc==toAcc){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=" * Payee and payer account number must be different"
       alert("PAYEE AND PAYER ACCOUNT NUMBER MUST BE DIFFERENT")
        return false
    }

    if(ctoAcc==""){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=" * Conform account number required"
        alert("CONFORM ACCOUNT NUMBER REQUIRED")
        return false
    }
    else if(bool2==false){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=" * Conform account number must be 16 characters "
        alert("CONFORM ACCOUNT NUMBER MUST BE 16 DIGITS")
        return false
    }
    else if(ctoAcc!=toAcc){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=" * Payee and conform account number must be same"
        alert("PAYEE AND CONFORM ACCOUNT NUMBER MUST BE SAME")
        return false
    }

    if(name==""){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=""
        // document.getElementById("msg4").innerHTML=" * Payee name must required"
        alert("PAYEE NAME REQUIRED")
        return false
    }
    else if(bool3==false){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=""
        // document.getElementById("msg4").innerHTML=" * it accept only A-Z, a-z and min of 3 upto 15 characters"
       alert("PAYEE NAME MUST CONTAIN A-Z, a-z AND MIN 3 UPTO 15 CHARACTERS")
        return false
    }

    if(amount==0){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=""
        // document.getElementById("msg4").innerHTML=""
        // document.getElementById("msg5").innerHTML=" * please enter amount"
        alert("PLEASE ENTER AMOUNT")
        return false
    }

    if(pmode!="NEFT" && pmode!="IMPS"){
        // document.getElementById("msg1").innerHTML=""
        // document.getElementById("msg2").innerHTML=""
        // document.getElementById("msg3").innerHTML=""
        // document.getElementById("msg4").innerHTML=""
        // document.getElementById("msg5").innerHTML=""
        // document.getElementById("msg6").innerHTML=" * please select the payment mode"
        alert("PLEASE SELECT THE PAYMENT MODE")
        return false
    }
}