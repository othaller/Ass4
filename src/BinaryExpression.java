import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 12/04/2016
 */
public abstract class BinaryExpression extends BaseExpression  {

    protected Expression exp2;

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp1 the expression from the superClass BaseExpression.
     * @param exp2 the provided second expression.
     */
    public BinaryExpression(Expression exp1, Expression exp2) {
        super(exp1);
        this.exp2 = exp2;
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp the expression from the superClass BaseExpression.
     * @param var the provided second expression.
     */
    public BinaryExpression(Expression exp, String var) {
        super(exp);
        this.exp2 = new Var(var);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var the expression from the superClass BaseExpression.
     * @param exp the provided second expression.
     */
    public BinaryExpression(String var, Expression exp) {
        super(var);
        this.exp2 = exp;
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param exp the expression from the superClass BaseExpression.
     * @param num the provided second expression.
     */
    public BinaryExpression(Expression exp, double num) {
        super(exp);
        this.exp2 = new Num(num);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num the expression from the superClass BaseExpression.
     * @param exp the provided second expression.
     */
    public BinaryExpression(double num, Expression exp) {
        super(num);
        this.exp2 = exp;
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num the expression from the superClass BaseExpression.
     * @param var the provided second expression.
     */
    public BinaryExpression(double num, String var) {
        super(num);
        this.exp2 = new Var(var);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var the expression from the superClass BaseExpression.
     * @param num the provided second expression.
     */
    public BinaryExpression(String var, double num) {
        super(var);
        this.exp2 = new Num(num);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param var1 the expression from the superClass BaseExpression.
     * @param var2 the provided second expression.
     */
    public BinaryExpression(String var1, String var2) {
        super(var1);
        this.exp2 = new Var(var2);
    }

    /**
     * Instantiates a binary expression.
     * <p>
     * @param num1 the expression from the superClass BaseExpression.
     * @param num2 the provided second expression.
     */
    public BinaryExpression(double num1, double num2) {
        super(num1);
        this.exp2 = new Num(num2);
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
     * Returns a list of unique variables in the expression.
     * <p>
     * @return list of variables.
     */
    public List<String> getVariables() {
        List<String> vars = new LinkedList<>();
        if (!(this.exp1 instanceof Num)) {
            vars.addAll(exp1.getVariables());
        }
        if (!(this.exp2 instanceof Num)) {
            vars.addAll(exp2.getVariables());
        }
        this.removeDupes(vars);
        return vars;
    }

    /**
     * Checks the type of the current expression and returns a copy of it.
     * <p>
     * @return a copy of the given expression.
     */
    private Expression findType() {
        if (this instanceof Plus) {
            return new Plus(this.exp1, this.exp2);
        } else if (this instanceof Minus) {
            return new Minus(this.exp1, this.exp2);
        } else if (this instanceof Mult) {
            return new Mult(this.exp1, this.exp2);
        } else if (this instanceof Div) {
            return new Div(this.exp1, this.exp2);
        } else if (this instanceof Pow) {
            return new Pow(this.exp1, this.exp2);
        } else {
            return new Log(this.exp1, this.exp2);
        }
    }

    /**
     * Removes duplicate values from the given list.
     * <p>
     * @param vars a list of values.
     */
    private void removeDupes(List<String> vars) {
        for (int i = 0; i < vars.size(); i++) {
            for (int j = i + 1; j < vars.size(); j++) {
                if (vars.get(i).equals(vars.get(j))) {
                    vars.remove(j);
                }
            }
        }
    }

}
