package com.codecool.Storage;

import com.codecool.Model.Product;

import java.util.HashMap;

public class ProductStorage implements Storage<Product> {

    @Override
    public boolean addElement(Product element) {
        return false;
    }

    @Override
    public boolean removeElements(HashMap<Product, Integer> elements) {
        return false;
    }

    @Override
    public boolean hasElement(Product element) {
        return false;
    }

    @Override
    public boolean clearBuffer() {
        return false;
    }
}
