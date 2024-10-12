package entities;

public class Company extends TaxPayer {

    private int numberOfEmployess;

    public Company(String name, Double anualIcome, int numberOfEmployess ) {
        super(name, anualIcome);
        this.numberOfEmployess = numberOfEmployess;
    }

    public int getNumberOfEmployess() {
        return numberOfEmployess;
    }

    public void setNumberOfEmployess(int numberOfEmployess) {
        this.numberOfEmployess = numberOfEmployess;
    }

    @Override
    public double tax() {
        if (numberOfEmployess < 10) {
            return getAnualIncome() * 0.16;
        } else {
            return getAnualIncome() * 0.14;
        }
    }
}
