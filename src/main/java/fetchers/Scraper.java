package fetchers;

import exceptions.WebPageFetchException;
import exceptions.WebPageParseException;
import model.Product;
import model.Products;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetch  all the products in the Sainsbury's website page by using the URL
 * Jsoup dependency is used to scrap the information in the website
 */

public class Scraper implements ProductScraper {

    private String url;

    public Scraper(String url) {
        this.url = url;
    }

    @Override
    public Products fetchAll() throws WebPageFetchException, IOException {
        List<Product> products = new ArrayList<Product>();

        Document productsDocument = null;
        try {
            productsDocument = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements productLinkElements = productsDocument.select(".product h3 a");

        for (Element productLinkElement : productLinkElements) {
            String productUrl = productLinkElement.attr("href");
            Product product = null;
            try {
                product = fetchProduct(productUrl);
            } catch (WebPageParseException e) {
                e.printStackTrace();
            }
            products.add(product);
        }
        return new Products(products);

    }



    /**
     * Fetch a single product
     *
     * @param productUrl models.Product URI
     * @return models.Product
     * @throws exceptions.WebPageFetchException
     */
    private Product fetchProduct(String productUrl) throws
            WebPageParseException, IOException {
        Connection connection = Jsoup.connect(productUrl);
        Document productDocument = connection.get();
        return new Product(productDocument);
    }
}




