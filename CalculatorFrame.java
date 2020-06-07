import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorFrame extends JFrame {

    JLabel labelNumber1;
    JLabel labelOperator;
    JLabel labelNumber2;
    JLabel labelResultText;
    JLabel labelResult;

    StringBuilder tmp = new StringBuilder();
    StringBuilder number1 = new StringBuilder();
    StringBuilder operator = new StringBuilder();
    StringBuilder number2 = new StringBuilder();
    double result;

    public CalculatorFrame(String title) {

        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 150, 300, 450);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        labelNumber1 = new JLabel("0");
        labelOperator = new JLabel(" ");
        labelNumber2 = new JLabel("0");
        labelResultText = new JLabel("result:");
        labelResult = new JLabel("0");
        Font font = new Font("times new roman", Font.ITALIC, 18);
        labelNumber1.setFont(font);
        labelOperator.setFont(font);
        labelNumber2.setFont(font);
        labelResultText.setFont(font);
        Font fontResult = new Font("times new roman", Font.BOLD, 24);
        labelResult.setFont(fontResult);

        add(labelNumber1);
        add(labelOperator);
        add(labelNumber2);
        add(labelResultText);
        add(labelResult);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        Font fontGrid = new Font("times new roman", Font.BOLD, 16);
        char[] chars = {'C', '<', '^', '/','7', '8', '9', '*', '4', '5', '6', '-', '1', '2', '3', '+', '.', '0', '=', ' '};
        for (int i = 0; i < chars.length; i++) {
            JButton button = new JButton(String.valueOf(chars[i]));
            button.addActionListener(new ButtonListener());
            button.setFont(fontGrid);
            panel.add(button);
        }
        add(panel);
        setVisible(true);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tmp.setLength(0);
            tmp.append(e.getActionCommand());
            if (tmp.charAt(0) >= '0' && tmp.charAt(0) <= '9' || tmp.charAt(0) == '.') {
                if (operator.length() == 0) {
                    number1.append(tmp);
                    labelNumber1.setText(String.valueOf(number1));
                } else {
                    number2.append(tmp);
                    labelNumber2.setText(String.valueOf(number2));
                }
            }
            if (tmp.charAt(0) == '+' || tmp.charAt(0) == '-' || tmp.charAt(0) == '*' || tmp.charAt(0) == '/' || tmp.charAt(0) == '^') {
                    operator.append(tmp);
                    labelOperator.setText(String.valueOf(operator));
            }
            if (tmp.charAt(0) == '=' && number1.length()>0 && number2.length()>0 && operator.length()>0) {
                result = 0;
                switch (operator.charAt(0)) {
                    case '+' : {
                        result = Double.parseDouble(String.valueOf(number1)) + Double.parseDouble(String.valueOf(number2));
                        break;
                    }
                    case '-' : {
                        result = Double.parseDouble(String.valueOf(number1)) - Double.parseDouble(String.valueOf(number2));
                        break;
                    }
                    case '*' : {
                        result = Double.parseDouble(String.valueOf(number1)) * Double.parseDouble(String.valueOf(number2));
                        break;
                    }
                    case '/' : {
                        result = Double.parseDouble(String.valueOf(number1)) / Double.parseDouble(String.valueOf(number2));
                        break;
                    }
                    case '^' : {
                        result = Math.pow(Double.parseDouble(String.valueOf(number1)), Double.parseDouble(String.valueOf(number2)));
                        break;
                    }
                }
                labelResult.setText(String.format("%.2f", result));
            }
            if (tmp.charAt(0) == 'C') {
                number1.setLength(0);
                labelNumber1.setText("0");
                operator.setLength(0);
                labelOperator.setText(" ");
                number2.setLength(0);
                labelNumber2.setText("0");
                result = 0;
                labelResult.setText("0");
            }
            if (tmp.charAt(0) == '<') {
                if (number2.length()>0) {
                    number2.setLength(number2.length() - 1);
                    labelNumber2.setText(String.valueOf(number2));
                } else if (number1.length()>0) {
                    number1.setLength(number1.length() - 1);
                    labelNumber1.setText(String.valueOf(number1));
                }
            }
        }
    }

}
