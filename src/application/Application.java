package application;

/**
 * écran principal de l'application
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import loader.DescripteurPlugin;
import loader.Loader;

public class Application extends JFrame {

	JPanel blockButtonBehavior;
	JPanel blockButtonDisplay;
	JPanel blockButtonLaoder;
	JPanel blockButtonModifier;
	
	JTextArea afficheur;

	ButtonGroup toggleBlockButtonDisplay;
	ButtonGroup toggleBlockButtonBehavior;
	ButtonGroup toggleBlockButtonLoader;
	ButtonGroup toggleBlockButtonModifier;
	
	private static Vache maVache;
	
	/**
	  * Constructeur  
	  * */

	public Application() {

		initComponents();
		try {
			List<DescripteurPlugin> descPlugin = Loader.chargementPlugins();
			for(DescripteurPlugin desc : descPlugin) {
				this.ajoutBoutonAfficheur(desc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	  * Fonction qui permet d'afficher l'écran de l'application
	  * */
	
	public void display() {
		this.setVisible(true);
	}

	/**
	  * Ajout d'un bouton dans l'application  
	  * @param  descPlugin descripteur du plugin qui sera lancé par le bouton
	  * */
	public void ajoutBoutonAfficheur(final DescripteurPlugin descPlugin) {
		JToggleButton button = new JToggleButton(descPlugin.getNom());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (descPlugin.getImplementedInterface()) {
				case "IAfficheur":
					changementAfficheur(descPlugin);
					break;
				case "IModifierVache":
					modifierMaVache(descPlugin,
							((String) JOptionPane.showInputDialog(
									"Changement de : " + ((DescripteurPlugin) descPlugin).getAttrEnPlus(),
									null)));
					break;
				case "IChargeurVache":
					chargementVache(descPlugin);
					break;
				case "IComportement":
					comportementVache(descPlugin);
				default:
					break;
				}
			}
		});

		switch (descPlugin.getImplementedInterface()) {
		case "IAfficheur":
			this.blockButtonDisplay.add(button);
			this.toggleBlockButtonDisplay.add(button);
			break;
		case "IModifierVache":
			this.blockButtonModifier.add(button);
			this.toggleBlockButtonModifier.add(button);
			break;
		case "IChargeurVache":
			this.blockButtonLaoder.add(button);
			this.toggleBlockButtonLoader.add(button);
			break;
		case "IComportement":
			this.blockButtonBehavior.add(button);
			this.toggleBlockButtonBehavior.add(button);
			break;
		default:
			break;
		}
	}
	
	/**
	  * Modification d'une caractéristique de la vache
	  * @param  descPlugin descripteur du plugin
	  * @param  nomVache : nom de la vache
	  * */
	
	public void modifierMaVache(DescripteurPlugin desc, String nomVache) {
		try {
			IModifierVache modifier = (IModifierVache) Loader.donnePlugin(desc);
			modifier.modifier(maVache, desc.getAttrEnPlus(), nomVache);
			this.modifierVache(maVache, desc.getAttrEnPlus());
		} catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * Affichage de la vache à l'écran  
	  * @param  descPlugin descripteur du plugin
	  * */
	
	public void changementAfficheur(DescripteurPlugin desc) {
		IAfficheur afficheur = (IAfficheur) Loader.donnePlugin(desc);
		afficheur.afficher(maVache, this);
	}
	
	/**
	  * Chargement d'une vache à afficher à l'écran
	  * @param  descPlugin descripteur du plugin
	  * */
	public void chargementVache(DescripteurPlugin desc) {
		IChargeurVache chargeur = (IChargeurVache) Loader.donnePlugin(desc);
		maVache = (Vache) chargeur.chargementVache();
		this.afficherVache(maVache.toString());
	}
	
	/**
	  * Chargement d'un comportement de la vache
	  * @param  descPlugin descripteur du plugin
	  * */
	
	public void comportementVache(DescripteurPlugin desc) {
		try {
			IComportement comportement = (IComportement) Loader.donnePlugin(desc);
			comportement.agir(maVache, this);
		} catch ( SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * Affichage de texte
	  * @param  texte : texte à afficher
	  * */

	public void afficherText(final String texte) {
		this.afficheur.setText(texte);
	}
	
	/**
	  * Affichage de texte
	  * @param  vache : texte à afficher
	  * */
	
	public void afficherVache(final String vache) {
		this.afficheur.setText(vache);
	}
	
	/**
	  * Modification d'une caractéristique de la vache
	  * @param  vache : la vache à modifier
	  * @param  attribut : attribut à modifier
	  * */
	public void modifierVache(Vache vache, String attribut) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		this.afficheur.setText(attribut + " de la vache devient : " + vache.getClass()
				.getMethod("get" + attribut.substring(0, 1).toUpperCase() + attribut.substring(1)).invoke(vache));
	}
	
	/**
	  * Initialisation de l'écran
	  * */

	private void initComponents() {
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		JPanel panelGloblae = new javax.swing.JPanel();
		JPanel zoneTitre = new javax.swing.JPanel();
		JLabel Titre = new javax.swing.JLabel();
		JPanel zoneLoader = new javax.swing.JPanel();
		blockButtonLaoder = new javax.swing.JPanel();
		JLabel titreChargement = new javax.swing.JLabel();
		JPanel zoneAffichage = new javax.swing.JPanel();
		JScrollPane Scrolafficheur = new javax.swing.JScrollPane();
		afficheur = new javax.swing.JTextArea();
		JPanel zoneDisplay = new javax.swing.JPanel();
		JLabel titreAfficheur = new javax.swing.JLabel();
		blockButtonDisplay = new javax.swing.JPanel();
		JPanel zoneBehaviour = new javax.swing.JPanel();
		JLabel Titrecomportement = new javax.swing.JLabel();
		blockButtonBehavior = new javax.swing.JPanel();
		
		JPanel zoneModifier = new JPanel();
		JLabel titreModifier = new javax.swing.JLabel();
		blockButtonModifier = new javax.swing.JPanel();

		this.toggleBlockButtonLoader = new ButtonGroup();
		this.toggleBlockButtonBehavior = new ButtonGroup();
		this.toggleBlockButtonDisplay = new ButtonGroup();
		this.toggleBlockButtonModifier = new ButtonGroup();

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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		titreModifier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		titreModifier.setText("Plugins de modification :");
		
		
		zoneModifier.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		javax.swing.GroupLayout zoneModifierLayout = new javax.swing.GroupLayout(zoneModifier);
		zoneModifier.setLayout(zoneModifierLayout);
		zoneModifierLayout.setHorizontalGroup(zoneModifierLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(zoneModifierLayout.createSequentialGroup().addContainerGap()
						.addGroup(zoneModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(zoneModifierLayout.createSequentialGroup().addComponent(titreModifier)
										.addContainerGap(866, Short.MAX_VALUE))
								.addComponent(blockButtonModifier, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))));
		zoneModifierLayout
				.setVerticalGroup(zoneModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zoneModifierLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(titreModifier).addGap(7, 7, 7)
								.addComponent(blockButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(51, 51, 51)));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
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
						.addComponent(Scrolafficheur, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
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
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(zoneModifier, javax.swing.GroupLayout.DEFAULT_SIZE,
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
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(zoneModifier, javax.swing.GroupLayout.PREFERRED_SIZE,
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
				.addGap(0, 700, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>

	// Variables declaration - do not modify

}
