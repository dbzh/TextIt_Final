package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hwz.textit.lib.Constants;

public class Confirmation {

	public Confirmation(String receiver, String message, String type,
			String fileName) {
		createAndShowConfirmation(receiver, message, type, fileName);
	}
/**
 * 
 * @param receiver
 * @param message
 * @param type
 * @param fileName
 */
	private void createAndShowConfirmation(String receiver, String message,
			String type, String fileName) {
		// Create and set up the window.
		JFrame frame = new JFrame(Constants.CONFIRMATION);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildConfirmationPanel(frame, receiver, message, type, fileName);

		// Display the window.
		frame.setVisible(true);
	}
/**
 * 
 * @param frame
 * @param receiver
 * @param message
 * @param type
 * @param fileName
 */
	private void buildConfirmationPanel(JFrame frame, String receiver,
			String message, String type, String fileName) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JLabel confirmationText = new JLabel("Ihr " + type
				+ " wurde erfolgreich versendet");
		JLabel confirmationReceiver = new JLabel("Empfänger: " + receiver);
		JLabel confirmationMessage = new JLabel("<html>Ihre Nachricht: "
				+ message + "</html>");
		JLabel confirmationFileName = new JLabel("Mit dem Bild: " + fileName);
		JButton backButton = new JButton(Constants.BACK);

		// set properties of elements
		confirmationText.setBounds(10, 10, 400, 25);
		confirmationReceiver.setBounds(10, 40, 400, 25);
		confirmationMessage.setBounds(10, 160, 400, 100);
		confirmationFileName.setBounds(10, 180, 400, 25);
		backButton.setBounds(10, 350, 200, 25);

		// add to panel
		panel.add(confirmationText);
		// display only if not empty
		if (!"".equals(receiver)) {
			panel.add(confirmationReceiver);
		}
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
