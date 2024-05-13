package operation;

import model.Function;
import model.Operand;
import model.Operator;
import model.Section;

import java.util.*;

public class Operation {

    private String operation;
    private Queue<Section> sections;
    private Stack<Operand> operands;

    public Operation(String operation, Section... sections) {
        this.operation = operation;
        this.sections = new LinkedList<>(Arrays.asList(sections));
        this.operands = new Stack<>();
    }

    private Operand evalOperand() {
        return new Operand(eval());
    }

    public String getOperation() {
        return operation;
    }

    public double eval() {
        while (!sections.isEmpty()) {
            Section sec = sections.peek();
            if (sec instanceof Operand) {
                operands.push((Operand) sections.poll());
            } else if (sec instanceof Operator) {
                Operator op = (Operator) sec;
                List<Operand> opArgs = new ArrayList<>();
                for (int i = 0; i < op.getArity(); i++) {
                    opArgs.add(0, this.operands.pop());
                }
                operands.push(op.apply(opArgs.toArray(new Operand[opArgs.size()])));
                sections.remove();
            } else if (sec instanceof Function) {
                Function func = (Function) sec;

                List<Operand> funcArgs = new ArrayList<>();
                for (int i = 0; i < func.getParameters(); i++) {
                    funcArgs.add(0, this.operands.pop());
                }

                operands.push(func.apply(funcArgs.toArray(new Operand[funcArgs.size()])));
                sections.remove();
            }
            if (operands.size() == 1 && sections.isEmpty()) {
                return operands.pop().getNumber();
            }
        }
        if (operands.isEmpty()) {
            throw new UnsupportedOperationException("No result.");
        } else {
            double result = 1;
            for (Operand op : operands) {
                result *= op.getNumber();
            }
            return result;
        }
    }

}
