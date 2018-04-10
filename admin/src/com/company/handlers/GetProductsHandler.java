package com.company.handlers;

import com.company.Collections.ProductCollection;
import com.company.Models.Product;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetProductsHandler extends Handler{
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange);

        System.out.print(httpExchange.getRequestHeaders().getFirst("Authorization"));


        /* TODO: GET CATEGORIES HERE */


        try {
            ArrayList<Product> products = ProductCollection.getProducts();
            // convert categories list to json object
            JSONArray productsJSON = new JSONArray();
            for (Product product : products) {
                 productsJSON.add(product.toJSON());
            }

            JSONObject response = new JSONObject();
            response.put("products", productsJSON);

            sendResponse(response.toJSONString(), 200);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}
