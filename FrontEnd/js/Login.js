$("#loginBTN").on("click", function() {
    console.log("Register button");
    let email = $("#email").val();
    let password = $("#password").val();

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/authenticate',
        method: 'POST',
        contentType: 'application/json',  // Set content type to JSON
        data: JSON.stringify({
            email: email,
            password: password,
        }),
        success: function(data) {
            if (email === email && password === password) {
                alert("Login successful!");
            }else {
                alert("Password does not match!");
            }

        },
        error: function(xhr, status, error) {
            // Handle errors
        }
    });
});