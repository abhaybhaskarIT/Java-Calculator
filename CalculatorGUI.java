import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    JTextField num1Field, num2Field, resultField;
    JButton addBtn, subBtn, mulBtn, divBtn, clearBtn, exitBtn;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        setLocationRelativeTo(null); // Center window
        getContentPane().setBackground(Color.decode("#f2f2f2"));

        Font font = new Font("Arial", Font.PLAIN, 16);

        // Labels and Inputs
        JLabel label1 = new JLabel("First Number:");
        label1.setFont(font);
        add(label1);
        num1Field = new JTextField();
        num1Field.setFont(font);
        add(num1Field);

        JLabel label2 = new JLabel("Second Number:");
        label2.setFont(font);
        add(label2);
        num2Field = new JTextField();
        num2Field.setFont(font);
        add(num2Field);

        // Operation Buttons
        addBtn = styledButton("+");
        subBtn = styledButton("-");
        mulBtn = styledButton("*");
        divBtn = styledButton("/");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        add(addBtn); add(subBtn); add(mulBtn); add(divBtn);

        // Result field
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(font);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(font);
        add(resultField);

        // Clear and Exit
        clearBtn = styledButton("Clear");
        exitBtn = styledButton("Exit");

        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        add(clearBtn);
        add(exitBtn);

        setVisible(true);
    }

    private JButton styledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.decode("#e0e0e0"));
        button.setFocusPainted(false);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clearBtn) {
                num1Field.setText("");
                num2Field.setText("");
                resultField.setText("");
            } else if (e.getSource() == exitBtn) {
                System.exit(0);
            } else {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;

                if (e.getSource() == addBtn) result = num1 + num2;
                else if (e.getSource() == subBtn) result = num1 - num2;
                else if (e.getSource() == mulBtn) result = num1 * num2;
                else if (e.getSource() == divBtn) {
                    if (num2 == 0) {
                        resultField.setText("Error: Divide by zero");
                        return;
                    }
                    result = num1 / num2;
                }

                resultField.setText(String.valueOf(result));
            }
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
