import javax.swing.JOptionPane;

public class EquationSolver
{
    public static void main(String[] args)
    {
        String menuPrompt = "Choose an equation to solve:\n"
                            + "1. Linear Equation (ax + b = 0)\n"
                            + "2. Linear System (2 variables)\n"
                            + "3. Quadratic Equation (ax^2 + bx + c = 0)\n\n"
                            + "Enter 1, 2, or 3:";
        
        String choiceStr = JOptionPane.showInputDialog(null, menuPrompt, "Equation Solver", JOptionPane.QUESTION_MESSAGE);
            
        if(choiceStr == null)
            System.exit(0);
        
        if(choiceStr.equals("1"))
        {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

            if(a == 0)
            {
                if(b == 0)
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                else
                    JOptionPane.showMessageDialog(null, "The equation has no solution.");
            }
            else
            {
                double x = -b / a;
                JOptionPane.showMessageDialog(null, "The solution is x = " + x);
            }
        }
        else if(choiceStr.equals("2"))
        {
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
            double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
            double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if(D == 0)
            {
                if(D1 == 0 && D2 == 0)
                    JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
                else
                    JOptionPane.showMessageDialog(null, "The system has no solution.");
            }
            else
            {
                double x1 = D1 / D;
                double x2 = D2 / D;
                JOptionPane.showMessageDialog(null, "The solutions are x1 = " + x1 + " and x2 = " + x2);
            }
        }
        else if(choiceStr.equals("3"))
        {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

            if(a == 0)
            {
                if(b == 0)
                {
                    if(c == 0)
                        JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                    else
                        JOptionPane.showMessageDialog(null, "The equation has no solution.");
                }
                else JOptionPane.showMessageDialog(null, "The solution is x = " + -c / b);
            }
            else
            {
                double delta = b * b - 4 * a * c;

                if(delta < 0) JOptionPane.showMessageDialog(null, "The equation has no real root.");
                else if(delta == 0)
                {
                    double x = -b / (2 * a);
                    JOptionPane.showMessageDialog(null, "The equation has a double root: x = " + x);
                }
                else
                {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    JOptionPane.showMessageDialog(null, "The equation has two roots:\nx1 = " + x1 + "\nx2 = " + x2);
                }
            }
        }
        else JOptionPane.showMessageDialog(null, "Invalid choice. Please run the program again.");
        
        System.exit(0);
    }
}
