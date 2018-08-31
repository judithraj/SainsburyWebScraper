package exceptions;

/**
 * Created by judith on 31/08/2018.
 */
public class WebPageFetchException extends Exception {

    public WebPageFetchException(Exception exception) {
        super(exception);
    }
}
