import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 12/04/2016
 */

public abstract class UnaryExpression extends BaseExpression {

    /**
     * Instantiates a basic expression.
     * <p>
     * @param exp the required expression.
     */
    public UnaryExpression(Expression exp) {
        super(exp);
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param var the required expression.
     */
    public UnaryExpression(String var) {
        super(var);
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param num the required expression.
     */
    public UnaryExpression(double num) {
        super(num);
    }

    /**
     * Assigns values to variables and evaluates the result of the expression.
     * <p>
     * @param assignment a map of the variables and their assigned values.
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        Expression e = findType();
        for (String key: assignment.keySet()) {
            e = e.assign(key, new Num(assignment.get(key)));
        }
        if (!e.getVariables().isEmpty()) {
            throw new Exception("There are unassigned variables");
        }
        return e.evaluate();
    }

    /**
     * evaluates the result of the expression without variable assignment.
     * <p>
     * @return the result of the expression.
     * @throws Exception when there are unassigned variables.
     */
    public double evaluate() throws Exception {
        if (!this.getVariables().isEmpty()) {
            throw new Exception("There are unassigned variables");
        }
        if (this instanceof Cos) {
            return Math.cos(this.exp1.evaluate());
        } else if (this instanceof Sin) {
            return Math.sin(this.exp1.evaluate());
        } else {
            return this.exp1.evaluate() * -1;
        }
    }

    /**
     * Returns a list of unique variables in the expression.
     * <p>
     * @return list of variables.
     */
    public List<String> getVariables() {
        List<String> vars = new LinkedList<>();
        if (!(this.exp1 instanceof Num)) {
            vars.addAll(exp1.getVariables());
        }
        return vars;
    }

    /**
     * Checks the type of the current expression and returns a copy of it.
     * <p>
     * @return a copy of the given expression.
     */
    private Expression findType() {
        if (this instanceof Cos) {
            return new Cos(this.exp1);
        } else if (this instanceof Sin) {
            return new Sin(this.exp1);
        } else {
            return new Neg(this.exp1);
        }
    }

}