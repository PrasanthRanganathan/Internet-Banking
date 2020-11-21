function validate() {
    var limit=document.getElementById("limit").value

    if (limit=="") {
        // document.getElementById("msg1").innerHTML=" * please set the limit"
        // document.getElementById("msg1").style.color="red"
        alert("PLEASE SET THE LIMIT")
        return false
    }
}