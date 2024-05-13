package model;

public class Operand extends Section {

    private double number;

    public Operand(double number) {
        super(number + "");
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public Operand setNumber(double number) {
        this.number = number;
        return this;
    }

    public boolean equals(Operand num) {
        return num.getNumber() == number;
    }

}
