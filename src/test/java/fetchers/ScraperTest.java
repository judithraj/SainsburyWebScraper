package fetchers;

import exceptions.WebPageFetchException;
import org.hamcrest.CoreMatchers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ScraperTest
{
    private String url = "\"https:/sainsbury/product/";
    private Scraper testSubject = new Scraper(url);

 @Test(expected=java.lang.IllegalArgumentException.class)
    public  void throwsIllegalArgumentExceptionwhenFetchAllMethodIsCalled() throws IOException {
     try {
         testSubject.fetchAll();
     } catch (WebPageFetchException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
     assertThat(Jsoup.connect(url).get(), CoreMatchers.<Document>is(Document.createShell(url)));
 }

}