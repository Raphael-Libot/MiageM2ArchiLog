package plugins;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import application.Vache;
import loader.DescripteurPlugin;
import loader.Loader;

public class DefaultWindows extends JFrame {

	JPanel blockButtonBehavior;
	ButtonGroup toggleBlockButtonBehavior;

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
		JToggleButton button = new JToggleButton(descPlugin.getNomClasse());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					switch(descPlugin.getImplementedInterface()) {
						case "IAfficheur" : 
							Loader.changementAfficheur(descPlugin.getNomClasse());
							break;
						case "IModifierVache" : Loader.modifierVache(descPlugin.getNomClasse(), "Toto");
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
		this.afficheur = new JTextArea("coucou");
		
		this.panelAfficheur.add(afficheur);
		
		this.add(blockButtonBehavior, BorderLayout.NORTH);
		this.add(panelAfficheur, BorderLayout.CENTER);
	}
	
	public void afficherVache(final String vache){
		this.afficheur.setText(vache);
	}
	
	public void modifierVache(Vache vache) {
		this.toto = new JTextField(10);
		this.afficheur.setText("Le nouveau nom de la vache est : " + vache.getNom());
	}
	
}
