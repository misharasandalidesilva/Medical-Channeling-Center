$("#BookAppoinment").on("click", function() {
    console.log("BookAppoinment button");
    let fullname = $("#fullname").val();
    let email = $("#email").val();
    let phone = $("#mobile").val();
    let Appoinmentdates = $("#appoinmentdates").val();
    let selectdoctor = $("#selectdoctor").val();
    let message = $("#message").val();

    $.ajax({
        url: 'http://localhost:8080/api/v1/bookappoinment/',
        method: 'POST',
        contentType: 'application/json',  // Set content type to JSON
        data: JSON.stringify({
            fullName: fullname,
            email: email,
            contactNumber: phone,
            appoinmentDates: Appoinmentdates,
            selectDoctor: selectdoctor,
            message: message,
        }),
        success: function (response) {
            alert("Appointment " + (appointmentData.id ? "updated" : "booked") + " successfully!");
            $("#appointmentForm")[0].reset();
            $("#appointmentId").val("");
        },
        error: function (xhr, status, error) {
            alert("Error: " + xhr.responseText);
        }
    });
})

