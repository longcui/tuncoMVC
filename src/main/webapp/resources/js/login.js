function facebookLogin(name, email) {
    $.ajax({
        url: "http://localhost:8080/fbLogin",
        data:JSON.stringify({
            "email": email,
            "name": name
        }),
        type: "POST",
        contentType: 'application/json',
        dataType: "json",
        success: function(data) {
            console.log(data);
        },
        error: function(a, b, c) {
            console.log(b);
        }
    });
}