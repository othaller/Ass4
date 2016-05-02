import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 10/04/2016
 */
public class ExpressionTest {

    public static void main(String[] args) throws Exception {

        // Expressions
        //Expression e1 = new Plus(new Mult(new Plus(3, 6), "X"), new Mult(new Mult(4, "X"), new Sin(0)));
        //Expression e1 = new Mult(new Log(new Mult(9, "X"), new Mult(9, "X")), new Mult(2, "Y"));
        //Expression e1 = new Plus(new Plus(new Mult(2, "X"), new Sin(new Mult(4, "Y"))), new Pow("e", "X"));
        Expression e1 = new Pow("X", 4);

        // String tester
        System.out.println("Expression: " + e1);

        // assignment tester
        Expression e5 = e1.assign("X", new Num(2));
        e5 = e5.assign("Y", new Num(0.25));
        e5 = e5.assign("e", new Num(2.71));
        System.out.println("Assigned expression: " + e5);

        //evaluate tester
        Map<String, Double> assignment = new TreeMap<>();
        assignment.put("X", 2.0);
        assignment.put("Y", 0.25);
        assignment.put("e", 2.71);
        System.out.println("The result is: " + e1.evaluate(assignment));

        // getVariables tester
        List<String> vars = e1.getVariables();
        System.out.println("List of variables:");
        for (String v: vars) {
            System.out.println(v);
        }

        // differentiation test
        Expression de1 = e1.differentiate("X");
        System.out.println("Differentiated Expression: " + de1);
        System.out.println("Evaluated differentiated expression: " + de1.evaluate(assignment));

        // Simplification test
        System.out.println("Simplified expression: " + de1.simplify());

    }
}
