package com.company.handlers;

import com.company.Collections.ProductCollection;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteProductHandler extends Handler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange);

        String request = getRequest();

        int id = 0;
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(request);

            id = Integer.parseInt(jsonObject.get("id").toString());
        } catch (ParseException e) {
            sendResponse("Invalid input data", 400);
            return;
        }

        try {
            ProductCollection.deleteProduct(id);
            sendResponse("Remove item success!", 200);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}