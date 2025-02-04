
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {

    JFrame window;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] operationButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    double operand1 = 0.00, operand2 = 0.00, result = 0.00;
    char operator;

    App() {
        window = new JFrame("Calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(420, 450);
        window.setLayout(null);

        window.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        App calculator = new App();

    }
}
