import exceptions.WebPageFetchException;
import fetchers.ProductScraper;
import fetchers.Scraper;
import model.Products;

import java.io.IOException;

/**
 * Created by judith on 29/08/2018.
 */
public class MainApplication {

        /**
         * Run the application from the console
         * e.g., mvn compile exec:java -Dexec.args=
         * @param args URI of the products page
         * @throws WebPageFetchException
         */

        public static void main(String args[]) throws WebPageFetchException, IOException {
            String productsUri = args[0];
            ProductScraper productFetcher = new Scraper(productsUri);
            Products products = null;
            try {
                products = productFetcher.fetchAll();
            } catch (WebPageFetchException e) {
                e.printStackTrace();
            }
            System.out.println(products.toJSONArray());
        }
    }

