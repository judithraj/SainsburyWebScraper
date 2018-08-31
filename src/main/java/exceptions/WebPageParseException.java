package exceptions;

/**
 * Created by judith on 29/08/2018.
 */
public class WebPageParseException extends Exception {
    public WebPageParseException(String errorMessage)
    {
        super(errorMessage);
    }
    public WebPageParseException(Exception exception)
    {
        super(exception);
    }
}
