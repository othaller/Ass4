import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 10/04/2016
 */
public interface Expression {

    /**
     * Assigns values to variables and evaluates the result of the expression.
     * <p>
     * @param assignment a map of the variables and their assigned values.
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluates the result of the expression without variable assignment.
     * <p>
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    double evaluate() throws Exception;

    /**
     * Returns a list of unique variables in the expression.
     * <p>
     * @return list of variables.
     */
    List<String> getVariables();

    /**
     * Prints the expression in a specific format.
     * <p>
     * @return a string representation of the expression.
     */
    String toString();

    /**
     * assigns the given values to the variables.
     * <p>
     * @param var the variables to be assigned.
     * @param expression the expression to assigned.
     * @return a new expression with the assigned variables.
     */
    Expression assign(String var, Expression expression);

    /**
     * returns the derivative of the given expression according to the given variable.
     * <p>
     * @param var the variable for the derivative.
     * @return the differentiated expression.
     */
    Expression differentiate(String var);

    /**
     * Simplifies the expression to make it easier to read.
     * <p>
     * Implemented simplifications:
     * <ul>
     *     <li> x * 1 = x (also 1 * x = x)
     *     <li> x * 0 = 0 (also 0 * x = 0)
     *     <li> x + 0 = x (also 0 + x = x)
     *     <li> x / x = 1
     *     <li> X / 1 = x
     *     <li> X - 0 = X
     *     <li> 0 - X = -X
     *     <li> X - X = 0
     *     <li> log(x, x) = 1
     *     <li> an expression without variables evaluates to its result.
     * </ul>
     * @return the simplified expression.
     */
    Expression simplify();
}
