import javax.swing.JOptionPane; 

public class Calculation 
{
    public static void main(String[] args)
    {
        String n_in = JOptionPane.showInputDialog("Enter first number:");
        String m_in = JOptionPane.showInputDialog("Enter second number:");

        double n = Double.parseDouble(n_in);
        double m = Double.parseDouble(m_in);

        double sum = n + m;
        double diff = n - m;
        double prod = n * m;
        double div = n / m;

        JOptionPane.showMessageDialog(null,
                "Sum: " + sum +
                "\nDifference: " + diff +
                "\nProduct: " + prod +
                "\nQuotient: " + div,
                "The results are:",
                JOptionPane.INFORMATION_MESSAGE
            );

        System.exit(0);
    }
}