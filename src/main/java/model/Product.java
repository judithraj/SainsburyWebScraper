package model;

import exceptions.WebPageParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;

/**
 * Created by judith on 29/08/2018.
 */
public class Product {

    private String title;
    private BigDecimal unit_price;
    private String kcal_per_100g;
    private String description;

    /**
     * Create a new product
     * @param title
     * @param unit_price
     * @param kcal_per_100g
     * @param description
     */
    //
    public Product(String title, BigDecimal unit_price, String kcal_per_100g, String description) {
        this.title = title;
        this.unit_price = unit_price;
        this.kcal_per_100g = kcal_per_100g;
        this.description = description;
    }

    /**
     * Construct a new product by parsing the product Html
     * @param document
     */
    public Product(Document document) throws WebPageParseException
    {
        Element element = document.body();
        title = parseTitle(element);
        unit_price = parseUnitPrice(element);
        kcal_per_100g = parseKcalPer100g(element);
        description = parseDescription(element);
    }

    //Method for scarping the product title
    private String parseTitle(Element element) throws WebPageParseException{
        Element titleElement = element.select("h1").first();
        if(titleElement != null) {
            return titleElement.text();
        } else {
            throw new WebPageParseException("Error in the page while parsing the title!");
        }
    }

    //Method for scarping the unit price of the product
    private BigDecimal parseUnitPrice(Element element) throws WebPageParseException{
        Element unitPriceElement = element.select("./unit").first();
        if(unitPriceElement != null) {
            String unit_price = unitPriceElement.text().replace("£", "").replace("/unit", "");
            return new BigDecimal(unit_price);
        } else {
            throw new WebPageParseException("Error in the page while parsing unit price");
        }
    }

    //Method for scarping the calories of the product
    private String parseKcalPer100g(Element element) throws WebPageParseException {
        Element kCalElement = element.select(".kcal").first();
        if(kCalElement != null) {
            return kCalElement.text();
        } else {
            return null;
        }
    }

    //Method for scarping the description of the product
    private String parseDescription(Element element) throws WebPageParseException{
        Element descriptionElement = element.select(".Description").first();
        if(descriptionElement != null) {
            return descriptionElement.text();
        } else {
            throw new WebPageParseException("Error in the page while parsing the description");
        }
    }


    /**
     *
     * @return title of the product
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return unit price of the product
     */
    public BigDecimal getUnit_price() {
        return unit_price;
    }

    /**
     *
     * @return energy in calories
     */
    public String getKcal_per_100g() {
        return kcal_per_100g;
    }

    /**
     *
     * @return description of the product
     */
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", unit_price=" + unit_price +
                ", kcal_per_100g=" + kcal_per_100g +
                ", description='" + description + '\'' +
                '}';
    }
}
