package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import serialisers.ProductSerialiser;
import serialisers.ProductsSerialiser;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class with methods used to calculate the gross amount and vat
 */
public class Products {

    private List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * @return total which is the total of unit price of all products
     */
    public BigDecimal calculateTotalPrice() {
        BigDecimal grossAmount = new BigDecimal(0);
        for(Product product : products) {
            grossAmount = grossAmount.add(product.getUnit_price());
        }
        return grossAmount;
    }

    /**
     * @return vat of the gross amount of all products (vat = gross * 0.20)
     * All products have 20% vat
     */
    public BigDecimal calculateVat()
    {
        BigDecimal vat = BigDecimal.valueOf(0);
        vat = calculateTotalPrice().multiply(BigDecimal.valueOf(0.20));
        return vat;
    }

    /**
     * Output is been serialised and displayed
     * @return JSON array
     */
    public String toJSONArray() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Products.class, new ProductsSerialiser());
        gsonBuilder.registerTypeAdapter(Product.class, new ProductSerialiser());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }
}
