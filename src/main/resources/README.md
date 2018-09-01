Sainsbury's Product Scraper
Console application for scraping the Sainsbury's grocery list page, providing output in JSON format.

Dependencies The only dependencies are Java and Maven, and all other dependencies are installed through Maven. Tested on Java build 1.8.0_161 and Maven 3.2.3.

Maven dependencies:

jsoup: html parsing gson: json serialization junit: testing framework

Build Install dependencies, compile, and test: $ mvn install

Test Run only the tests: $ mvn test

Run Run the application (the argument is the URI of the products page): $ mvn compile exec:java -Dexec.args="https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html"

Example output expected (see below) but threw exception when it is trying to fetch the items in fetchProduct() in Scraper class.

Program accepts the url provided by Sainsbury as argument

Testd the exception using junit test { "results": [ { "title": "Sainsbury's Strawberries 400g", "unit_price": 1.75, "kcal_per_100g": "33", "description": "by Sainsbury's strawberries" }, { "title": "Sainsbury's Blueberries 200g", "unit_price": 1.75, "kcal_per_100g": "45", "description": "by Sainsbury's blueberries" }, -----

------and so on

-----
"total": {value}
     "gross": {value}
     "vat":{value} }"