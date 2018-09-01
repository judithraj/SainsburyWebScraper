package serialisers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import model.Product;

import java.lang.reflect.Type;

/**
 * Json serializer is been used to convert the object into String
 */
public class ProductSerialiser implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject jObject = new JsonObject();
        jObject.addProperty("title", product.getTitle());
        jObject.addProperty("unit_price", product.getUnit_price());
        jObject.addProperty("kcal_per_100g", product.getKcal_per_100g());
        jObject.addProperty("description", product.getDescription());
        return jObject;    }
}
