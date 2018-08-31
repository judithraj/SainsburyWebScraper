package fetchers;

import exceptions.WebPageFetchException;
import model.Products;

import java.io.IOException;

/**
 * Created by judith on 31/08/2018.
 */
public interface ProductScraper {
    public Products fetchAll() throws WebPageFetchException, IOException;
}
