package technica;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Remedy extends JFrame implements ActionListener {
	
	private ArrayList<JButton> symptoms;
	private JPanel promptPanel = new JPanel();
	private JPanel symptomsPanel = new JPanel();
	private JLabel prompt = new JLabel(); 
	
	public Remedy() {
		symptoms = new ArrayList<JButton>();
		symptoms.add(new JButton("runny nose"));
		symptoms.add(new JButton("cough"));
		symptoms.add(new JButton("nausea"));
		symptoms.add(new JButton("sore throat"));
		symptoms.add(new JButton("headache"));
		
		setTitle("Remedies");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		prompt.setHorizontalAlignment(JLabel.CENTER);
		prompt.setVerticalAlignment(JLabel.CENTER);
		prompt.setText("Choose a symptom that you are suffering from: ");
		
		promptPanel.setSize(400, 200);
		promptPanel.setLocation(0, 0);
		promptPanel.add(prompt, BorderLayout.CENTER);
		promptPanel.setOpaque(false);
		
		symptomsPanel.setSize(400, 400);
		symptomsPanel.setLocation(0, 200);
		symptomsPanel.setLayout(new BoxLayout(symptomsPanel, BoxLayout.Y_AXIS));
		symptomsPanel.setBorder(new EmptyBorder(100, 50, 50, 50));
		symptomsPanel.setOpaque(false);
		
		for(int i = 0; i < symptoms.size(); i++)
		{
			symptoms.get(i).addActionListener(this);
			symptoms.get(i).setMaximumSize(new Dimension(400, 200));
			symptoms.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
			symptomsPanel.add(symptoms.get(i));
		} 
		
		add(promptPanel);
		add(symptomsPanel); 
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String text = "Here are some remedies you can use. We hope you feel\nbetter soon!\n\n\n";
		if(e.getSource() instanceof JButton) {
			JButton b = (JButton)e.getSource();
			if(b != null) 
			{	
				if(b.getText().equals(symptoms.get(0).getText())) 
				{
					text += "Medical Remedies:\nNasal congestion spray (ie: sudafed, afrin)\nAverage Price: $14.04\n\nHome Remedies:\nUse humidifier/vaporizer \nBreathe in steam from warm water";
				} else if(b.getText().equals(symptoms.get(1).getText())) {
					text += "Medical Remedies:\nRobitussin, Nyquil, other cough syrups\nAverage Price: $3.90\nCough drops\nPrice Range: $1-4\n\nHome Remedies:\nDrink Honey tea\nDrink Ginger tea\nDrink lots of fluids/water\nBreathe in steam\nGargle with warm salt water\nHave some miso soup";
				} else if(b.getText().equals(symptoms.get(2).getText())) {
					text += "Medical Remedies:\nPepto Bismol, Dramamine, Ibuprofen\nPrice Range: $5 - 10\n\nHome Remedies:\nGinger tea\nPeppermint aromatherapy\nEat crackers, pretzels and/or toast";
				} else if(b.getText().equals(symptoms.get(3).getText())) {
					text += "Medical Remedies:\nCepacol, Robitussin, Chloraseptic, Tylenol\nAverage Price: $10.11\n\nHome Remedies:\nEat honey\nGargle with warm salt water\nDrink chamomile tea\nDrink marshmallow root tea";
				} else if(b.getText().equals(symptoms.get(4).getText())){ //headache
					text += "Medical Remedies:\nAspirin, Advil, Tylenol, Excedrin\nPrice Range: $3-10\n\nHome Remedies:\nDrink lots of water\nSleep\nDrink ginger tea";
				}
				clearFrame();
				display(text);
			}
		}
	} 
	
	private void clearFrame() {
		for(int i = 0; i < symptoms.size(); i++) {
			symptomsPanel.remove(symptoms.get(i));
			symptomsPanel.revalidate();
			symptomsPanel.repaint();
		}
		promptPanel.remove(prompt);
	
		remove(symptomsPanel);
		remove(promptPanel);
	}
	
	private void display(String text) {
		JPanel remedies = new JPanel();
		JTextArea information = new JTextArea(text);
		information.setMaximumSize(new Dimension(400, 400));
		remedies.add(information);
		remedies.setOpaque(false);
		JScrollPane scrollBar = new JScrollPane(remedies, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollBar);
	}
	
	public static void main(String args[]) {
		new Remedy();

	}
}