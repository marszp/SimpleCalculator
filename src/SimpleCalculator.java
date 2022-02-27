import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator implements Runnable{

    //Instance Variable = Fields
    private Double ValueA = 0.0;
    private String ValueAString ="0.0";
    private Double ValueB = 0.0;
    private String ValueBString = "0.0";
    private Double Score = 0.0;
    private String SignOfMethod = null;
    private Boolean isMethodSelected = false;
    private String acctualSign = "+";
    JLabel myCalculatorScoreLabel = new JLabel(""+getScore(),SwingConstants.CENTER);
    JLabel myCalculatorMethodLabel = new JLabel(("A= "+ getValueA() +" "+getSignOfMethod() +" B= " + getValueB()),SwingConstants.CENTER);

    // Getters
    public Double getValueA() {
        return ValueA;
    }
    public Double getValueB() {
        return ValueB;
    }
    public String getValueAString() { return ValueAString; }
    public String getValueBString() { return ValueBString; }
    public String getSignOfMethod() {
        return SignOfMethod;
    }
    public Double getScore() {
        return Score;
    }
    public Boolean getIsMethodSelected() { return isMethodSelected; }
    public String getAcctualSign() { return acctualSign; }

    // Setters
    public void setValueA(Double tempValueA) { ValueA = tempValueA; }
    public void setValueB(Double tempValueB) { ValueB = tempValueB; }
    public void setScore(Double tempScore) { Score = tempScore; }
    public void setValueAString(String tempValueAString) { ValueAString = tempValueAString; }
    public void setValueBString(String tempValueBString) { ValueBString = tempValueBString; }
    public void setIsMethodSelected(Boolean tempIsMethodSelected) {isMethodSelected = tempIsMethodSelected;}
    public void setAcctualSign(String tempAcctualSign) { acctualSign = tempAcctualSign; }

    // Second trhead rund method - For GUI update
    @Override
    public void run() {
        while(true){
            try {
                if (getValueAString() != "0.0") {
                    setValueA(Double.parseDouble(getValueAString()));
                }
                if (getValueBString() != "0.0") {
                    if (getValueBString() != "-") {
                        setValueB(Double.parseDouble(getValueBString()));
                    }
                }
                //if (true) {
                // Add here depencendy for "+" & "-"
                myCalculatorScoreLabel.setText(Score.toString());
                myCalculatorMethodLabel.setText("A = " + ValueAString + " B = " + ValueBString);
                //}
            }catch (Exception exp){
                exp.printStackTrace();
            }
        }
    }

    // Method for GUI
    // Main method - Create instanca of calculator + creat GUI + Second thread
    public static void main(String[] args) {
        SimpleCalculator myFirstCalculator = new SimpleCalculator();
        Thread firstThread = new Thread(myFirstCalculator);
        firstThread.start();
        myFirstCalculator.createGuiMethod();
    }
    public void createGuiMethod(){
        // Buttons
        JButton myCalculatorAddButton = new JButton(" + ");
        JButton myCalculatorSubstractButton = new JButton(" - ");
        JButton myCalculatorEqualButton = new JButton(" = ");
        JButton myCalculatorOneButton = new JButton(" 1 ");
        JButton myCalculatorTwoButton = new JButton(" 2 ");
        JButton myCalculatorThreeButton = new JButton(" 3 ");
        JButton myCalculatorFourButton = new JButton(" 4 ");
        JButton myCalculatorFiveButton = new JButton(" 5 ");
        JButton myCalculatorSixButton = new JButton(" 6 ");
        JButton myCalculatorSevenButton = new JButton(" 7 ");
        JButton myCalculatorEightButton = new JButton(" 8 ");
        JButton myCalculatorNineButton = new JButton(" 9 ");
        JButton myCalculatorZeroButton = new JButton(" 0 ");
        JButton myCalculatorDotButotn = new JButton("  .  ");
        JButton myCalculatorSignButton = new JButton("-/+");
        JButton myCalculatorClearButton = new JButton("CC");

        // Frame
        JFrame myCalculatorFrame = new JFrame("My First Calculator");
        myCalculatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myCalculatorFrame.setSize(300,318);
        myCalculatorFrame.setVisible(true);

        // Labels
        myCalculatorScoreLabel.setPreferredSize(new Dimension(200,60));
        Border borderForLabel = BorderFactory.createLineBorder(Color.BLACK,5);
        myCalculatorScoreLabel.setBorder(borderForLabel);
        myCalculatorScoreLabel.setFont(new Font("Serif",Font.PLAIN,20));

        // Panels
        JPanel panelForCalcButtons = new JPanel();
        JPanel panelForCentralButtons = new JPanel();
        JPanel panelForEastButtons = new JPanel();
        JPanel panelForWeastButtons = new JPanel();
        JPanel panelForMethodButtons = new JPanel();
        JPanel panelForMethodLabel = new JPanel();
        JPanel panelForScore = new JPanel();

        // Setting frame colors and orientation
        myCalculatorFrame.getContentPane().add(panelForScore,BorderLayout.NORTH);
        panelForScore.setBackground(Color.GREEN);
        myCalculatorFrame.getContentPane().add(panelForCalcButtons,BorderLayout.CENTER);
        panelForCalcButtons.setBackground(Color.YELLOW);
        myCalculatorFrame.getContentPane().add(panelForMethodLabel,BorderLayout.SOUTH);
        panelForMethodLabel.setBackground(Color.BLUE);

        // Upper panel for score label
        panelForScore.add(myCalculatorScoreLabel,BorderLayout.CENTER);

        // Central panel for buttons -> East side
        panelForCalcButtons.add(panelForEastButtons,BorderLayout.EAST);
        panelForEastButtons.setBackground(Color.BLACK);
        panelForEastButtons.setPreferredSize(new Dimension(50,130));
        panelForEastButtons.add(myCalculatorSevenButton,BorderLayout.NORTH);
        panelForEastButtons.add(myCalculatorFourButton,BorderLayout.CENTER);
        panelForEastButtons.add(myCalculatorOneButton,BorderLayout.SOUTH);
        panelForEastButtons.add(myCalculatorSignButton,BorderLayout.SOUTH);

        // Central panel for buttons -> Central side
        panelForCalcButtons.add(panelForCentralButtons,BorderLayout.CENTER);
        panelForCentralButtons.setBackground(Color.BLUE);
        panelForCentralButtons.setPreferredSize(new Dimension(50,130));
        panelForCentralButtons.add(myCalculatorEightButton,BorderLayout.NORTH);
        panelForCentralButtons.add(myCalculatorFiveButton,BorderLayout.CENTER);
        panelForCentralButtons.add(myCalculatorTwoButton,BorderLayout.SOUTH);
        panelForCentralButtons.add(myCalculatorZeroButton,BorderLayout.SOUTH);

        // Central panel for buttons -> West side
        panelForCalcButtons.add(panelForWeastButtons,BorderLayout.WEST);
        panelForWeastButtons.setBackground(Color.RED);
        panelForWeastButtons.setPreferredSize(new Dimension(50,130));
        panelForWeastButtons.add(myCalculatorNineButton,BorderLayout.NORTH);
        panelForWeastButtons.add(myCalculatorSixButton,BorderLayout.CENTER);
        panelForWeastButtons.add(myCalculatorThreeButton,BorderLayout.SOUTH);
        panelForWeastButtons.add(myCalculatorDotButotn,BorderLayout.SOUTH);

        // Central panel for buttons - additional panel for method buttons
        panelForCalcButtons.add(panelForMethodButtons,BorderLayout.WEST);
        panelForMethodButtons.setBackground(Color.PINK);
        panelForMethodButtons.setPreferredSize(new Dimension(50,130));
        panelForMethodButtons.add(myCalculatorClearButton,BorderLayout.NORTH);
        panelForMethodButtons.add(myCalculatorAddButton,BorderLayout.CENTER);
        panelForMethodButtons.add(myCalculatorSubstractButton,BorderLayout.SOUTH);
        panelForMethodButtons.add(myCalculatorEqualButton,BorderLayout.SOUTH);

        // South panel for method label
        panelForMethodLabel.add(myCalculatorMethodLabel,BorderLayout.CENTER);
        myCalculatorMethodLabel.setPreferredSize(new Dimension(200,60));
        myCalculatorMethodLabel.setBorder(borderForLabel);
        myCalculatorMethodLabel.setFont(new Font("Serif",Font.PLAIN,20));

        // Action Listeners for buttons
        myCalculatorAddButton.addActionListener(new AddCurrentValues());
        myCalculatorSubstractButton.addActionListener(new SubstractCurrentValues());
        myCalculatorEqualButton.addActionListener(new EqualsFromCurrentValues());
        myCalculatorOneButton.addActionListener(new SetOneNumber());
        myCalculatorTwoButton.addActionListener(new SetTwoNumber());
        myCalculatorThreeButton.addActionListener(new SetThreeNumber());
        myCalculatorFourButton.addActionListener(new SetFourNumber());
        myCalculatorFiveButton.addActionListener(new SetFiveNumber());
        myCalculatorSixButton.addActionListener(new SetSixNumber());
        myCalculatorSevenButton.addActionListener(new SetSevenNumber());
        myCalculatorEightButton.addActionListener(new SetEightNumber());
        myCalculatorNineButton.addActionListener(new SetNineNumber());
        myCalculatorDotButotn.addActionListener(new InsertDotToValue());
        myCalculatorZeroButton.addActionListener(new SetZeroNumber());
        myCalculatorSignButton.addActionListener(new ChangeSignOfValue());
        myCalculatorClearButton.addActionListener(new ClearLabelFromData());
    }

    // Inner Classes for perform ActionListener with specified methods:
    // Method for ADD
    public class AddCurrentValues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getIsMethodSelected() == false){
                setIsMethodSelected(true);
                setAcctualSign("+");
            }else{
                try{
                    setScore(getValueA()+ getValueB());
                    setValueA(getScore());
                    setValueAString(getScore().toString());
                    setValueBString("0.0");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    // Method for SUBSTRACT
    public class SubstractCurrentValues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getAcctualSign() == "+" || getIsMethodSelected() == false){
                setIsMethodSelected(true);
                setAcctualSign("-");
                FillLabelWithStringData("-");
            }else if(getAcctualSign() == "-"){
                new EqualsFromCurrentValues().actionPerformed(e);  // Anonymous
                setValueBString("-");
            }
            else {
                try{
                    if(getValueBString().equals("0.0") || getValueB() == 0.0){
                        FillLabelWithStringData("-");
                    }else {
                        setScore(getValueA() - getValueB());
                        setValueA(getScore());
                        setValueBString("0.0");
                    }
                }catch(Exception exep){
                    exep.printStackTrace();
                }
            }
        }
    }

    // Method for adding DOT -> (.)
    public class InsertDotToValue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getIsMethodSelected() == false){
                if(getValueAString().equals("")){
                    setValueAString("0.");
                    myCalculatorScoreLabel.setText(getValueAString());
                }else if(getValueAString() == "0."){
                    setValueAString("0.");
                }else if(getValueAString() == "-"){
                    setValueAString("-0.");
                }
                else{
                    setValueAString(getValueAString()+".");
                    myCalculatorScoreLabel.setText(getValueAString());
                }
            }else{
                if(getValueBString() == "-"){
                    setValueBString("-0.");
                }else if(getValueBString() == "0.0"){
                    setValueBString("0.");
                }
                else{
                    setValueBString(getValueBString()+".");
                }
            }
        }
    }

    // Method for EQALS
    public class EqualsFromCurrentValues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(getAcctualSign() == "+") {
                    setScore(getValueA()+ getValueB());
               }
                if (getAcctualSign() == "-"){
                    setScore(getValueA()+ getValueB());
                }
                setValueA(getScore());
                setValueBString("0.0");
                setValueAString(getScore().toString());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    // Methof for changing SIGN of Value
    public class ChangeSignOfValue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isMethodSelected == false){
                if(ValueAString == ""){
                    ValueAString = "-";
                    myCalculatorScoreLabel.setText(ValueAString);
                }else{
                    ValueA = Double.parseDouble(ValueAString);
                    ValueA *= -1.0;
                    ValueAString = ValueA.toString();
                    myCalculatorScoreLabel.setText(ValueAString);
                }
            }else{
                if(ValueBString == ""){
                    ValueBString = "-";
                    myCalculatorScoreLabel.setText(ValueBString);
                }else{
                    ValueB = Double.parseDouble(ValueBString);
                    ValueB *= -1.0;
                    ValueBString = ValueB.toString();
                    myCalculatorScoreLabel.setText(ValueBString);
                }
            }
        }
    }

    // Methof for filling label with data
    public void FillLabelWithStringData(String param1){
        if(getIsMethodSelected()){
            if(getValueBString().equals("0.0")) {
                setValueBString(param1);
            }else{
                setValueBString(getValueBString()+param1);
            }
        }else{
            if(getValueAString().equals("0.0")){
                setValueAString(param1);
            }else {
                setValueAString(getValueAString()+param1);
            }
        }
    }

    // Resething method
    public class ClearLabelFromData implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setIsMethodSelected(false);
            setScore(0.0);
            setValueA(0.0);
            setValueB(0.0);
            setValueAString("0.0");
            setValueBString("0.0");
            myCalculatorScoreLabel.setText(Score.toString());
            myCalculatorMethodLabel.setText("A = " + getValueAString()+ " B = " + getValueBString());
        }
    }


    public class SetZeroNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("0");
        }
    }
    public class SetOneNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("1");
        }
    }
    public class SetTwoNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("2");
        }
    }
    public class SetThreeNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("3");
        }
    }
    public class SetFourNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("4");
        }
    }
    public class SetFiveNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("5"); }
    }
    public class SetSixNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("6");
        }
    }
    public class SetSevenNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("7");
        }
    }
    public class SetEightNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("8");
        }
    }
    public class SetNineNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FillLabelWithStringData("9"); }
    }
}
