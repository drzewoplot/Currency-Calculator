package pl.abramczyk.io.file;

import org.xml.sax.SAXException;
import pl.abramczyk.model.Bank;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLFileManager {

    private static final String FILE_NAME = "src/main/resources/eurofxref-daily.xml";
    static Bank bank = new Bank();

    public static Bank importData() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            MapCurrencyHandlerSax handler = new MapCurrencyHandlerSax();
            saxParser.parse(FILE_NAME, handler);
            bank = handler.getBank();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return bank;
    }

}
