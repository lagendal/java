var products;
$( document ).ready(function() {
    getProducts();
});

function getProducts() {
    $.ajax({
        url: "http://localhost:9000/getproducts",
        type: "GET",
        beforeSend: function(request) {
            request.setRequestHeader("Authorization", localStorage.getItem("token"));
        },
        success: function(data) {
            console.log(JSON.parse(data));
        },
        error: function(err) {
            alert(err.responseText);
        }
    });
}