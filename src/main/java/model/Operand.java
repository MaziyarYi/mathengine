package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operand extends Section {

    private double number;

    public Operand(double number) {
        super(number +"");
        this.number = number;
    }

    public boolean equals(Operand num) {
        return num.getNumber() == number;
    }

}
