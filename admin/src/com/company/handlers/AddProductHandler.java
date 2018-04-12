package com.company.handlers;

import com.company.Collections.ProductCollection;
import com.company.Models.Product;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

public class AddProductHandler extends Handler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange);

        String request = getRequest();

        Product product = new Product();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(request);

            product.description = jsonObject.get("description").toString();
            product.image = jsonObject.get("image").toString();
            product.name = jsonObject.get("name").toString();
            product.price = Integer.parseInt(jsonObject.get("price").toString());
        } catch (ParseException e) {
            e.printStackTrace();
            sendResponse("Invalid input data", 400);
            return;
        }

        try {
            long id = ProductCollection.addProduct(product);
            sendResponse(String.valueOf(id),200);
        } catch (SQLException e) {
            sendResponse("Invalid date",400);
            e.printStackTrace();
        }

    }
}