
/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;*/
// import java.awt.Color;
// import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App implements ActionListener {

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
        window.setSize(420, 550);
        window.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = decButton;
        operationButtons[5] = equButton;
        operationButtons[6] = delButton;
        operationButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);
        // delButton.setVisible(true);
        // clrButton.setVisible(true);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        window.add(panel);
        window.add(delButton);
        window.add(clrButton);
        window.add(textField);
        window.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        App calculator = new App();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
            return;
        }

        if (e.getSource() == addButton) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            return;
        }

        if (e.getSource() == subButton) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            return;
        }

        if (e.getSource() == mulButton) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            return;
        }

        if (e.getSource() == divButton) {
            operand1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            return;
        }

        if (e.getSource() == equButton) {
            operand2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
                default:
                // throw new AssertionError();
            }
            textField.setText(String.valueOf(result));
            // operand1 = 0.00;
            // operand2 = 0.00;
            operand1 = result;
            return;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            return;
        }

        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText("");

            for (int i = 0; i < text.length() - 1; i++) {
                textField.setText(textField.getText() + text.charAt(i));
            }
            return;
        }

    }
}
