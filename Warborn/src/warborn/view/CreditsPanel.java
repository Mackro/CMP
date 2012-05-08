package warborn.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class CreditsPanel extends JPanel {
	public CreditsPanel() {
		setLayout(null);
		setSize(450, 350);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCredits.setBounds(99, 11, 87, 44);
		add(lblCredits);
		
		JLabel lblProjectleader = new JLabel("Project Leader:");
		lblProjectleader.setBounds(10, 68, 153, 14);
		add(lblProjectleader);
		
		JLabel lblLeadDesigner = new JLabel("Lead Designer:");
		lblLeadDesigner.setBounds(10, 93, 153, 14);
		add(lblLeadDesigner);
		
		JLabel lblLead = new JLabel("Lead Sound/Story Writer:");
		lblLead.setBounds(10, 118, 153, 14);
		add(lblLead);
		
		JLabel lblLeadProgrammer = new JLabel("Lead Programmer:");
		lblLeadProgrammer.setBounds(10, 143, 153, 14);
		add(lblLeadProgrammer);
		
		JLabel lblTeodorOstwald = new JLabel("Teodor Ostwald");
		lblTeodorOstwald.setBounds(195, 68, 200, 14);
		add(lblTeodorOstwald);
		
		JLabel lblEmilhsberg = new JLabel("Emil \u00C5hsberg");
		lblEmilhsberg.setBounds(195, 93, 200, 14);
		add(lblEmilhsberg);
		
		JLabel lblRickardHallberg = new JLabel("Rickard Hallberg");
		lblRickardHallberg.setBounds(195, 118, 200, 14);
		add(lblRickardHallberg);
		
		JLabel lblMarkusOtterberg = new JLabel("Markus Otterberg");
		lblMarkusOtterberg.setBounds(195, 143, 200, 14);
		add(lblMarkusOtterberg);
		
		JLabel lblSpecialThanks = new JLabel("Special Thanks");
		lblSpecialThanks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSpecialThanks.setBounds(62, 168, 177, 44);
		add(lblSpecialThanks);
		
		JLabel lblSoundtracks = new JLabel("Soundtracks:");
		lblSoundtracks.setBounds(10, 223, 153, 14);
		add(lblSoundtracks);
		
		JLabel lblVoid = new JLabel("VOID");
		lblVoid.setBounds(195, 223, 200, 14);
		add(lblVoid);
		
		JLabel lblMapBackground = new JLabel("Map Background:");
		lblMapBackground.setBounds(10, 248, 153, 14);
		add(lblMapBackground);
		
		JLabel lblYamogogydeviantartcom = new JLabel("yamogogy.deviantart.com");
		lblYamogogydeviantartcom.setBounds(195, 248, 200, 14);
		add(lblYamogogydeviantartcom);
		
		JLabel lblSpellbookBackground = new JLabel("Spellbook Background:");
		lblSpellbookBackground.setBounds(10, 273, 153, 14);
		add(lblSpellbookBackground);
		
		JLabel lblAshleyleedeviantartcom = new JLabel("ashley-lee.deviantart.com");
		lblAshleyleedeviantartcom.setBounds(195, 273, 200, 14);
		add(lblAshleyleedeviantartcom);
		
		JLabel lblSupervisor = new JLabel("Supervisor:");
		lblSupervisor.setBounds(10, 323, 153, 14);
		add(lblSupervisor);
		
		JLabel lblAdamWaldenberg = new JLabel("Adam Waldenberg");
		lblAdamWaldenberg.setBounds(195, 323, 200, 14);
		add(lblAdamWaldenberg);
		
		JLabel lblNewLabel = new JLabel("Most Other Images:");
		lblNewLabel.setBounds(10, 298, 153, 14);
		add(lblNewLabel);
		
		JLabel lblJwbjerkMeopengameartorg = new JLabel("\n\nJ.W.Bjerk\nme / opengameart.org");
		lblJwbjerkMeopengameartorg.setBounds(195, 298, 200, 14);
		add(lblJwbjerkMeopengameartorg);
	}
}
