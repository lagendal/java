package com.company.Collections;

import com.company.AppConnection;
import com.company.Models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductCollection {
    public static ArrayList <Product>  getProducts() throws SQLException {
        PreparedStatement ps = AppConnection.conn.prepareStatement("SELECT * FROM products");
        ResultSet result = ps.executeQuery();
        ArrayList <Product> products = new ArrayList<>();
        while (result.next()){
            Product product = new Product();
            product.id = result.getInt("id");
            product.name = result.getString("name");
            product.price = result.getFloat("price");
            product.description = result.getString("description");
            product.image = result.getString("image");
            products.add(product);
        }
        return products;
    }
    public static int addProduct (Product product) throws SQLException {
        PreparedStatement ps = AppConnection.conn.prepareStatement("INSERT INTO products(name,description,price,image)" +
                "values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,product.name);
        ps.setString(2,product.description);
        ps.setFloat(3, product.price);
        ps.setString(4,product.image);
        return ps.executeUpdate();

    }
     public static boolean updateProduct(Product product) throws SQLException {
        PreparedStatement ps = AppConnection.conn.prepareStatement("UPDATE products SET name = ?, description = ?, price = ?," +
                "image = ? WHERE id = ?");
        ps.setString(1,product.name);
        ps.setString(2,product.description);
        ps.setFloat(3, product.price);
        ps.setString(4,product.image);
        ps.setInt(5,product.id);
        return  ps.executeUpdate() == 1;



    }
    public static boolean deleteProduct(int id) throws SQLException {
        PreparedStatement ps = AppConnection.conn.prepareStatement( "DELETE FROM products WHERE id = ?");
        ps.setInt(1,id);
        return ps.executeUpdate() == 1;



    }

}
