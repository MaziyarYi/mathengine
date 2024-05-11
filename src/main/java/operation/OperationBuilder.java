package operation;

import defaultValue.OperationDefault;
import model.*;
import util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationBuilder {

    private String operation;

    private List<Section> sections;
    private Stack<Section> operatorStack;


    private HashMap<String, Operator> operators;
    private HashMap<String, Constant> constants;
    private HashMap<String, Function> functions;

    private String parenthesis_open = "(";
    private String parenthesis_close = ")";
    private String argument_separator = ",";

    private OperationFactory operationFactory;

    public OperationBuilder(String operation, OperationFactory operationFactory) {
        this.operation = operation.toLowerCase();
        sections = new ArrayList<>();
        operatorStack = new Stack<>();
        operators = new HashMap<>();
        constants = new HashMap<>();
        functions = new HashMap<>();
        this.operationFactory = operationFactory;
        addDefaultPack();
    }

    private void addDefaultPack() {
        addOperator(operationFactory.getOperators().toArray(new Operator[operationFactory.getOperators().size()]));
        addConstant(operationFactory.getConstants().toArray(new Constant[operationFactory.getConstants().size()]));
        addFunction(operationFactory.getFunctions().toArray(new Function[operationFactory.getFunctions().size()]));
    }

    public OperationBuilder addOperator(Operator... operators) {
        for (Operator op : operators) {
            this.operators.put(op.getSection(), op);
        }
        return this;
    }

    public OperationBuilder addConstant(Constant... constants) {
        for (Constant con : constants) {
            for (String key : con.getKeys()) this.constants.put(key, con);
        }
        return this;
    }

    public OperationBuilder addFunction(Function... functions) {
        for (Function func : functions) {
            this.functions.put(func.getSection(), func);
        }
        return this;
    }

    public void setParenthesis(String open, String close) {
        this.parenthesis_open = open;
        this.parenthesis_close = close;
    }

    public void setArgumentSeparator(String argument_separator) {
        this.argument_separator = argument_separator;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Section sec : sections) output.append(sec.toString()).append(" ");
        return output.toString();
    }

    public Operation build() {
        return new Operation(operation, sections.toArray(new Section[sections.size()]));
    }

    private Matcher buildRegex() {
        String regexOperator = "", regexConstant = "", regexFunction = "", regexNotation;

        for (String s : operators.keySet()) regexOperator += "\\" + s;

        for (String s : constants.keySet()) regexConstant += s + "|";
        regexConstant = regexConstant.substring(0, regexConstant.length() - 1);

        for (String s : functions.keySet()) regexFunction += s + "|";
        regexFunction = regexFunction.substring(0, regexFunction.length() - 1);

        regexNotation = String.format("\\%s\\%s\\%s", parenthesis_open, parenthesis_close, argument_separator);

        Pattern regex = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|"
                + "([" + regexNotation + "])|"
                + "([" + regexOperator + "])|" + "(" + regexConstant + ")|(" + regexFunction + "))");

        return regex.matcher(operation);
    }

    public OperationBuilder parse() {
        Matcher matcher = buildRegex();
        int matcherIndex = 0;
        boolean isNegative = false;

        while (matcher.find()) {
            String section = matcher.group();
            matcherIndex = matcher.start();
            if (Util.isNumber(section)) {
                sections.add(isNegative ? new Operand(Double.parseDouble(section) * -1) : new Operand(Double.parseDouble(section)));

            } else if (operators.containsKey(section)) {
                Operator op = operators.get(section);

                if (op.equals(OperationDefault.SUBTRACT)) {
                    if (matcherIndex - 1 < 0 || (matcherIndex - 1 >= 0 && !Util.isNumber(String.valueOf(operation.charAt(matcherIndex - 1))))) {
                        isNegative = true;
                        continue;
                    }
                }
                if (op.getPrecedence() < Operator.PRECEDENCE_FORCE) {
                    while (!operatorStack.empty()) {
                        if (operatorStack.peek() instanceof Operator) {
                            Operator op2 = (Operator) operatorStack.peek();
                            if (op.isLeftAssociative() && op.getPrecedence() <= op2.getPrecedence() ||
                                    !op.isLeftAssociative() && op.getPrecedence() < op2.getPrecedence()) {
                                sections.add(operatorStack.pop());
                            } else {
                                break;
                            }
                        } else break;
                    }
                    operatorStack.push(op);
                } else {
                    sections.add(op);
                }
            } else if (constants.containsKey(section)) {
                sections.add(new Operand(constants.get(section).getValue()));
            } else if (functions.containsKey(section)) {
                operatorStack.push(functions.get(section));
            } else if (parenthesis_open.equals(section)) {
                operatorStack.push(new Section(parenthesis_open));
            } else if (parenthesis_close.equals(section)) {
                while (!operatorStack.peek().getSection().equals(parenthesis_open)) {
                    sections.add(operatorStack.pop());
                }
                if (operatorStack.peek().getSection().equals(parenthesis_open))      // Pop "(", ignore return value
                    operatorStack.pop();
                if (!operatorStack.isEmpty() && operatorStack.peek() instanceof Function)     // If first token is function token, pop
                    sections.add(operatorStack.pop());
            } else if (argument_separator.equals(section)) {
                while (!operatorStack.peek().getSection().equals(parenthesis_open)) {
                    if (operatorStack.isEmpty())
                        throw new IllegalArgumentException("Unclosed function parenthesis.");
                    sections.add(operatorStack.pop());
                }
            } else {
                throw new IllegalArgumentException("Unknown section \"" + section + "\" at index: " + operation.indexOf(section));
            }
        }
        while (!operatorStack.empty()) {
            sections.add(operatorStack.pop());
        }
        return this;
    }

}
