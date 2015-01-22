package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hwz.textit.lib.Constants;

public class EmailConfirmation {

	public EmailConfirmation(String receiver, String receiverCC,
			String receiverBCC, String subject, String message, String prio, String type,
			String fileName) {
		createAndShowEmailConfirmation(receiver, receiverCC, receiverBCC, subject,
				message, prio, type, fileName);
	}

	private void createAndShowEmailConfirmation(String receiver,
			String receiverCC, String receiverBCC, String message, String subject, String prio,
			String type, String fileName) {
		// Create and set up the window.
		JFrame frame = new JFrame(Constants.CONFIRMATION);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildConfirmationPanel(frame, receiver, receiverCC, receiverBCC, subject,
				message, prio, type, fileName);

		// Display the window.
		frame.setVisible(true);
	}

	private void buildConfirmationPanel(JFrame frame, String receiver,
			String receiverCC, String receiverBCC, String subject, String message, String prio,
			String type, String fileName) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JLabel confirmationText = new JLabel("Ihr " + type
				+ " wurde erfolgreich versendet");
		JLabel confirmationReceiver = new JLabel("Empfänger: " + receiver);
		JLabel confirmationReceiverCC = new JLabel("Empfänger CC: "
				+ receiverCC);
		JLabel confirmationReceiverBCC = new JLabel("Empfänger BCC: "
				+ receiverBCC);
		JLabel priority = new JLabel("Email mit der Priorität: " + prio);
		JLabel subjectOutput = new JLabel("Betreff: " +subject);
		JLabel confirmationMessage = new JLabel("<html>Ihre Nachricht: "
				+ message + "</html>");

		JLabel confirmationFileName = new JLabel("Mit dem Anhang: " + fileName);
		JButton backButton = new JButton(Constants.BACK);

		// set properties of elements
		confirmationText.setBounds(10, 10, 400, 25);
		confirmationReceiver.setBounds(10, 40, 400, 25);
		confirmationReceiverCC.setBounds(10, 80, 400, 25);
		confirmationReceiverBCC.setBounds(10, 120, 400, 25);
		priority.setBounds(10, 160, 400, 25);
		subjectOutput.setBounds(10, 180, 250, 25);
		confirmationMessage.setBounds(10, 200, 400, 100);
		confirmationFileName.setBounds(10, 220, 400, 25);
		backButton.setBounds(10, 350, 200, 25);

		// add to panel
		panel.add(confirmationText);
		// display only if not empty
		if (!"".equals(receiver)) {
			panel.add(confirmationReceiver);
		}
		if (!"".equals(receiverCC)) {
			panel.add(confirmationReceiverCC);
		}
		if (!"".equals(receiverBCC)) {
			panel.add(confirmationReceiverBCC);
		}
		if (!"".equals(prio)) {
			panel.add(priority);
		}
		panel.add(subjectOutput);
		panel.add(confirmationMessage);

		if (!"".equals(fileName)) {
			panel.add(confirmationFileName);
		}
		panel.add(backButton);

		backButton.addActionListener(setBackButtonListener(frame));

		frame.add(panel);
	}

	private static ActionListener setBackButtonListener(JFrame frame) {
		ActionListener backButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StartGUI();
			}

		};

		return backButtonListener;
	}

}
