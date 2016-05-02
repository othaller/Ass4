import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 10/04/2016
 */
public class Cos extends UnaryExpression implements Expression {

    /**
     * Instantiates a basic expression.
     * <p>
     * @param exp the required expression.
     */
    public Cos(Expression exp) {
        super(exp);
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param var the required expression.
     */
    public Cos(String var) {
        super(var);
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param num the required expression.
     */
    public Cos(double num) {
        super(num);
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
        return super.evaluate(assignment);
    }

    /**
     * evaluates the result of the expression without variable assignment.
     * <p>
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    @Override
    public double evaluate() throws Exception {
        return super.evaluate();
    }

    /**
     * Returns a list of unique variables in the expression.
     * <p>
     * @return list of variables.
     */
    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    /**
     * Prints the expression in a specific format.
     * <p>
     * @return a string representation of the expression.
     */
    @Override
    public String toString() {
        return "Cos(" + this.exp1.toString() + ")";
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
        Expression e = this.exp1.assign(var, expression);

        return new Cos(e);
    }

    /**
     * returns the derivative of the given expression according to the given variable.
     * <p>
     * @param var the variable for the derivative.
     * @return the differentiated expression.
     */
    @Override
    public Expression differentiate(String var) {
        if (this.getVariables().contains(var)) {
            return new Mult(this.exp1.differentiate(var), new Neg(new Sin(this.exp1)));
        }
        return this;
    }

    /**
     * Simplifies the expression to make it easier to read.
     * <p>
     * an expression without variables evaluates to its result.
     * @return the simplified expression.
     */
    @Override
    public Expression simplify() {
        if (this.getVariables().isEmpty()) {
            try {
                return new Num(this.evaluate());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
