import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;
import org.mariuszgromada.math.mxparser.mXparser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Locale;

import static javax.swing.UIManager.getString;


class Main extends JFrame implements ActionListener {

    JTextField entry, history;
    double stath1, stath2, apotel, met, memStored;
    static double mm_1;
    int mm = 1, op_flag1 = 0, op_flag2 = 0, number_status = 1;
    char operator;
    JButton But0, But1, But2, But3, But4, But5, But6, But7, But8, But9, clrButton, clrAllButton, pow2Button, pow3Button, expButton,
            facButton, plusButton, minButton, divButton, logButton, recButton, mulButton, eqButton, addSubButton,
            dotButton, mrButton, mcButton, mpButton, mmButton, msButton, sqrtButton, sinButton, cosButton, tanButton, modButton, absButton, backspaceButton;
    Container container;
    JPanel panel_button;

    String format;
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("##########.##########", symbols);


    Main() {


        container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        JPanel historyPanel = new JPanel();

        Font textFont = new Font("SansSerif", Font.BOLD, 20);
        Font buttonFont = new Font("Serif", Font.ITALIC, 25);

        history = new JTextField(25);
        history.setBorder(null);
        history.setEditable(false);
        history.setFont(buttonFont);
        history.setText("0");
        history.setBackground(Color.lightGray);
        history.setHorizontalAlignment(SwingConstants.RIGHT);

        entry = new JTextField(25);
        entry.setEditable(false);
        entry.setFont(buttonFont);
        entry.setText("");
        entry.setHorizontalAlignment(SwingConstants.RIGHT);
        entry.setBorder(null);

        entry.addKeyListener(new KeyAdapter() {
            public void keyTped(KeyEvent keyevent) {
                char c = keyevent.getKeyChar();
                if (c >= '0' && c <= '9') {
                } else {
                    keyevent.consume();
                }
            }
        });
        //        historyPanel.add(historyField, BorderLayout.NORTH);
        historyPanel.add(history);
        textPanel.add(entry);
        panel_button = new JPanel();
        panel_button.setLayout(new GridLayout(9, 4, 2, 2));
        boolean t = true;

        //Row 1

        mcButton = new JButton("MC");
        mcButton.setFont(buttonFont);
        panel_button.add(mcButton);
        mcButton.addActionListener(this);

        mrButton = new JButton("MR");
        mrButton.setFont(buttonFont);
        panel_button.add(mrButton);
        mrButton.addActionListener(this);

        mpButton = new JButton("M+");
        mpButton.setFont(buttonFont);
        panel_button.add(mpButton);
        mpButton.addActionListener(this);

        mmButton = new JButton("M-");
        mmButton.setFont(buttonFont);
        panel_button.add(mmButton);
        mmButton.addActionListener(this);

        msButton = new JButton("MS");
        msButton.setFont(buttonFont);
        panel_button.add(msButton);
        msButton.addActionListener(this);

        //Row 2

        clrAllButton = new JButton("AC");
        clrAllButton.setForeground(Color.RED);
        clrAllButton.setFont(buttonFont);
        panel_button.add(clrAllButton);
        clrAllButton.addActionListener(this);

        clrButton = new JButton("CE");
        clrButton.setForeground(Color.RED);
        clrButton.setFont(buttonFont);
        panel_button.add(clrButton);
        clrButton.addActionListener(this);

        recButton = new JButton("1/x");
        recButton.setFont(buttonFont);
        panel_button.add(recButton);
        recButton.addActionListener(this);

        divButton = new JButton("÷");
        divButton.setFont(buttonFont);
        divButton.addActionListener(this);
        panel_button.add(divButton);

        modButton = new JButton("MOD");
        modButton.setFont(buttonFont);
        modButton.addActionListener(this);
        panel_button.add(modButton);

        absButton = new JButton("ABS");
        absButton.setFont(buttonFont);
        absButton.addActionListener(this);
        panel_button.add(absButton);

        sqrtButton = new JButton("√");
        sqrtButton.setFont(buttonFont);
        panel_button.add(sqrtButton);
        sqrtButton.addActionListener(this);

        //Row 3

        logButton = new JButton("log");
        logButton.setFont(buttonFont);
        panel_button.add(logButton);
        logButton.addActionListener(this);

        sinButton = new JButton("SIN");
        sinButton.setFont(buttonFont);
        panel_button.add(sinButton);
        sinButton.addActionListener(this);

        cosButton = new JButton("COS");
        cosButton.setFont(buttonFont);
        panel_button.add(cosButton);
        cosButton.addActionListener(this);

        tanButton = new JButton("TAN");
        tanButton.setFont(buttonFont);
        panel_button.add(tanButton);
        tanButton.addActionListener(this);

        //Row 4

        pow2Button = new JButton("x²");
        pow2Button.setFont(buttonFont);
        panel_button.add(pow2Button);
        pow2Button.addActionListener(this);

        backspaceButton = new JButton("C");
        backspaceButton.setForeground(Color.BLUE);
        backspaceButton.setFont(buttonFont);
        panel_button.add(backspaceButton);
        backspaceButton.addActionListener(this);

        expButton = new JButton("Exp");
        expButton.setFont(buttonFont);
        panel_button.add(expButton);
        expButton.addActionListener(this);

        facButton = new JButton("n!");
        facButton.setFont(buttonFont);
        panel_button.add(facButton);
        facButton.addActionListener(this);

        //Row 5

        But7 = new JButton("7");
        But7.setForeground(Color.RED);
        But7.setFont(buttonFont);
        panel_button.add(But7);
        But7.addActionListener(this);

        But8 = new JButton("8");
        But8.setForeground(Color.RED);
        But8.setFont(buttonFont);
        panel_button.add(But8);
        But8.addActionListener(this);

        But9 = new JButton("9");
        But9.setForeground(Color.RED);
        But9.setFont(buttonFont);
        panel_button.add(But9);
        But9.addActionListener(this);

        mulButton = new JButton("*");
        mulButton.setFont(buttonFont);
        panel_button.add(mulButton);
        mulButton.addActionListener(this);

        //Row 6

        But4 = new JButton("4");
        But4.setForeground(Color.RED);
        But4.setFont(buttonFont);
        panel_button.add(But4);
        But4.addActionListener(this);

        But5 = new JButton("5");
        But5.setForeground(Color.RED);
        But5.setFont(buttonFont);
        panel_button.add(But5);
        But5.addActionListener(this);

        But6 = new JButton("6");
        But6.setForeground(Color.RED);
        But6.setFont(buttonFont);
        panel_button.add(But6);
        But6.addActionListener(this);

        minButton = new JButton("-");
        minButton.setFont(buttonFont);
        panel_button.add(minButton);
        minButton.addActionListener(this);

        //Row 7

        But1 = new JButton("1");
        But1.setForeground(Color.RED);
        But1.setFont(buttonFont);
        panel_button.add(But1);
        But1.addActionListener(this);

        But2 = new JButton("2");
        But2.setForeground(Color.RED);
        But2.setFont(buttonFont);
        panel_button.add(But2);
        But2.addActionListener(this);

        But3 = new JButton("3");
        But3.setForeground(Color.RED);
        But3.setFont(buttonFont);
        panel_button.add(But3);
        But3.addActionListener(this);

        plusButton = new JButton("+");
        plusButton.setFont(buttonFont);
        panel_button.add(plusButton);
        plusButton.addActionListener(this);

        //Row 8

        addSubButton = new JButton("±");
        addSubButton.setFont(buttonFont);
        panel_button.add(addSubButton);
        addSubButton.addActionListener(this);

        But0 = new JButton("0");
        But0.setForeground(Color.RED);
        But0.setFont(buttonFont);
        panel_button.add(But0);
        But0.addActionListener(this);

        dotButton = new JButton(".");
        dotButton.setFont(buttonFont);
        panel_button.add(dotButton);
        dotButton.addActionListener(this);

        eqButton = new JButton("=");
        eqButton.setForeground(Color.RED);
        eqButton.setFont(buttonFont);
        panel_button.add(eqButton);
        eqButton.addActionListener(this);

        container.add("South", panel_button);
        container.add("Center", textPanel);
        container.add("North", historyPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // ActionListener
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        String historyText;


        if (input.equals("AC")) {
            entry.setText("");
            history.setText("");
        }

        if (input.equals("CE")) {
            entry.setText("");
        }

        if (input.equals("1")) {
            updateText(entry, "1", entry.getCaretPosition());
        }

        if (input.equals("2")) {
            updateText(entry, "2", entry.getCaretPosition());
        }

        if (input.equals("3")) {
            updateText(entry, "3", entry.getCaretPosition());
        }

        if (input.equals("4")) {
            updateText(entry, "4", entry.getCaretPosition());
        }

        if (input.equals("5")) {
            updateText(entry, "5", entry.getCaretPosition());
        }

        if (input.equals("6")) {
            updateText(entry, "6", entry.getCaretPosition());
        }

        if (input.equals("7")) {
            updateText(entry, "7", entry.getCaretPosition());
        }

        if (input.equals("8")) {
            updateText(entry, "8", entry.getCaretPosition());
        }

        if (input.equals("9")) {
            updateText(entry, "9", entry.getCaretPosition());
        }

        if (input.equals("0")) {
            updateText(entry, "0", entry.getCaretPosition());
        }

        if (input.equals("+")) {
            updateText(entry, "+", entry.getCaretPosition());
            entry.requestFocus();
        }

        if (input.equals("-")) {
            updateText(entry, "-", entry.getCaretPosition());
            entry.requestFocus();
        }

        if (input.equals("÷")) {
            updateText(entry, "/", entry.getCaretPosition());
            entry.requestFocus();
        }

        if (input.equals("*")) {
            updateText(entry, "*", entry.getCaretPosition());
            entry.requestFocus();
        }

        if (input.equals("C")) {
            backspaceBtn(entry);
        }

        if (input.equals("=")) {
            equalsButton(entry);
        }
    }

    private static void updateText(JTextField entryText, String strToAdd, int cursorPos) {
        String oldStr = entryText.getText();

        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        entryText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        entryText.setCaretPosition(cursorPos + strToAdd.length());
    }


    private static void backspaceBtn(JTextField textField) {
        int cursorPos = textField.getCaretPosition();
        int textLen = textField.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            StringBuilder text = new StringBuilder(textField.getText());
            text.deleteCharAt(cursorPos - 1);
            textField.setText(text.toString());
            textField.setCaretPosition(cursorPos - 1);
        }
    }


    public void equalsButton(JTextField textField) {
        String userExp = entry.getText().toString();

//        userExp = userExp.replaceAll("÷", "/");
//        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        entry.setText(result);
        entry.setCaretPosition(result.length());

    }


    public static double fact(double n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }


    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        Main f = new Main();
        f.setTitle("Calculator");
        f.setResizable(false);
        f.pack();
        f.setVisible(true);

        mxparserUse();
    }


//  MxParser NonComercialUse Confirmation
    private static void mxparserUse(){
        /* Non-Commercial Use Confirmation */
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("georgetse5");
        /* Verification if use type has been already confirmed */
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        /* Checking use type confirmation message */
        String message = License.getUseTypeConfirmationMessage();
        /* ----------- */
        mXparser.consolePrintln("isCallSuccessful = " + isCallSuccessful);
        mXparser.consolePrintln("isConfirmed = " + isConfirmed);
        mXparser.consolePrintln("message = " + message);
    }
}