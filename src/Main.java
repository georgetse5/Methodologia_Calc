import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.License;
import org.mariuszgromada.math.mxparser.mXparser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Locale;

import static javax.swing.UIManager.getString;


class Main extends JFrame implements KeyListener, ActionListener{

    JTextField entry, history;
    double stath1, stath2, apotel, met, memStored;
    static double mm_1;
    int mm = 1, op_flag1 = 0, op_flag2 = 0, number_status = 1;
    char operator;
    JButton But0, But1, But2, But3, But4, But5, But6, But7, But8, But9, clrButton, clrAllButton, pow2Button, leftParButton, expButton,
            facButton, plusButton, minButton, divButton, logButton, degreesToRadButton, mulButton, eqButton, addSubButton,
            dotButton, mrButton, mcButton, mpButton, mmButton, msButton, sqrtButton, sinButton, cosButton, rightParButton, piButton, absButton, backspaceButton;
    Container container;
    JPanel panel_button;

    ArrayList<Character> keyCharList = new ArrayList<>() {{
        add('1'); add('2'); add('3'); add('4'); add('5');
        add('6'); add('7'); add('8'); add('9'); add('0');
        add('/'); add('*'); add('-'); add('+'); add('(');
        add(')'); add('^'); add('.');
        // "Enter" keycode 10
    }};

    String format, historyText="";
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("##########.##########", symbols);


    Main() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setVisible(true);

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
        history.setText("");
        history.setBackground(Color.lightGray);
        history.setHorizontalAlignment(SwingConstants.RIGHT);

        entry = new JTextField(25);
        entry.setEditable(false);
        entry.setFont(buttonFont);
        entry.setText("");
        entry.setHorizontalAlignment(SwingConstants.RIGHT);
        entry.setBorder(null);


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
        mcButton.setFocusable(false);
        mcButton.addActionListener(this);

        mrButton = new JButton("MR");
        mrButton.setFont(buttonFont);
        panel_button.add(mrButton);
        mrButton.setFocusable(false);
        mrButton.addActionListener(this);

        mpButton = new JButton("M+");
        mpButton.setFont(buttonFont);
        panel_button.add(mpButton);
        mpButton.setFocusable(false);
        mpButton.addActionListener(this);

        mmButton = new JButton("M-");
        mmButton.setFont(buttonFont);
        panel_button.add(mmButton);
        mmButton.setFocusable(false);
        mmButton.addActionListener(this);

        msButton = new JButton("MS");
        msButton.setFont(buttonFont);
        panel_button.add(msButton);
        msButton.setFocusable(false);
        msButton.addActionListener(this);

        //Row 2

        clrAllButton = new JButton("AC");
        clrAllButton.setForeground(Color.RED);
        clrAllButton.setFont(buttonFont);
        panel_button.add(clrAllButton);
        clrAllButton.setFocusable(false);
        clrAllButton.addActionListener(this);

        clrButton = new JButton("CE");
        clrButton.setForeground(Color.RED);
        clrButton.setFont(buttonFont);
        panel_button.add(clrButton);
        clrButton.setFocusable(false);
        clrButton.addActionListener(this);

        pow2Button = new JButton("x²");
        pow2Button.setFont(buttonFont);
        panel_button.add(pow2Button);
        pow2Button.setFocusable(false);
        pow2Button.addActionListener(this);

        piButton = new JButton("Π");
        piButton.setFont(buttonFont);
        piButton.setFocusable(false);
        piButton.addActionListener(this);
        panel_button.add(piButton);

        degreesToRadButton = new JButton("rad");
        degreesToRadButton.setFont(buttonFont);
        degreesToRadButton.setFocusable(false);
        degreesToRadButton.addActionListener(this);
        panel_button.add(degreesToRadButton);

        absButton = new JButton("ABS");
        absButton.setFont(buttonFont);
        absButton.setFocusable(false);
        absButton.addActionListener(this);
        panel_button.add(absButton);

        sqrtButton = new JButton("√");
        sqrtButton.setFont(buttonFont);
        panel_button.add(sqrtButton);
        sqrtButton.setFocusable(false);
        sqrtButton.addActionListener(this);

        //Row 3

        logButton = new JButton("log");
        logButton.setFont(buttonFont);
        panel_button.add(logButton);
        logButton.setFocusable(false);
        logButton.addActionListener(this);

        sinButton = new JButton("SIN");
        sinButton.setFont(buttonFont);
        panel_button.add(sinButton);
        sinButton.setFocusable(false);
        sinButton.addActionListener(this);

        cosButton = new JButton("COS");
        cosButton.setFont(buttonFont);
        panel_button.add(cosButton);
        cosButton.setFocusable(false);
        cosButton.addActionListener(this);

        expButton = new JButton("Exp");
        expButton.setFont(buttonFont);
        panel_button.add(expButton);
        expButton.setFocusable(false);
        expButton.addActionListener(this);

        //Row 4

        backspaceButton = new JButton("C");
        backspaceButton.setForeground(Color.BLUE);
        backspaceButton.setFont(buttonFont);
        panel_button.add(backspaceButton);
        backspaceButton.setFocusable(false);
        backspaceButton.addActionListener(this);

        leftParButton = new JButton("(");
        leftParButton.setFont(buttonFont);
        panel_button.add(leftParButton);
        leftParButton.setFocusable(false);
        leftParButton.addActionListener(this);

        rightParButton = new JButton(")");
        rightParButton.setFont(buttonFont);
        panel_button.add(rightParButton);
        rightParButton.setFocusable(false);
        rightParButton.addActionListener(this);

        divButton = new JButton("÷");
        divButton.setFont(buttonFont);
        divButton.setFocusable(false);
        divButton.addActionListener(this);
        panel_button.add(divButton);

        //Row 5

        But7 = new JButton("7");
        But7.setForeground(Color.RED);
        But7.setFont(buttonFont);
        panel_button.add(But7);
        But7.setFocusable(false);
        But7.addActionListener(this);

        But8 = new JButton("8");
        But8.setForeground(Color.RED);
        But8.setFont(buttonFont);
        panel_button.add(But8);
        But8.setFocusable(false);
        But8.addActionListener(this);

        But9 = new JButton("9");
        But9.setForeground(Color.RED);
        But9.setFont(buttonFont);
        panel_button.add(But9);
        But9.setFocusable(false);
        But9.addActionListener(this);

        mulButton = new JButton("*");
        mulButton.setFont(buttonFont);
        panel_button.add(mulButton);
        mulButton.setFocusable(false);
        mulButton.addActionListener(this);

        //Row 6

        But4 = new JButton("4");
        But4.setForeground(Color.RED);
        But4.setFont(buttonFont);
        panel_button.add(But4);
        But4.setFocusable(false);
        But4.addActionListener(this);

        But5 = new JButton("5");
        But5.setForeground(Color.RED);
        But5.setFont(buttonFont);
        panel_button.add(But5);
        But5.setFocusable(false);
        But5.addActionListener(this);

        But6 = new JButton("6");
        But6.setForeground(Color.RED);
        But6.setFont(buttonFont);
        panel_button.add(But6);
        But6.setFocusable(false);
        But6.addActionListener(this);

        minButton = new JButton("-");
        minButton.setFont(buttonFont);
        panel_button.add(minButton);
        minButton.setFocusable(false);
        minButton.addActionListener(this);

        //Row 7

        But1 = new JButton("1");
        But1.setForeground(Color.RED);
        But1.setFont(buttonFont);
        panel_button.add(But1);
        But1.setFocusable(false);
        But1.addActionListener(this);

        But2 = new JButton("2");
        But2.setForeground(Color.RED);
        But2.setFont(buttonFont);
        panel_button.add(But2);
        But2.setFocusable(false);
        But2.addActionListener(this);

        But3 = new JButton("3");
        But3.setForeground(Color.RED);
        But3.setFont(buttonFont);
        panel_button.add(But3);
        But3.setFocusable(false);
        But3.addActionListener(this);

        plusButton = new JButton("+");
        plusButton.setFont(buttonFont);
        panel_button.add(plusButton);
        plusButton.setFocusable(false);
        plusButton.addActionListener(this);

        //Row 8

        addSubButton = new JButton("±");
        addSubButton.setFont(buttonFont);
        panel_button.add(addSubButton);
        addSubButton.setFocusable(false);
        addSubButton.addActionListener(this);

        But0 = new JButton("0");
        But0.setForeground(Color.RED);
        But0.setFont(buttonFont);
        panel_button.add(But0);
        But0.setFocusable(false);
        But0.addActionListener(this);

        dotButton = new JButton(".");
        dotButton.setFont(buttonFont);
        panel_button.add(dotButton);
        dotButton.setFocusable(false);
        dotButton.addActionListener(this);

        eqButton = new JButton("=");
        eqButton.setForeground(Color.RED);
        eqButton.setFont(buttonFont);
        panel_button.add(eqButton);
        eqButton.setFocusable(false);
        eqButton.addActionListener(this);

        container.add("South", panel_button);
        container.add("Center", textPanel);
        container.add("North", historyPanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        char tempChar = e.getKeyChar();
        int tempCode = e.getKeyCode();

        if (keyCharList.contains(tempChar)){
            updateText(entry, String.valueOf(tempChar), entry.getCaretPosition());
        }
        if (tempCode == 10) {
            equalsButton(entry);
        }
        if (tempCode == 8) {
            backspaceBtn(entry);
        }
        if (tempCode == 127) {
            entry.setText("");
        }
        if (tempChar == ',') {
            updateText(entry, ".", entry.getCaretPosition());
        }

//        System.out.println("You Released key char: " + e.getKeyChar());
//        System.out.println("You Released key char: " + e.getKeyCode());
    }


    // ActionListener
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();


        if (input.equals("AC")) {
            historyText = "";
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
        }

        if (input.equals("-")) {
            updateText(entry, "-", entry.getCaretPosition());
        }

        if (input.equals("÷")) {
            updateText(entry, "/", entry.getCaretPosition());
        }

        if (input.equals("MOD")) {
            updateText(entry, "mod(", entry.getCaretPosition());
        }

        if (input.equals("ABS")) {
            updateText(entry, "abs(", entry.getCaretPosition());
        }

        if (input.equals("log")) {
            updateText(entry, "log10(", entry.getCaretPosition());
        }

        if (input.equals("*")) {
            updateText(entry, "*", entry.getCaretPosition());
        }

        if (input.equals("C")) {
            backspaceBtn(entry);
        }

        if (input.equals("(")) {
            updateText(entry, "(", entry.getCaretPosition());
        }

        if (input.equals(")")) {
            updateText(entry, ")", entry.getCaretPosition());
        }

        if (input.equals("SIN")) {
            updateText(entry, "sin(", entry.getCaretPosition());
        }

        if (input.equals("COS")) {
            updateText(entry, "cos(", entry.getCaretPosition());
        }

        if (input.equals("Π")) {
            updateText(entry, "pi", entry.getCaretPosition());
        }

        if (input.equals("rad")) {
            updateText(entry, "rad(", entry.getCaretPosition());
        }

        if (input. equals("x²")) {
            updateText(entry, "^2", entry.getCaretPosition());
        }

        if (input. equals("Exp")) {
            updateText(entry, "^", entry.getCaretPosition());
        }

        if (input. equals("√")) {
            updateText(entry, "sqrt(", entry.getCaretPosition());
        }

        if (input.equals("=")) {
            equalsButton(entry);
        }

        if (input.equals(".")) {
            updateText(entry, ".", entry.getCaretPosition());
        }

        if (input.equals("±")) {
            String str = entry.getText();
            char firstChar = str.charAt(0);
            String minusSymbol = "-";
            String pureStr;
            if (firstChar == '-') {
                pureStr = str.substring(1);
                entry.setText(pureStr);
            }
            else if (firstChar != '-') {
                pureStr = minusSymbol + str;
                entry.setText(pureStr);
                }
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
        historyText = historyText + " || " + entry.getText();
        history.setText(historyText);
        String userExp = entry.getText();

//        userExp = userExp.replaceAll("÷", "/");
//        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        entry.setText(result);
        entry.setCaretPosition(result.length());

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