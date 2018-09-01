package exceptions;

/**
 * Exception thrown when there is a problem while fetching the product
 */
public class WebPageFetchException extends Exception {

    public WebPageFetchException(Exception exception) {
        super(exception);
    }
}
