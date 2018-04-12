package com.company.handlers;

import com.company.Models.Product;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class EditProductHandler extends Handler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange);

        String request = getRequest();

        Product product = new Product();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(request);

            product.id = (Integer)jsonObject.get("id");
            product.description = jsonObject.get("description").toString();
            product.image = jsonObject.get("image").toString();
            product.name = jsonObject.get("name").toString();
            product.price = (Float)jsonObject.get("price");
        } catch (ParseException e) {
            sendResponse("Invalid input data", 400);
            return;
        }

        /* TODO: change item in db */

        sendResponse("Edit item success!", 200);
    }
}