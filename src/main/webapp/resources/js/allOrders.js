/**
 * Created by Longcui on 28.05.2015.
 */
$(document).ready(function() {
    $.ajax({
        url: BASE_URL + "/api/getAllOrders",
        type: "GET",
        success: function(data) {
            $.each(data, function(index, order) {
                var items = order.items;
                var itemCnt = items.length;
                $("table#allOrders").append("<tr>" +
                "<td rowspan=" + itemCnt + ">" + order.id + "</td>" +
                "<td rowspan=" + itemCnt + ">" + new Date(order.time).toLocaleString() + "</td>" +
                "<td> " + order.email + "</td>" +
                        "<td> " + items[0].name + "</td>" +
                        "<td>" + items[0].noodleType + "</td>" +
                        "<td>" + items[0].proteinType + "</td>" +
                        "<td>" + items[0].sauceType + "</td>" +
                        "<td>"  + items[0].toppingType + "</td>" +
                        "<td>"  + items[0].takeAway + "</td>" +
                "<td> " + order.totalPrice + "</td>" +
                "<td> " + order.orderStatus + "</td>" +
                "</tr>");
            });
        },
        error: function(request, textStatus, errorThrown) {
            alert(errorThrown);
        }
    })
});
