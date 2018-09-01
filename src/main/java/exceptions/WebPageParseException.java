package exceptions;

/**
 *  * Exception thrown when there is a problem while parsing the web page
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
