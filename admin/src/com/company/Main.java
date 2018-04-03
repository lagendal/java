package com.company;

import com.company.Collections.ProductCollection;
import com.company.Models.Product;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            AppConnection.createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    }
}
