package projet_2_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private static final Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, 25);
	private static final Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final Font TEXT_FIELD_FONT = new Font(Font.MONOSPACED, Font.BOLD, 15);
	private static final Font GOLD_FONT = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final Color GOLD_LABEL_COLOR = new Color(255, 171, 36);
	private static final Color MESSAGE_COLOR = Color.WHITE;
	private static final Color MESSAGE_ERROR_COLOR = Color.RED;
	private static final Color BUTTON_COLOR = new Color(107, 94, 85);

	protected JButton fileButton = new JButton("Choisir un fichier");
	protected JButton dirButton = new JButton("Choisir un dossier");
	protected JButton statButton = new JButton("Afficher les statistiques du fichier");
	protected JButton dateButton = new JButton("Afficher la date de création");
	protected JButton SizeButton = new JButton("Afficher le poids du fichier");
	protected JButton linkButton = new JButton("Afficher les hyperliens");
	protected JButton startButton = new JButton("Démarrer");
	protected JButton subjectButton = new JButton("Afficher le sujet");
	
	private String equipment[] = {"Talkies-Walkies", "Pelle", "Epée", "Bouclier", "Lampe Torche", "Sac"};
	protected JComboBox equipmentBox = new JComboBox(equipment);
	
	private SpinnerModel Model = new SpinnerNumberModel(2, 2, 5, 1);
	protected JSpinner nbExpl = new JSpinner(Model);
	
	private ImageIcon ico = new ImageIcon("src/images/letter-e.png");
	private ImageIcon entrance = new ImageIcon("src/images/entrance.png");
	
	private JLabel entranceImg = new JLabel(entrance);
	
	protected JLabel messageLabel = new JLabel("Explorateurs Intelligents", SwingConstants.CENTER);
	protected JLabel goldLabel = new JLabel("1000G",SwingConstants.CENTER);

	protected JTextArea zoneTexte = new JTextArea(10, 1);
	protected JScrollPane scrollPane = new JScrollPane(zoneTexte);

	public Menu(String title) {
		super(title);

		initStyle();

		initLayout();

		//initActions();
	}

	protected void initStyle() {
		fileButton.setFont(BUTTON_FONT);
		dirButton.setFont(BUTTON_FONT);
		statButton.setFont(BUTTON_FONT);
		linkButton.setFont(BUTTON_FONT);
		SizeButton.setFont(BUTTON_FONT);
		startButton.setFont(BUTTON_FONT);
		startButton.setBackground(BUTTON_COLOR);
		subjectButton.setFont(BUTTON_FONT);
		dateButton.setFont(BUTTON_FONT);

		zoneTexte.setFont(TEXT_FIELD_FONT);
		
		super.setIconImage(ico.getImage());
		super.getContentPane().setBackground(new Color(51, 46, 41));
		
		goldLabel.setForeground(GOLD_LABEL_COLOR);
		goldLabel.setFont(GOLD_FONT);
		messageLabel.setFont(TITLE_FONT);
		messageLabel.setForeground(MESSAGE_COLOR);
		nbExpl.setEditor(new JSpinner.DefaultEditor(nbExpl));
	}

	protected void initLayout() {
		
		//Layout
		GroupLayout groupLayout = new GroupLayout(super.getContentPane());
		super.setLayout(groupLayout);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
				.addComponent(goldLabel)
				.addGroup(groupLayout.createSequentialGroup())
				.addComponent(nbExpl))
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
					.addComponent(messageLabel)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(entranceImg)))
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(startButton)
				.addGroup(groupLayout.createSequentialGroup())
				.addComponent(equipmentBox)));
		
		
		groupLayout.linkSize(SwingConstants.HORIZONTAL, goldLabel, nbExpl, startButton, equipmentBox);
		groupLayout.linkSize(SwingConstants.VERTICAL, goldLabel, nbExpl, equipmentBox);
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
				.addComponent(goldLabel)
				
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER))
				.addComponent(messageLabel)
				
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER))
				.addComponent(startButton))
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER))
				.addComponent(entranceImg)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(nbExpl)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(nbExpl)
				.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
						.addComponent(equipmentBox)))));

		// First line
		/*JPanel linePanelChoice = new JPanel();
		linePanelChoice.add(dirButton);
		linePanelChoice.add(fileButton);
		linePanelChoice.setSize(600, 100);
		//linePanelChoice.setLayout(new FlowLayout(FlowLayout.LEFT));
		linePanelChoice.setBackground(new Color(79, 59, 37));
		super.add(linePanelChoice);
		
		// Second Line
		JPanel ImagePanel = new JPanel();
		//ImagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ImagePanel.add(new JLabel(entrance));
		ImagePanel.setSize(600, 300);
		super.add(ImagePanel);

		// Third line
		JPanel linePanelDisplay = new JPanel();
		linePanelDisplay.setSize(500, 100);
		//linePanelDisplay.setLayout(new FlowLayout(FlowLayout.LEFT));;
		linePanelDisplay.add(statButton);
		linePanelDisplay.add(SizeButton);
		super.add(linePanelDisplay);
		
		// Fourth line
		JPanel linePanelDisplay2 = new JPanel();
		linePanelDisplay2.setSize(500, 100);
		//linePanelDisplay2.setLayout(new FlowLayout(FlowLayout.LEFT));
		linePanelDisplay2.add(titleButton);
		linePanelDisplay2.add(subjectButton);
		linePanelDisplay2.add(dateButton);
		super.add(linePanelDisplay2);*/

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setSize(700, 460);
		setVisible(true);
	}

	private void updateStandardMessage(String message) {
		goldLabel.setForeground(GOLD_LABEL_COLOR);
		goldLabel.setText(message);
	}

	private void updateErrorMessage(String message) {
		goldLabel.setForeground(MESSAGE_ERROR_COLOR);
		goldLabel.setText(message);
	}

	public static void main(String[] args) {
		new Menu("Explorateurs Intelligents");
	}

}

/*protected void initActions() {
dirButton.addActionListener(new DirChooserAction());
fileButton.addActionListener(new FileChooserAction());
statButton.addActionListener(new StatChooserAction());
SizeButton.addActionListener(new SizeChooserAction());
titleButton.addActionListener(new TitleChooserAction());
subjectButton.addActionListener(new SubjectChooserAction());
dateButton.addActionListener(new DateChooserAction());
}*/

/*private class DirChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	FileChooser fileChooser = new FileChooser();

	File rep = fileChooser.chooseDirectory();
	retourDir = "Répertoire choisi : " + rep.getName();
	updateStandardMessage(retourDir);

	List<String> path = null;
	String item = "";
	try {
		path = fileChooser.listing(rep);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for (int i = 0; i < path.size(); i++) {
		item = item + path.get(i) + "\n";
	}
	zoneTexte.setText(item);
}
}*/

/*private class FileChooserAction implements ActionListener {
public void actionPerformed(ActionEvent e) {
	FileChooser fileChooser = new FileChooser();

	File fic = fileChooser.chooseFile();
	retourFile = "Fichier choisi : " + fic.getName();
	updateStandardMessage(retourFile);
	zoneTexte.setText(fic.getAbsolutePath());

}

}*/


/*private class DateChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
		String path = zoneTexte.getSelectedText();
		File oldFile = new File(path);
		File newFile = new File(path.replace(".odt", ".zip"));
		File source = new File(path.replace(".odt", ""));
		String dest = newFile.getAbsolutePath();

		Rename rename = new Rename();
		rename.rename(oldFile, newFile);

		String zipFilePath = newFile.getAbsolutePath();

		String destDir = source.getAbsolutePath();

		Unzip unzip = new Unzip();

		unzip.unzip(zipFilePath, destDir);
		
		String date = "";

			try {
				if(lecteur.exist(destDir, "dc:date")) {
				date = lecteur.afficherDate(destDir);
				
				updateStandardMessage("Date de création du Fichier : " + date);
				}
				else {
					updateErrorMessage("La date de création du fichier est manquante.");
				}
			} catch (ParserConfigurationException | SAXException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			

		try {
			zip.zip(source, dest);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		File[] liste = oldFile.getParentFile().listFiles();

		for (File fic : liste) {
			if (fic.equals(newFile)) {
				rename.rename(fic, oldFile);
			}
		}
		
	
}
}*/

/*private class TitleChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	String path = zoneTexte.getSelectedText();
	File oldFile = new File(path);
	File newFile = new File(path.replace(".odt", ".zip"));
	File source = new File(path.replace(".odt", ""));
	String dest = newFile.getAbsolutePath();

	Rename rename = new Rename();
	rename.rename(oldFile, newFile);

	String zipFilePath = newFile.getAbsolutePath();

	String destDir = source.getAbsolutePath();

	Unzip unzip = new Unzip();

	unzip.unzip(zipFilePath, destDir);
	
	String title = "";

		try {
			if(lecteur.exist(destDir, "dc:title")) {
			title = lecteur.afficherTitre(destDir);
			updateStandardMessage("Titre du Fichier : " + title);
			}
			else {
				updateErrorMessage("Ce fichier n'a pas de titre.");
				
			}
		} catch (ParserConfigurationException | SAXException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

	try {
		zip.zip(source, dest);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	File[] liste = oldFile.getParentFile().listFiles();

	for (File fic : liste) {
		if (fic.equals(newFile)) {
			rename.rename(fic, oldFile);
		}
	}
	
	
}

}*/

/*private class SubjectChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	String path = zoneTexte.getSelectedText();
	File oldFile = new File(path);
	File newFile = new File(path.replace(".odt", ".zip"));
	File source = new File(path.replace(".odt", ""));
	String dest = newFile.getAbsolutePath();

	Rename rename = new Rename();
	rename.rename(oldFile, newFile);

	String zipFilePath = newFile.getAbsolutePath();

	String destDir = source.getAbsolutePath();

	Unzip unzip = new Unzip();

	unzip.unzip(zipFilePath, destDir);
	
	String subject = "";

		try {
			if(lecteur.exist(destDir, "dc:subject")) {
			subject = lecteur.afficherSujet(destDir);
			updateStandardMessage("Sujet du Fichier : " + subject);
			}
			else {
				updateErrorMessage("Ce fichier n'a pas de sujet.");
			}
		} catch (ParserConfigurationException | SAXException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

	try {
		zip.zip(source, dest);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	File[] liste = oldFile.getParentFile().listFiles();

	for (File fic : liste) {
		if (fic.equals(newFile)) {
			rename.rename(fic, oldFile);
		}
	}
	
	
}

}*/

/*private class SizeChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	FileSize filesize = new FileSize();
	String path = zoneTexte.getSelectedText();
	Long size = filesize.findSize(path);
	
	updateStandardMessage("Poids du Fichier : " + size.toString());
}
}*/

/*private class StatChooserAction implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
	String path = zoneTexte.getSelectedText();
	File oldFile = new File(path);
	File newFile = new File(path.replace(".odt", ".zip"));
	File source = new File(path.replace(".odt", ""));
	String dest = newFile.getAbsolutePath();

	Rename rename = new Rename();
	rename.rename(oldFile, newFile);

	String zipFilePath = newFile.getAbsolutePath();

	String destDir = source.getAbsolutePath();

	Unzip unzip = new Unzip();

	unzip.unzip(zipFilePath, destDir);
	
	List<String> meta = null;
	String item = "";
	try {
		meta = lecteur.meta(destDir);
		for (int i = 0; i < meta.size(); i++) {
			item = item + meta.get(i) + "\n";
		}
		zoneTexte.setText(item);
		
	} catch (ParserConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SAXException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	try {
		zip.zip(source, dest);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	File[] liste = oldFile.getParentFile().listFiles();

	for (File fic : liste) {
		if (fic.equals(newFile)) {
			rename.rename(fic, oldFile);
		}
	}
	
	updateStandardMessage("Statistiques de " + oldFile.getName());
}
}*/

