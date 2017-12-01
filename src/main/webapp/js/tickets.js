function raiseTicket()
{
    var message = document.getElementById("t1").value;
    var contactNum = document.getElementById("t2").value;
    var sev= document.getElementById("s1").value;
    $.ajax({
        type: 'POST',url: "raiseNewTicket",dataType: "json",
        data: {
            message: message,
            contactNum: contactNum,
            severity: sev
        },
        success: function (json){
            alert(json);
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    });
}