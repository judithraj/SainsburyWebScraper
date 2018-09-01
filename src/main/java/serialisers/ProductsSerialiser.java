package serialisers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import model.Products;

import java.lang.reflect.Type;

public class ProductsSerialiser {
    /**
     * JSON serializer for a collection of products, including the total unit price
     */
    public class ProductsSerializer implements JsonSerializer<Products> {

        @Override
        public JsonElement serialize(final Products products, Type type, final JsonSerializationContext context) {
            final JsonObject jsonObject = new JsonObject();
            jsonObject.add("results", context.serialize(products.getProducts()));
            jsonObject.addProperty("gross", products.calculateTotalPrice());
            jsonObject.addProperty("vat", products.calculateVat());
            return jsonObject;
        }
    }
}
