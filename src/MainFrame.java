import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import static java.lang.Integer.parseInt;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    public String fullTextString = " "; //for history
    public String textString = ""; //for textField
    public double firstNumber, secondNumber;
    public double equals;
    public static String bufferText = "";  //for testString
    public static String setOperation = ""; //for logic

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //add icons numbers, not text
    public void setDefaultNums() {
        //numbers
        JPanel forNumbbers = new JPanel(), firstLine = new JPanel(), secondLine = new JPanel(), thirdLine = new JPanel(), fourLine = new JPanel();

        forNumbbers.setBorder(new TitledBorder("Numbers"));
        forNumbbers.setLayout(new BoxLayout(forNumbbers, BoxLayout.Y_AXIS));

        firstLine.setLayout(new BoxLayout(firstLine, BoxLayout.X_AXIS));
        secondLine.setLayout(new BoxLayout(secondLine, BoxLayout.X_AXIS));
        thirdLine.setLayout(new BoxLayout(thirdLine, BoxLayout.X_AXIS));
        fourLine.setLayout(new BoxLayout(fourLine, BoxLayout.X_AXIS));

        JButton number1Button = new JButton("1"), number2Button = new JButton("2"),
                number3Button = new JButton("3"), number4Button = new JButton("4"), number5Button = new JButton("5"),
                number6Button = new JButton("6"), number7Button = new JButton("7"), number8Button = new JButton("8"),
                number9Button = new JButton("9"), number0Button = new JButton("0"), multiplicationButton = new JButton("*"),
                divisionButton = new JButton(":"), plusButton = new JButton("+"), minucButton = new JButton("-"),
                equalsButton = new JButton("="), BUFF2 = new JButton("  ");

        number1Button.setSize(50, 50);
        number2Button.setSize(100, 100);
        //added content

        firstLine.add(number7Button);
        firstLine.add(number8Button);
        firstLine.add(number9Button);
        firstLine.add(number9Button);
        firstLine.add(divisionButton);

        secondLine.add(number4Button);
        secondLine.add(number5Button);
        secondLine.add(number6Button);
        secondLine.add(number6Button);
        secondLine.add(multiplicationButton);


        thirdLine.add(number1Button);
        thirdLine.add(number2Button);
        thirdLine.add(number3Button);
        thirdLine.add(number3Button);
        thirdLine.add(minucButton);

        fourLine.add(equalsButton);
        fourLine.add(number0Button);
        fourLine.add(BUFF2);
        fourLine.add(plusButton);

        forNumbbers.add(firstLine);
        forNumbbers.add(secondLine);
        forNumbbers.add(thirdLine);
        forNumbbers.add(fourLine);
        forNumbbers.setBounds(10, 100, 265, 240);
        contentPane.add(forNumbbers, BorderLayout.CENTER);

        //actions number
        List<JButton> buttons = Arrays.asList(number0Button, number1Button, number2Button, number3Button, number4Button, number5Button, number6Button, number7Button, number8Button, number9Button);
        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bufferText += button.getText();
                    textString += button.getText();
                    textField.setText(textString);
                }
            });
        }
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = parseInt(bufferText);
                textString += " : ";
                textField.setText(textString);
                bufferText = "";
                setOperation = ":";
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = parseInt(bufferText);
                textString += " * ";
                textField.setText(textString);
                bufferText = "";
                setOperation = "*";

            }
        });
        minucButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = parseInt(bufferText);
                textString += " - ";
                textField.setText(textString);
                bufferText = "";
                setOperation = "-";
            }
        });
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = parseInt(bufferText);
                textString += " + ";
                textField.setText(textString);
                bufferText = "";
                setOperation = "+";
            }
        });
        Logic logic = new Logic();
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondNumber = parseInt(bufferText);
                if (setOperation.equals(":") && secondNumber == 0) {
                    textString += " ??? ERROR!! DIVISION BY 0";
                } else {
                    equals = logic.doOperation(setOperation, (double) firstNumber, (double) secondNumber);
                    textString += " = " +  equals;
                }
                textField.setText(textString);
                fullTextString += textString + "\n";
                textArea.setText(fullTextString);
                textString = "";
                firstNumber = 0;
                secondNumber = 0;
                bufferText = "";
            }
        });
        forNumbbers.add(textArea, BorderLayout.SOUTH);

    } //numbers panel

    public JTextField textField = new JTextField();
    public JTextArea textArea = new JTextArea();

    public MainFrame() {
        //default
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 150, dimension.height / 2 - 200, 300, 400);
        setTitle("Calculator");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        //content
        textField.setBounds(10, 10, 265, 50);
        setDefaultNums();
        contentPane.add(textField, BorderLayout.NORTH);
        textField.setEditable(false);
        setContentPane(contentPane);

        //history
        textArea.setBorder(new TitledBorder("HISTORY"));
        textArea.setVisible(true);
        textArea.setSize(255, 100);

        //add bg (need edits) NEED HELP AAAAAAAAAAAAAAAAAAAa
//        JLabel backGrounf = new JLabel("");

//        ImageIcon imageIcon = new ImageIcon("resuorse/bgIcon.gif"); // load the image to a imageIcon
//        Image image = imageIcon.getImage(); // transform it
//        Image newimg = image.getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//        imageIcon = new ImageIcon(newimg);
//
//        backGrounf.setIcon(imageIcon);
//        backGrounf.setBounds(0, 0, 300, 400);
//        contentPane.add(backGrounf);
//        contentPane.setComponentZOrder(backGrounf, 0);
    }
}