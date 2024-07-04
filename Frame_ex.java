import java.awt.*;
import java.awt.event.*;

public class Frame_ex extends Frame implements ActionListener {
    TextField t1, t2, t3, t4;
    Label lb1, lb2, lb3, lb4;
    Button b1, b2, b3, b4; // Buttons for operations: +, -, *, /
    int num1, num2; // Variables to store operands
    String operation; // Variable to store current operation

    Frame_ex() {
        setLayout(new FlowLayout());
        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);
        t4 = new TextField(10);
        lb1 = new Label("Number 1");
        lb2 = new Label("Number 2");
        lb3 = new Label("Operation");
        lb4 = new Label("Result");
        b1 = new Button("+");
        b2 = new Button("-");
        b3 = new Button("*");
        b4 = new Button("/");

        add(lb1);
        add(t1);
        add(lb2);
        add(t2);
        add(lb3);
        add(t3);
        add(lb4);
        add(t4);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(250, 300);
        setTitle("Calculator");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // Get input numbers
            num1 = Integer.parseInt(t1.getText());
            num2 = Integer.parseInt(t2.getText());

            // Determine which button was clicked
            if (ae.getSource() == b1) { // Addition
                operation = "+";
                int result = num1 + num2;
                t4.setText(String.valueOf(result));
            } else if (ae.getSource() == b2) { // Subtraction
                operation = "-";
                int result = num1 - num2;
                t4.setText(String.valueOf(result));
            } else if (ae.getSource() == b3) { // Multiplication
                operation = "*";
                int result = num1 * num2;
                t4.setText(String.valueOf(result));
            } else if (ae.getSource() == b4) { // Division
                operation = "/";
                if (num2 == 0) {
                    t4.setText("Error: Divide by zero");
                } else {
                    double result = (double) num1 / num2;
                    t4.setText(String.valueOf(result));
                }
            }
        } catch (NumberFormatException ex) {
            t4.setText("Invalid input");
        }
    }

    public static void main(String args[]) {
        new Frame_ex();
    }
}
