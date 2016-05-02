/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 12/04/2016
 */

public abstract class BaseExpression {

    protected Expression exp1;

    /**
     * Instantiates a basic expression.
     * <p>
     * @param exp the required expression.
     */
    public BaseExpression(Expression exp) {
        this.exp1 = exp;
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param var the required expression.
     */
    public BaseExpression(String var) {
        this.exp1 = new Var(var);
    }

    /**
     * Instantiates a basic expression.
     * <p>
     * @param num the required expression.
     */
    public BaseExpression(double num) {
        this.exp1 = new Num(num);
    }

}
