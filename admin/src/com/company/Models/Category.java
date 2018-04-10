package com.company.Models;

import org.json.simple.JSONObject;

public class Category {
    public int id;
    public String name;
    public String description;
    public int[] productIds;

    public Category() {}

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("name", name);

        return obj;
    }
}