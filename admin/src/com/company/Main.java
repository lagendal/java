package com.company;

import com.company.Collections.ProductCollection;
import com.company.Models.Product;
import com.company.handlers.GetProductsHandler;
import com.company.handlers.SignInHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            AppConnection.createConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(9000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert server != null;
        server.createContext("/signin", new SignInHandler());
        server.createContext("/getproducts", new GetProductsHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

        /*
        try {
            System.out.println(ProductCollection.getProducts());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.name = "Опа ча";
        product.description = "лала";
        product.price = 150;
        product.image = "2321.ru";
        product.id = 2;
        try {
            ProductCollection.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ProductCollection.deleteProduct(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

    }
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
