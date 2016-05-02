import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 10/04/2016
 */
public class Var implements Expression {

    private String value;

    /**
     * Instantiates a new Var.
     * @param value the string value of the variable.
     */
    public Var(String value) {
        this.value = value;
    }

    /**
     * Assigns values to variables and evaluates the result of the expression.
     * <p>
     * @param assignment a map of the variables and their assigned values.
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return 0;
    }

    /**
     * evaluates the result of the expression without variable assignment.
     * <p>
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    @Override
    public double evaluate() throws Exception {
        return 0;
    }

    /**
     * Returns a list of unique variables in the expression.
     * <p>
     * @return list of variables.
     */
    @Override
    public List<String> getVariables() {
        List<String> vars = new LinkedList<>();
        vars.add(this.value);

        return vars;
    }

    /**
     * Prints the expression in a specific format.
     * <p>
     * @return a string representation of the expression.
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * assigns the given values to the variables.
     * <p>
     * @param var the variables to be assigned.
     * @param expression the expression to assigned.
     * @return a new expression with the assigned variables.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if (this.value.equals(var)) {
            return expression;
        } else {
            return this;
        }
    }

    /**
     * returns the derivative of the given expression according to the given variable.
     * <p>
     * @param var the variable for the derivative.
     * @return the differentiated expression.
     */
    @Override
    public Expression differentiate(String var) {
        if (this.toString().equals(var)) {
            return new Num(1);
        }
        return new Num(0);
    }

    /**
     * Simplifies the expression to make it easier to read.
     * <p>
     * @return the simplified expression.
     */
    @Override
    public Expression simplify() {
        return this;
    }

}
