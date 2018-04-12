var products;
var isNew = true;
var id = -1;

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
            var json = (JSON.parse(data));
            products = json.products;
            printProducts();
        },
        error: function(err) {
            alert(err.responseText);
        }
    });
}
function save() {
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;
    var image = document.getElementById("image").value;
    var price = parseFloat(document.getElementById("price").value);
    if(isNew){
    	addProduct(name,description,image,price);
    } else {
    	updateProduct(name,description,image,id);
    }
}

function addProduct(name, description, image, price) {
var data = {
name: name,
description: description,
image: image,
price: price
};
                $.ajax({
                        url: "http://localhost:9000/addproduct",
                        type: "POST",
                        data: JSON.stringify(data),
                        success: function(id) {
                            data["id"] = parseInt(id);
                            products.push(data);
                            printProducts();
                        },
                        error: function(err) {
                            alert(err.responseText);
                        }
                    });
}

function deleteProduct(id) {
                $.ajax({
                        url: "http://localhost:9000/deleteproduct",
                        type: "POST",
                        data: JSON.stringify({
                            id: parseInt(id)
                        }),
                        success: function(data) {
                            var productIndex = products.findIndex(product => product.id == id);
                            products.splice(productIndex, 1);
                            printProducts();
                        },
                        error: function(err) {
                            alert(err.responseText);
                        }
                    });
}

function printProducts() {
	var tbody = document.getElementById("products");
	tbody.innerHTML = "";
	for (var i = 0; i < products.length; i++) {
		var tr = document.createElement("tr");
		var td_id = document.createElement("td");
		td_id.innerHTML = products[i].id;
		var td_name = document.createElement("td");
		td_name.innerHTML = products[i].name;
		var td_price = document.createElement("td");
		td_price.innerHTML = products[i].price;
		var td_description = document.createElement("td");
		td_description.innerHTML = products[i].description;
		var img = document.createElement("img");
		img.src = products[i].image;
		var td_image = document.createElement("td");
		td_image.appendChild(img);
		//Создается внутри строки столбцы
		tr.appendChild(td_id);
		tr.appendChild(td_name);
		tr.appendChild(td_price);
		tr.appendChild(td_description);
		tr.appendChild(td_image);
		var edit_btn = document.createElement("button");
		edit_btn.innerHTML = "Edit";
		edit_btn.onclick = function(){
			editProduct(products[i]);
		}

		var td_edit = document.createElement("td");
		td_edit.appendChild(edit_btn);
		tr.appendChild(td_edit);

		var delete_btn = document.createElement("button");
		delete_btn.innerHTML = "Delete";
		var id = products[i].id;
		delete_btn.onclick = function(){
			deleteProduct(id);
		}

		var td_delete = document.createElement("td");
		td_delete.appendChild(delete_btn);
		tr.appendChild(td_delete);


		tbody.appendChild(tr);
		
		
		
	}


}