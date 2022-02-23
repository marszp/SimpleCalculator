import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class SimpleCalculator implements Runnable{

    //!!!!!!!!!!!!!!! SIMPLE CALCULATOR !!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!! Generally works but still some things needs to be done !!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!! Rest of functionality will be performed someday... !!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!! TO DO:
    //!!!!!!!!!!!!!!! 1. Implement multiplication
    //!!!!!!!!!!!!!!! 2. Implement division
    //!!!!!!!!!!!!!!! 3. Improve +/-/*/"/"= buttons
    //!!!!!!!!!!!!!!! 4. Implement BigDecimal for Walues - better precison
    //!!!!!!!!!!!!!!! REST of COD + COMMENTS BELOW =3

    //!!!!!!!!!!!!!!! INSTANCE VARIABLES called sometimes POLAMI !!!!!!!!!!!!!!!
    private Double WalueA = 0.0;
    private String WalueAString ="0.0";
    private Double WalueB = 0.0;
    private String WalueBString = "0.0";
    private Double Score = 0.0;
    private String SignOfMethod = null;
    private Boolean isMethodSelected = false;
    private String acctualSign = "+";
    JLabel myCalculatorScoreLabel = new JLabel(""+getScore(),SwingConstants.CENTER);
    JLabel myCalculatorMethodLabel = new JLabel(("A= "+getWalueA() +" "+getSignOfMethod() +" B= " +getWalueB()),SwingConstants.CENTER);

    //!!!!!!!!!!!!!!! GETTERS !!!!!!!!!!!!!!!
    public Double getWalueA() {
        return WalueA;
    }
    public Double getWalueB() {
        return WalueB;
    }
    public String getWalueAString() { return WalueAString; }
    public String getWalueBString() { return WalueBString; }
    public String getSignOfMethod() {
        return SignOfMethod;
    }
    public Double getScore() {
        return Score;
    }
    public Boolean getIsMethodSelected() { return isMethodSelected; }
    public String getAcctualSign() { return acctualSign; }

    //!!!!!!!!!!!!!!! SETTERS !!!!!!!!!!!!!!!
    public void setWalueA(Double tempWalueA) { WalueA = tempWalueA; }
    public void setWalueB(Double tempWalueB) { WalueB = tempWalueB; }
    public void setScore(Double tempScore) { Score = tempScore; }
    public void setWalueAString(String tempWalueAString) { WalueAString = tempWalueAString; }
    public void setWalueBString(String tempWalueBString) { WalueBString = tempWalueBString; }
    public void setIsMethodSelected(Boolean tempIsMethodSelected) {isMethodSelected = tempIsMethodSelected;}
    public void setAcctualSign(String tempAcctualSign) { acctualSign = tempAcctualSign; }

    //!!!!!!!!!!!!!!! SECOND THREAD RUN METOD - FOR GUI UPDATE !!!!!!!!!!!!!!!
    @Override
    public void run() {
        while(true){
            try {
                if (getWalueAString() != "0.0") {
                    setWalueA(Double.parseDouble(getWalueAString()));
                }
                if (getWalueBString() != "0.0") {
                    if (getWalueBString() != "-") {
                        setWalueB(Double.parseDouble(getWalueBString()));
                    }
                }
                if (true) {
                    // ADD HER DEPENCENCY FOR "+" & "-"
                    myCalculatorScoreLabel.setText(Score.toString());
                    myCalculatorMethodLabel.setText("A = " + WalueAString + " B = " + WalueBString);
                }
            }catch (Exception exp){
                exp.printStackTrace();
            }
        }
    }

    //!!!!!!!!!!!!!!! MAIN MENU - CREATE INSTANCE OF CALCULATOR + CREATE GUI + SECOND THREAD !!!!!!!!!!!!!!!
    public static void main(String[] args) {
        SimpleCalculator myFirstCalculator = new SimpleCalculator();
        Thread firstThread = new Thread(myFirstCalculator);
        firstThread.start();
        myFirstCalculator.createGuiMethod();
    }
    //!!!!!!!!!!!!!!! METHOD FOR GUI !!!!!!!!!!!!!!!
    public void createGuiMethod(){
        //-----------BUTTONS-----------
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

        //-----------FRAME-----------
        JFrame myCalculatorFrame = new JFrame("My First Calculator");
        myCalculatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myCalculatorFrame.setSize(300,318);
        myCalculatorFrame.setVisible(true);

        //-----------LABELS-----------
        myCalculatorScoreLabel.setPreferredSize(new Dimension(200,60));
        Border borderForLabel = BorderFactory.createLineBorder(Color.BLACK,5);
        myCalculatorScoreLabel.setBorder(borderForLabel);
        myCalculatorScoreLabel.setFont(new Font("Serif",Font.PLAIN,20));

        //-----------PANELS-----------
        JPanel panelForCalcButtons = new JPanel();
        JPanel panelForCentralButtons = new JPanel();
        JPanel panelForEastButtons = new JPanel();
        JPanel panelForWeastButtons = new JPanel();
        JPanel panelForMethodButtons = new JPanel();
        JPanel panelForMethodLabel = new JPanel();
        JPanel panelForScore = new JPanel();

        //-----------SETTING FRAME COLORS AND ORIENTATION-----------
        myCalculatorFrame.getContentPane().add(panelForScore,BorderLayout.NORTH);
        panelForScore.setBackground(Color.GREEN);
        myCalculatorFrame.getContentPane().add(panelForCalcButtons,BorderLayout.CENTER);
        panelForCalcButtons.setBackground(Color.YELLOW);
        myCalculatorFrame.getContentPane().add(panelForMethodLabel,BorderLayout.SOUTH);
        panelForMethodLabel.setBackground(Color.BLUE);

        //-----------UPPER PANEL FOR SCORE LABEL-----------
        panelForScore.add(myCalculatorScoreLabel,BorderLayout.CENTER);

        //-----------CENTRAL PANEL FOR BUTTONS-EAST SIDE-----------
        panelForCalcButtons.add(panelForEastButtons,BorderLayout.EAST);
        panelForEastButtons.setBackground(Color.BLACK);
        panelForEastButtons.setPreferredSize(new Dimension(50,130));
        panelForEastButtons.add(myCalculatorSevenButton,BorderLayout.NORTH);
        panelForEastButtons.add(myCalculatorFourButton,BorderLayout.CENTER);
        panelForEastButtons.add(myCalculatorOneButton,BorderLayout.SOUTH);
        panelForEastButtons.add(myCalculatorSignButton,BorderLayout.SOUTH);

        //-----------CENTRAL PANEL FOR BUTTONS-CENTRAL SIDE-----------
        panelForCalcButtons.add(panelForCentralButtons,BorderLayout.CENTER);
        panelForCentralButtons.setBackground(Color.BLUE);
        panelForCentralButtons.setPreferredSize(new Dimension(50,130));
        panelForCentralButtons.add(myCalculatorEightButton,BorderLayout.NORTH);
        panelForCentralButtons.add(myCalculatorFiveButton,BorderLayout.CENTER);
        panelForCentralButtons.add(myCalculatorTwoButton,BorderLayout.SOUTH);
        panelForCentralButtons.add(myCalculatorZeroButton,BorderLayout.SOUTH);

        //-----------CENTRAL PANEL FOR BUTTONS-WEST SIDE-----------
        panelForCalcButtons.add(panelForWeastButtons,BorderLayout.WEST);
        panelForWeastButtons.setBackground(Color.RED);
        panelForWeastButtons.setPreferredSize(new Dimension(50,130));
        panelForWeastButtons.add(myCalculatorNineButton,BorderLayout.NORTH);
        panelForWeastButtons.add(myCalculatorSixButton,BorderLayout.CENTER);
        panelForWeastButtons.add(myCalculatorThreeButton,BorderLayout.SOUTH);
        panelForWeastButtons.add(myCalculatorDotButotn,BorderLayout.SOUTH);

        //-----------CENTRAL PANEL FOR BUTTONS-ADDITIONAL PANEL FOR METHOD BUTTONS-----------
        panelForCalcButtons.add(panelForMethodButtons,BorderLayout.WEST);
        panelForMethodButtons.setBackground(Color.PINK);
        panelForMethodButtons.setPreferredSize(new Dimension(50,130));
        panelForMethodButtons.add(myCalculatorClearButton,BorderLayout.NORTH);
        panelForMethodButtons.add(myCalculatorAddButton,BorderLayout.CENTER);
        panelForMethodButtons.add(myCalculatorSubstractButton,BorderLayout.SOUTH);
        panelForMethodButtons.add(myCalculatorEqualButton,BorderLayout.SOUTH);

        //-----------SOUTH PANEL FOR METHOD LABEL-----------
        panelForMethodLabel.add(myCalculatorMethodLabel,BorderLayout.CENTER);
        myCalculatorMethodLabel.setPreferredSize(new Dimension(200,60));
        myCalculatorMethodLabel.setBorder(borderForLabel);
        myCalculatorMethodLabel.setFont(new Font("Serif",Font.PLAIN,20));

        //-----------ACTION LISTENERS FOR BUTTONS-----------
        myCalculatorAddButton.addActionListener(new addCurrentWalues());
        myCalculatorSubstractButton.addActionListener(new substractCurrentWalues());
        myCalculatorEqualButton.addActionListener(new equalsFromCurrentWalues());
        myCalculatorOneButton.addActionListener(new setOneNumber());
        myCalculatorTwoButton.addActionListener(new setTwoNumber());
        myCalculatorThreeButton.addActionListener(new setThreeNumber());
        myCalculatorFourButton.addActionListener(new setFourNumber());
        myCalculatorFiveButton.addActionListener(new setFiveNumber());
        myCalculatorSixButton.addActionListener(new setSixNumber());
        myCalculatorSevenButton.addActionListener(new setSevenNumber());
        myCalculatorEightButton.addActionListener(new setEightNumber());
        myCalculatorNineButton.addActionListener(new setNineNumber());
        myCalculatorDotButotn.addActionListener(new insertDotToWalue());
        myCalculatorZeroButton.addActionListener(new setZeroNumber());
        myCalculatorSignButton.addActionListener(new changeSignOfWalue());
        myCalculatorClearButton.addActionListener(new clearLabelFromData());
    }

    //!!!!!!!!!!!!!!! METHOD FOR ADD !!!!!!!!!!!!!!
    public class addCurrentWalues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getIsMethodSelected()== false){
                setIsMethodSelected(true);
                setAcctualSign("+");
            }else{
                try{
                    setScore(getWalueA()+getWalueB());
                    setWalueA(getScore());
                    setWalueAString(getScore().toString());
                    setWalueBString("0.0");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    //!!!!!!!!!!!!!!! METHOD FOR SUBSTRACT !!!!!!!!!!!!!!
    public class substractCurrentWalues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getAcctualSign() =="+" || getIsMethodSelected() == false){
                setIsMethodSelected(true);
                setAcctualSign("-");
                fillLabelWithStringData("-");
            }else if(getAcctualSign() =="-" ){
                new equalsFromCurrentWalues().actionPerformed(e);  // Anonymous
                setWalueBString("-");
            }
            else {
                try{
                    if(getWalueBString().equals("0.0") || getWalueB() == 0.0){
                        fillLabelWithStringData("-");
                    }else {
                        setScore(getWalueA() - getWalueB());
                        setWalueA(getScore());
                        setWalueBString("0.0");
                    }
                }catch(Exception exep){
                    exep.printStackTrace();
                }
            }
        }
    }

    //!!!!!!!!!!!!!!! METHOD FOR ADDING DOT => (.) !!!!!!!!!!!!!!
    public class insertDotToWalue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(getIsMethodSelected() == false){
                if(getWalueAString().equals("")){
                    setWalueAString("0.");
                    myCalculatorScoreLabel.setText(getWalueAString());
                }else if(getWalueAString() == "0."){
                    setWalueAString("0.");
                }else if(getWalueAString() == "-"){
                    setWalueAString("-0.");
                }
                else{
                    setWalueAString(getWalueAString()+".");
                    myCalculatorScoreLabel.setText(getWalueAString());
                }
            }else{
                if(getWalueBString()=="-"){
                    setWalueBString("-0.");
                }else if(getWalueBString()=="0.0"){
                    setWalueBString("0.");
                }
                else{
                    setWalueBString(getWalueBString()+".");
                }
            }
        }
    }

    //!!!!!!!!!!!!!!! METHOD FOR EQUALS !!!!!!!!!!!!!!
    public class equalsFromCurrentWalues implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(getAcctualSign() == "+") {
                    setScore(getWalueA()+getWalueB());
               }
                if (getAcctualSign() == "-"){
                    setScore(getWalueA()+getWalueB());
                }
                setWalueA(getScore());
                setWalueBString("0.0");
                setWalueAString(getScore().toString());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    //!!!!!!!!!!!!!!! METHOD FOR CHANGING SIGN OF WALUE !!!!!!!!!!!!!!
    public class  changeSignOfWalue implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isMethodSelected == false){
                if(WalueAString == ""){
                    WalueAString = "-";
                    myCalculatorScoreLabel.setText(WalueAString);
                }else{
                    WalueA = Double.parseDouble(WalueAString);
                    WalueA *= -1.0;
                    WalueAString = WalueA.toString();
                    myCalculatorScoreLabel.setText(WalueAString);
                }
            }else{
                //WalueB = Double.parseDouble(WalueBString);
                //WalueB *= -1.0;
                if(WalueBString == ""){
                    WalueBString = "-";
                    myCalculatorScoreLabel.setText(WalueBString);
                }else{
                    WalueB = Double.parseDouble(WalueBString);
                    WalueB *= -1.0;
                    WalueBString = WalueB.toString();
                    myCalculatorScoreLabel.setText(WalueBString);
                }
            }
        }
    }

    //!!!!!!!!!!!!!!! METHOD FOR filling label with DATA !!!!!!!!!!!!!!
    public void fillLabelWithStringData(String param1){
        if(getIsMethodSelected()){
            if(getWalueBString().equals("0.0")) {
                setWalueBString(param1);
            }else{
                setWalueBString(getWalueBString()+param1);
            }
        }else{
            if(getWalueAString().equals("0.0")){
                setWalueAString(param1);
            }else {
                setWalueAString(getWalueAString()+param1);
            }
        }
    }

    ////!!!!!!!!!!!!!!! RESETING METHOD !!!!!!!!!!!!!!
    public class clearLabelFromData implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setIsMethodSelected(false);
            setScore(0.0);
            setWalueA(0.0);
            setWalueB(0.0);
            setWalueAString("0.0");
            setWalueBString("0.0");
            myCalculatorScoreLabel.setText(Score.toString());
            myCalculatorMethodLabel.setText("A = " + getWalueAString()+ " B = " + getWalueBString());
        }
    }

    //!!!!!!!!!!!!!!! INNER CLASSES for perform ActionListener  !!!!!!!!!!!!!!!
    public class setZeroNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("0");
        }
    }
    public class setOneNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("1");
        }
    }
    public class setTwoNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("2");
        }
    }
    public class setThreeNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("3");
        }
    }
    public class setFourNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("4");
        }
    }
    public class setFiveNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {fillLabelWithStringData("5"); }
    }
    public class setSixNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("6");
        }
    }
    public class setSevenNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("7");
        }
    }
    public class setEightNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fillLabelWithStringData("8");
        }
    }
    public class setNineNumber implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {fillLabelWithStringData("9"); }
    }
}
