package loader;

import java.awt.BorderLayout;
import java.awt.Font;
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

	JLabel Titre;
	JLabel Titrecomportement;
	JScrollPane Scrolafficheur;
	JPanel blockButtonBehavior;
	JPanel blockButtonDisplay;
	JPanel blockButtonLaoder;
	JScrollPane jScrollPane1;
	JTextArea afficheur;
	JPanel panelGloblae;
	JLabel titreAfficheur;
	JLabel titreChargement;
	JPanel zoneAffichage;
	JPanel zoneBehaviour;
	JPanel zoneDisplay;
	JPanel zoneLoader;
	JPanel zoneTitre;

	ButtonGroup toggleBlockButtonDisplay;
	ButtonGroup toggleBlockButtonBehavior;
	ButtonGroup toggleBlockButtonLoader;

	public DefaultWindows() {


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
					switch (descPlugin.getImplementedInterface()) {
					case "IAfficheur":
						Loader.changementAfficheur(descPlugin.getNomClasse());
						break;
					case "IModifierVache":
						Loader.modifierVache(descPlugin.getNomClasse(),
								((DescripteurPluginModifier) descPlugin).getAttAModifier(),
								((String) JOptionPane.showInputDialog(
										"Changement de : " + ((DescripteurPluginModifier) descPlugin).getAttAModifier(),
										null)));
						break;
					case "IChargeurVache":
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

		switch (descPlugin.getImplementedInterface()) {
		case "IAfficheur":
			this.blockButtonDisplay.add(button);
			this.toggleBlockButtonDisplay.add(button);
			break;
		case "IModifierVache":
			this.blockButtonLaoder.add(button);
			this.toggleBlockButtonLoader.add(button);
			break;
		case "IChargeurVache":
			this.blockButtonLaoder.add(button);
			this.toggleBlockButtonLoader.add(button);
			break;
		default:
			break;
		}
	}

	public void afficherVache(final String vache) {
		this.afficheur.setText(vache);
	}

	public void modifierVache(Vache vache, String attribut) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		this.afficheur.setText(attribut + " de la vache devient : " + vache.getClass()
				.getMethod("get" + attribut.substring(0, 1).toUpperCase() + attribut.substring(1)).invoke(vache));
	}

	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		panelGloblae = new javax.swing.JPanel();
		zoneTitre = new javax.swing.JPanel();
		Titre = new javax.swing.JLabel();
		zoneLoader = new javax.swing.JPanel();
		blockButtonLaoder = new javax.swing.JPanel();
		titreChargement = new javax.swing.JLabel();
		zoneAffichage = new javax.swing.JPanel();
		Scrolafficheur = new javax.swing.JScrollPane();
		afficheur = new javax.swing.JTextArea();
		zoneDisplay = new javax.swing.JPanel();
		titreAfficheur = new javax.swing.JLabel();
		blockButtonDisplay = new javax.swing.JPanel();
		zoneBehaviour = new javax.swing.JPanel();
		Titrecomportement = new javax.swing.JLabel();
		blockButtonBehavior = new javax.swing.JPanel();

		this.toggleBlockButtonLoader = new ButtonGroup();
		this.toggleBlockButtonBehavior = new ButtonGroup();
		this.toggleBlockButtonDisplay = new ButtonGroup();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		zoneTitre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		Titre.setBackground(new java.awt.Color(255, 255, 255));
		Titre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		Titre.setText("Tamagovache");

		javax.swing.GroupLayout zoneTitreLayout = new javax.swing.GroupLayout(zoneTitre);
		zoneTitre.setLayout(zoneTitreLayout);
		zoneTitreLayout
				.setHorizontalGroup(zoneTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(zoneTitreLayout.createSequentialGroup().addGap(396, 396, 396)
								.addComponent(Titre, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addGap(458, 458, 458)));
		zoneTitreLayout.setVerticalGroup(zoneTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(Titre, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE));

		zoneLoader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		titreChargement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		titreChargement.setText("Plugins de chargements :");

		javax.swing.GroupLayout zoneLoaderLayout = new javax.swing.GroupLayout(zoneLoader);
		zoneLoader.setLayout(zoneLoaderLayout);
		zoneLoaderLayout.setHorizontalGroup(zoneLoaderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneLoaderLayout.createSequentialGroup().addContainerGap()
						.addGroup(zoneLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(zoneLoaderLayout.createSequentialGroup().addComponent(titreChargement)
										.addContainerGap(866, Short.MAX_VALUE))
								.addComponent(blockButtonLaoder, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))));
		zoneLoaderLayout
				.setVerticalGroup(zoneLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zoneLoaderLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(titreChargement).addGap(7, 7, 7)
								.addComponent(blockButtonLaoder, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(51, 51, 51)));

		zoneAffichage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		afficheur.setColumns(20);
		afficheur.setRows(5);
		afficheur.setFont(new Font("monospaced", Font.PLAIN, 12));
		Scrolafficheur.setViewportView(afficheur);

		javax.swing.GroupLayout zoneAffichageLayout = new javax.swing.GroupLayout(zoneAffichage);
		zoneAffichage.setLayout(zoneAffichageLayout);
		zoneAffichageLayout.setHorizontalGroup(zoneAffichageLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneAffichageLayout.createSequentialGroup().addContainerGap()
						.addComponent(Scrolafficheur, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
						.addContainerGap()));
		zoneAffichageLayout.setVerticalGroup(zoneAffichageLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneAffichageLayout.createSequentialGroup().addContainerGap()
						.addComponent(Scrolafficheur, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addContainerGap()));

		zoneDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		titreAfficheur.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		titreAfficheur.setText("Plugins de afficheurs :");


		javax.swing.GroupLayout zoneDisplayLayout = new javax.swing.GroupLayout(zoneDisplay);
		zoneDisplay.setLayout(zoneDisplayLayout);
		zoneDisplayLayout.setHorizontalGroup(zoneDisplayLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneDisplayLayout.createSequentialGroup().addContainerGap()
						.addGroup(zoneDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(zoneDisplayLayout.createSequentialGroup().addComponent(titreAfficheur)
										.addGap(0, 0, Short.MAX_VALUE))
								.addComponent(blockButtonDisplay, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		zoneDisplayLayout
				.setVerticalGroup(
						zoneDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(zoneDisplayLayout.createSequentialGroup().addContainerGap()
										.addComponent(titreAfficheur)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(blockButtonDisplay, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));

		zoneBehaviour.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		Titrecomportement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		Titrecomportement.setText("Plugins comportements :");

		javax.swing.GroupLayout blockButtonBehaviorLayout = new javax.swing.GroupLayout(blockButtonBehavior);
		blockButtonBehavior.setLayout(blockButtonBehaviorLayout);
		blockButtonBehaviorLayout.setHorizontalGroup(blockButtonBehaviorLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		blockButtonBehaviorLayout.setVerticalGroup(blockButtonBehaviorLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 47, Short.MAX_VALUE));

		javax.swing.GroupLayout zoneBehaviourLayout = new javax.swing.GroupLayout(zoneBehaviour);
		zoneBehaviour.setLayout(zoneBehaviourLayout);
		zoneBehaviourLayout.setHorizontalGroup(zoneBehaviourLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneBehaviourLayout.createSequentialGroup().addContainerGap()
						.addGroup(zoneBehaviourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(zoneBehaviourLayout.createSequentialGroup().addComponent(Titrecomportement)
										.addGap(0, 859, Short.MAX_VALUE))
								.addComponent(blockButtonBehavior, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		zoneBehaviourLayout.setVerticalGroup(zoneBehaviourLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneBehaviourLayout.createSequentialGroup().addContainerGap().addComponent(Titrecomportement)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(blockButtonBehavior, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelGloblaeLayout = new javax.swing.GroupLayout(panelGloblae);
		panelGloblae.setLayout(panelGloblaeLayout);
		panelGloblaeLayout.setHorizontalGroup(panelGloblaeLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelGloblaeLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelGloblaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(zoneTitre, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(zoneLoader, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(zoneDisplay, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(zoneBehaviour, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(
						panelGloblaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelGloblaeLayout.createSequentialGroup().addContainerGap()
										.addComponent(zoneAffichage, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(14, 14, 14))));
		panelGloblaeLayout.setVerticalGroup(panelGloblaeLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelGloblaeLayout.createSequentialGroup().addContainerGap()
						.addComponent(zoneTitre, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(zoneLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
						.addComponent(zoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(zoneBehaviour, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(74, 74, 74))
				.addGroup(panelGloblaeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelGloblaeLayout.createSequentialGroup().addGap(137, 137, 137)
								.addComponent(zoneAffichage, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(281, Short.MAX_VALUE))));

		jScrollPane1.setViewportView(panelGloblae);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1075, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 629, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>

	// Variables declaration - do not modify

}
