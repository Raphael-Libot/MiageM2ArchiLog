package plugins;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefaultWindows extends JFrame {
	

	public void display() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		JButton button = new JButton("coucou");
		JPanel linesPanel = new JPanel();
		
		linesPanel.setLayout(new BoxLayout(linesPanel, BoxLayout.PAGE_AXIS));
		
		linesPanel.add(button);
		
		this.getContentPane().add(linesPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
}
