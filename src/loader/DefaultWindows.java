package loader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import application.Vache;

public class DefaultWindows extends JFrame {

	JPanel blockButtonBehavior;
	ButtonGroup toggleBlockButtonBehavior;
	
	JScrollPane scrollPanel;

	JPanel panelAfficheur;
	JTextArea afficheur;
	JTextField toto;
	
	public DefaultWindows(){
		
		initComponents();

	}

	public void display() {
		this.setVisible(true);
	}

	public void ajoutBoutonAfficheur(DescripteurPlugin descPlugin) {
		JToggleButton button = new JToggleButton(descPlugin.getNom());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					switch(descPlugin.getImplementedInterface()) {
						case "IAfficheur" : 
							Loader.changementAfficheur(descPlugin.getNomClasse());
							break;
						case "IModifierVache" : Loader.modifierVache(descPlugin.getNomClasse(), ((DescripteurPluginModifier) descPlugin).getAttAModifier() , ((String)JOptionPane.showInputDialog(
			                    "Changement de : " + ((DescripteurPluginModifier) descPlugin).getAttAModifier() ,
			                    null)));
							break;
						case "IChargeurVache" :
							Loader.charger(descPlugin.getNomClasse());
							break;
						default:
							break;
					}
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.blockButtonBehavior.add(button);
		this.toggleBlockButtonBehavior.add(button);

	}
	
	private void initComponents(){
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		this.blockButtonBehavior = new JPanel();
		this.blockButtonBehavior.setLayout(new BoxLayout(this.blockButtonBehavior, BoxLayout.LINE_AXIS));
		this.toggleBlockButtonBehavior = new ButtonGroup();

		this.blockButtonBehavior.add(new JLabel("Afficheur : "));
		
		this.panelAfficheur = new JPanel();
		this.afficheur = new JTextArea("");
		
		this.panelAfficheur.add(afficheur);
		scrollPanel = new JScrollPane(blockButtonBehavior);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setPreferredSize(new Dimension(50, 50));
        scrollPanel.setBounds(50, 50, 350, 50);
		
		
		this.add(scrollPanel, BorderLayout.NORTH);
		this.add(panelAfficheur, BorderLayout.CENTER);
	}
	
	public void afficherVache(final String vache){
		this.afficheur.setText(vache);
	}
	
	public void modifierVache(Vache vache, String attribut) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.afficheur.setText( attribut+" de la vache devient : " + vache.getClass().getMethod("get"+attribut.substring(0, 1).toUpperCase() + attribut.substring(1)).invoke(vache));
	}
	
}
