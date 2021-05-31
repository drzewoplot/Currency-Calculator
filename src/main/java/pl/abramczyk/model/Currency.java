package pl.abramczyk.model;

import java.io.Serializable;

public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    String currency;

    double rate;

    public Currency() {
    }

    public Currency(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                ", rate=" + rate +
                '}';
    }
}
