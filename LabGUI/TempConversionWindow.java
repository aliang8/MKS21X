import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConversionWindow() {
	this.setTitle("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	JButton b = new JButton("Convert to Celcius");
	b.addActionListener(this);
	b.setActionCommand("ConverttoC");
	JButton b2 = new JButton("Convert to Farenheit");
	b2.addActionListener(this);
	b2.setActionCommand("ConverttoF");

	t = new JTextField(8);
	j = new JLabel("Temperature");
	
	pane.add(j);
	pane.add(t);
	pane.add(b);
	pane.add(b2);
    }

    public static double CtoF(double t) {
	return t * (9.0/5.0) + 32;
    }

    public static double FtoC(double t) {
	return (t - 32) * (5.0/9.0);
    }


    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	String s = t.getText();
	double temp; 
	if(event.equals("ConverttoC")){
	    try {
		temp = Double.parseDouble(s);
		j.setText(Double.toString(CtoF(temp)));
	    } catch(NumberFormatException n) {
		j.setText("Not a number!");
	    }
	}

	if(event.equals("ConverttoF")){
	    try {
		temp = Double.parseDouble(s);
		j.setText(Double.toString(FtoC(temp)));
	    } catch(NumberFormatException d) {
		j.setText("Not a number!");
	    }
	} 
    }

}
