package fetchers;

import exceptions.WebPageFetchException;
import model.Products;

import java.io.IOException;

/**
 * Interface - Fetching all products in the page
 */
public interface ProductScraper {
    public Products fetchAll() throws WebPageFetchException, IOException;
}
