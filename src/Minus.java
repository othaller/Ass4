import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 10/04/2016
 */
public class Minus extends BinaryExpression implements Expression {

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp1 the expression from the superClass BaseExpression.
     * @param exp2 the provided second expression.
     */
    public Minus(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp the expression from the superClass BaseExpression.
     * @param var the provided second expression.
     */
    public Minus(Expression exp, String var) {
        super(exp, var);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var the expression from the superClass BaseExpression.
     * @param exp the provided second expression.
     */
    public Minus(String var, Expression exp) {
        super(var, exp);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp the expression from the superClass BaseExpression.
     * @param num the provided second expression.
     */
    public Minus(Expression exp, double num) {
        super(exp, num);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num the expression from the superClass BaseExpression.
     * @param exp the provided second expression.
     */
    public Minus(double num, Expression exp) {
        super(num, exp);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num the expression from the superClass BaseExpression.
     * @param var the provided second expression.
     */
    public Minus(double num, String var) {
        super(num, var);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var the expression from the superClass BaseExpression.
     * @param num the provided second expression.
     */
    public Minus(String var, double num) {
        super(var, num);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var1 the expression from the superClass BaseExpression.
     * @param var2 the provided second expression.
     */
    public Minus(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num1 the expression from the superClass BaseExpression.
     * @param num2 the provided second expression.
     */
    public Minus(double num1, double num2) {
        super(num1, num2);
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
        if (!this.getVariables().isEmpty()) {
            throw new Exception("There are unassigned variables");
        }
        return this.exp1.evaluate() - this.exp2.evaluate();
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
        String s1 = this.exp1.toString();
        String s2 = this.exp2.toString();
        String s3 = s1 + " - " + s2;
        return "(" + s3 + ")";
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
        Expression e1 = this.exp1.assign(var, expression);
        Expression e2 = this.exp2.assign(var, expression);

        return new Minus(e1, e2);
    }

    /**
     * returns the derivative of the given expression according to the given variable.
     * <p>
     * @param var the variable for the derivative.
     * @return the differentiated expression.
     */
    @Override
    public Expression differentiate(String var) {
        return new Minus(this.exp1.differentiate(var), this.exp2.differentiate(var));
    }
    /**
     * Simplifies the expression to make it easier to read.
     * <p>
     * Implemented simplifications:
     * <ul>
     *     <li> X - 0 = X
     *     <li> 0 - X = -X
     *     <li> X - X = 0
     *     <li> an expression without variables evaluates to its result.
     * </ul>
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
        if (this.exp1.toString().equals("0.0")) {
            return new Neg(this.exp2.simplify());
        } else if (this.exp2.toString().equals("0.0")) {
            return this.exp1.simplify();
        } else if (this.exp1.toString().equals(this.exp2.toString())) {
            return new Num(0);
        }
        return this;
    }
}
