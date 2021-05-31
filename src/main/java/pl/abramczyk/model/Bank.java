package pl.abramczyk.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Currency> referenceRates = new HashMap<>();

    public void addCurrencyToBank(Currency currency) {
        referenceRates.put(currency.getCurrency(), currency);
    }

    public Map<String, Currency> getReferenceRates() {
        return referenceRates;
    }

    public Currency getCurrencyFromBank(String key){
       Currency currency = referenceRates.get(key);
        return currency;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "referenceRates=" + referenceRates +
                '}';
    }
}
