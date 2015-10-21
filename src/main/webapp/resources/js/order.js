/**
 * Created by dragon on 12-May-15.
 */

$(document).ready(function() {
    populateCompositeDishList();
    populateVegetablesList();
    populateDrinksList();

    $("#order").click( sendOrder);
    $("body").bind("ajaxSend", function(elm, xhr, s){
        if (s.type == "POST") {
            xhr.setRequestHeader('X-CSRF-Token', CSRF);
        }
    });
});



function sendOrder() {
    var email = $("#email").val();
    var telephone = $("#telephone").val();
    var name = $("#name").val();
    var itemName = $("#compositeDishName").val();    //if the option has value attr, it shows the attr, if not, it shows the displayed value.
    var itemDescription = $("#compositeDishName").find("option:selected").text();    //no space between option:selected

    //var csrf = CSRF.substring(1, CSRF.length - 1);
    $.ajax({
        url: BASE_URL + "/api/order",
        //url: "http://localhost:8080/web/order",
        type:"POST",
        //should not have the line below!!!
        contentType: 'application/json',
        //data:"name=test&",
        data:JSON.stringify({
                "email": email,
                "name": name,
                "telephone": telephone,
                "orderStatus": "REQUEST",
                "items": [{"name": itemName,
                    "description": itemDescription,
                    "noodleType": "RIS",
                    "sauceType": "OYSTER",
                    "takeAway": "false",
                    "quantity": "1"
                }]
                //"_csrf": csrf

        }),
        dataType: "json",
        success: function() {
            alert("");
        },
        error: function(request, ajaxOptions, thrownError) {
            alert(request.responseText);
        }

    });
};

function populateCompositeDishList() {
    $.ajax({
        url: BASE_URL + "/api/getCompositeDishList",
        //url: "http://localhost:8080/web/order",
        type:"GET",
        success: function(datas) {
            $.each(datas, function(index, data){
                $("#compositeDishName").append('<option value="' + data + '">' + data + '</option>');
            })
        },
        error: function(request, ajaxOptions, thrownError) {
            alert(request.responseText);
        }
    });
}


function populateVegetablesList() {
    $.ajax({
        url: BASE_URL + "/api/getVegetablesList",
        //url: "http://localhost:8080/web/order",
        type:"GET",
        success: function(datas) {
            $.each(datas, function(index, data){
                $("#vegetableName").append('<option value="' + data + '">' + data.name + '</option>');
            })
        },
        error: function(request, ajaxOptions, thrownError) {
            alert(request.responseText);
        }
    });
}


function populateDrinksList() {
    $.ajax({
        url: BASE_URL + "/api/getDrinksList",
        //url: "http://localhost:8080/web/order",
        type:"GET",
        success: function(datas) {
            $.each(datas, function(index, data){
                $("#drinkName").append('<option value="' + data.name + '">' + data.name + '</option>');
            })
        },
        error: function(request, ajaxOptions, thrownError) {
            alert(request.responseText);
        }
    });
}


