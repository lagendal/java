var isNewItem = true;
var itemId = 0;
var items;

function save() {
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;
    var file = document.getElementById("image");
    var price = parseFloat(document.getElementById("price").value);
    var image = "";

    if (file.files && file.files[0]) {
        var FR = new FileReader();

        FR.addEventListener("load", function(e) {
            document.getElementById("img").src = e.target.result;
            image = e.target.result;

            if (isNewItem)
                addItem(name, description, image, price);
            else
                editItem(itemId, name, description, image, price);
        });

        FR.readAsDataURL(file.files[0]);
    }
    else {
            if (isNewItem)
                addItem(name, description, image, price);
            else
                editItem(itemId, name, description, image, price);
    }
}

function addItem(name, description, image, price) {
var data = {
name: name,
description: description,
image: image,
price: price
};
                $.ajax({
                        url: "http://localhost:8000/additem",
                        type: "POST",
                        data: JSON.stringify(data),
                        success: function(id) {
                            data["id"] = parseInt(id);
                        },
                        error: function(err) {
                            alert(err.responseText);
                        }
                    });
}

function editItem(id, name, description, image, price) {
var data = {
id: id,
name: name,
description: description,
image: image,
price: price
};
                $.ajax({
                        url: "http://localhost:8000/edititem",
                        type: "POST",
                        data: JSON.stringify(data),
                        success: function(response) {
                            var itemIndex = items.findIndex(item => {
                                    return item.id == id;
                                });

                            items[itemIndex] = data;
                        },
                        error: function(err) {
                            alert(err.responseText);
                        }
                    });
}

function deleteItem(id) {
                $.ajax({
                        url: "http://localhost:8000/deleteitem",
                        type: "POST",
                        data: JSON.stringify({
                            id: id
                        }),
                        success: function(data) {
                            alert(data);
                        },
                        error: function(err) {
                            alert(err.responseText);
                        }
                    });
}

function prepareEdit(id) {
    var item = items.find(item => {
        return item.id == id;
    });

    document.getElementById("name").value = item.name;
    document.getElementById("description").value = item.description;
    document.getElementById("price").value = item.price;
    document.getElementById("img").src = item.image;
}