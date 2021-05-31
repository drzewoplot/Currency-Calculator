package pl.abramczyk.io.file;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import pl.abramczyk.io.ConsolePrinter;
import pl.abramczyk.model.Bank;
import pl.abramczyk.model.Currency;

public class MapCurrencyHandlerSax extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();
    private ConsolePrinter printer = new ConsolePrinter();
    private Bank bank = new Bank();

    private Currency currentCurrency;

    public Bank getBank() {
        return bank;
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {
        currentValue.setLength(0);

        if ((qName.equalsIgnoreCase("Cube")) &&
                ((attributes.getValue("currency") != null) &&
                        (attributes.getValue("rate") != null))) {
            // getting tag's attribute
            String currency = attributes.getValue("currency");
            String r = attributes.getValue("rate");
            double rate = Double.parseDouble(r);

            //creating a currency object,and supplying it to bank(HashMap)
            currentCurrency = new Currency(currency, rate);
            bank.addCurrencyToBank(currentCurrency);

            printer.printLine(bank.getCurrencyFromBank(currency).toString());
        }

    }


}
