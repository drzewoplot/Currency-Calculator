package pl.abramczyk.app;

import pl.abramczyk.io.ConsolePrinter;
import pl.abramczyk.io.DataReader;
import pl.abramczyk.io.file.XMLFileManager;
import pl.abramczyk.model.Bank;
import pl.abramczyk.model.Currency;

import java.util.Map;

public class CurrencyControl {
    //Statics to control the flow
    private static final int EXIT = 0;
    private static final int CONVERT_CURRENCY = 1;

    private ConsolePrinter printer = new ConsolePrinter();
    private Bank bank;

    //object needed to communicate with user
    private DataReader dataReader = new DataReader();

    CurrencyControl() {
        XMLFileManager xmlFileManager = new XMLFileManager();
        printer.printLine("Importuję dane z pliku...");
        bank = xmlFileManager.importData();
        printer.printLine("Zaimportowano dane z pliku");
    }

    public void controlLoop() {
        int option;
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case EXIT:
                    exit();
                    break;
                case CONVERT_CURRENCY:
                    convertCurrency();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji wprowadź ponownie");
            }
        } while (option != EXIT);
    }

    private double convertCurrency() {
        printer.printLine("Podaj ilość gotówki do wymiany: ");
        double amountOfCash = dataReader.getDouble();

        printer.printLine("Podaj kod waluty, na którą chcesz wymienić pieniądze(np. USD): ");
        String currencyCode = dataReader.getString().toUpperCase();

        Map<String, Currency> referenceRates = bank.getReferenceRates();
        Currency currency = referenceRates.get(currencyCode);

        double resultCash = amountOfCash * currency.getRate();
        printer.printLine("Ilość pieniędzy pozmianie na nową walutę: " + resultCash + " " + currencyCode);
        return resultCash;
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
        printer.printLine(EXIT + "- wyjście z programu");
        printer.printLine(CONVERT_CURRENCY + "- przelicz walutę na inną");
    }

    private void exit() {
        printer.printLine("Zamykanie programu.");
        dataReader.close();
    }
}
