package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.hwz.textit.lib.Constants;
import com.hwz.textit.lib.Validation;

public class SendEmail extends Message {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JLabel receiverLabel = new JLabel(Constants.RECEIVER);
		JLabel receiverCCLabel = new JLabel(Constants.RECEIVERCC);
		JLabel receiverBCCLabel = new JLabel(Constants.RECEIVERBCC);
		JLabel adressBookLabel = new JLabel(Constants.ADRESSBOOK);
		JLabel adressBookLabel1 = new JLabel(Constants.ADRESSBOOK);
		JLabel adressBookLabel2 = new JLabel(Constants.ADRESSBOOK);
		JLabel priority = new JLabel("Priorität");
		JLabel subjectLabel = new JLabel("Betreff");
		JLabel fileNameLabel = new JLabel("");
		JLabel messageLabel = new JLabel(Constants.TEXT);
		JTextField receiverInput = new JTextField();
		JTextField receiverCCInput = new JTextField();
		JTextField receiverBCCInput = new JTextField();
		JTextField subjectInput = new JTextField();
		JComboBox adressBook = new JComboBox();
		JComboBox adressBook1 = new JComboBox();
		JComboBox adressBook2 = new JComboBox();
		JCheckBox priorityHigh = new JCheckBox("Hoch");
		JCheckBox priorityLow = new JCheckBox("Niederig");
		JTextArea messageInput = new JTextArea();
		JButton selectFileButton = new JButton(Constants.CHOOSE_FILE);
		JButton sendButton = new JButton(Constants.SEND);
		JButton cancelButton = new JButton(Constants.CANCEL);
		JButton endButton = new JButton(Constants.END);

		// Create JComboBox dropdown menu for adressbook

		int count = 0;

		for (int i = 0; i < 3; i++)
			adressBook.addItem(users[count++]);

		adressBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receiverInput.setText((String) ((JComboBox) e.getSource())
						.getSelectedItem());
			}
		});
		int count1 = 0;

		for (int i = 0; i < 3; i++)
			adressBook1.addItem(users[count1++]);

		adressBook1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receiverCCInput.setText((String) ((JComboBox) e.getSource())
						.getSelectedItem());
			}
		});
		int count2 = 0;

		for (int i = 0; i < 3; i++)
			adressBook2.addItem(users[count2++]);

		adressBook2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receiverBCCInput.setText((String) ((JComboBox) e.getSource())
						.getSelectedItem());
			}
		});

		messageInput.setLineWrap(true);
		messageInput.setWrapStyleWord(false);

		// set properties of elements
		receiverLabel.setBounds(10, 10, 100, 25);
		receiverInput.setBounds(100, 10, 160, 25);
		adressBookLabel.setBounds(10, 40, 100, 25);
		adressBook.setBounds(100, 40, 160, 25);
		receiverCCLabel.setBounds(10, 80, 100, 25);
		receiverCCInput.setBounds(100, 80, 160, 25);
		adressBookLabel.setBounds(10, 120, 80, 25);
		adressBook1.setBounds(100, 120, 160, 25);
		receiverBCCLabel.setBounds(10, 160, 100, 25);
		receiverBCCInput.setBounds(100, 160, 160, 25);
		adressBookLabel2.setBounds(10, 200, 80, 25);
		adressBook2.setBounds(100, 200, 160, 25);
		priority.setBounds(350, 240, 80, 25);
		priorityHigh.setBounds(400, 240, 80, 25);
		priorityHigh.setSelected(false);
		priorityLow.setBounds(480, 240, 80, 25);
		priorityLow.setSelected(false);
		subjectLabel.setBounds(10, 240, 80, 25);
		subjectInput.setBounds(100, 240, 250, 25);
		messageLabel.setBounds(10, 280, 80, 25);
		messageInput.setBounds(100, 280, 250, 250);
		sendButton.setBounds(100, 600, 80, 25);
		fileNameLabel.setBounds(10, 600, 100, 25);
		selectFileButton.setBounds(200, 600, 110, 25);
		cancelButton.setBounds(320, 650, 100, 25);
		endButton.setBounds(450, 650, 100, 25);

		receiverInput.requestFocus();

		// add to panel
		panel.add(receiverLabel);
		panel.add(receiverInput);
		panel.add(adressBookLabel);
		panel.add(adressBook);
		panel.add(receiverCCLabel);
		panel.add(receiverCCInput);
		panel.add(adressBookLabel1);
		panel.add(adressBook1);
		panel.add(receiverBCCLabel);
		panel.add(receiverBCCInput);
		panel.add(adressBookLabel2);
		panel.add(adressBook2);
		panel.add(subjectLabel);
		panel.add(subjectInput);
		panel.add(messageLabel);
		panel.add(messageInput);
		panel.add(priority);
		panel.add(priorityHigh);
		panel.add(priorityLow);
		panel.add(fileNameLabel);
		panel.add(selectFileButton);
		panel.add(sendButton);
		panel.add(cancelButton);
		panel.add(endButton);

		selectFileButton.addActionListener(setSelectFileButtonListener(frame,
				fileNameLabel));
		sendButton.addActionListener(setSendButtonListener(frame,
				receiverInput, receiverCCInput, receiverBCCInput, subjectInput, messageInput,
				priorityHigh, priorityLow, fileNameLabel));
		cancelButton.addActionListener(setCancelButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));
		frame.add(panel);

	}
	//attach a picture to the email
	private static ActionListener setSelectFileButtonListener(JFrame frame,
			JLabel fileNameLabel) {
		ActionListener selectFileButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser openFile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG", "jpg");
				openFile.setFileFilter(filter);
				openFile.showOpenDialog(null);
				String fileName = openFile.getSelectedFile().getName();
				fileNameLabel.setText(fileName);
				frame.repaint();

			}

		};

		return selectFileButtonListener;
	}

	// pass information from SendEmail to EmailConfirmation
	protected ActionListener setSendButtonListener(JFrame frame,
			JTextField receiverInput, JTextField receiverCCInput,
			JTextField receiverBCCInput, JTextField subjectInput, JTextArea messageInput,
			JCheckBox priorityHigh, JCheckBox priorityLow, JLabel fileNameInput) {
		ActionListener sendButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prio = "";
				// check priority
				boolean highSelected = priorityHigh.isSelected();
				if (highSelected) {
					prio = "Hoch";
				}

				boolean lowSelected = priorityLow.isSelected();
				if (lowSelected) {
					prio = "Tief";
				}
				
				String receiver = receiverInput.getText();
				String receiverCC = receiverCCInput.getText();
				String receiverBCC = receiverBCCInput.getText();
				String subject = subjectInput.getText();
				String message = messageInput.getText();
				String fileName = fileNameInput.getText();

				// check for BCC receivers and validate
				if (!"".equals(receiverBCC)) {
					if (Validation.isValidEmailAddressBCC(receiver, receiverCC,
							receiverBCC)) {
						frame.dispose();
						new EmailConfirmation(receiver, receiverCC,
								receiverBCC, subject, message, prio, Constants.EMAIL,
								fileName);
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.EMAIL_NOT_VALID);

					}
					// Check for CC receivers and validate
				} else if (!"".equals(receiverCC)) {

					if (Validation.isValidEmailAddressCC(receiver, receiverCC)) {
						frame.dispose();
						new EmailConfirmation(receiver, receiverCC,
								receiverBCC, subject, message, prio, Constants.EMAIL,
								fileName);
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.EMAIL_NOT_VALID);

					}

				} else {
					if (Validation.isValidEmailAddress(receiver)) {
						frame.dispose();
						new EmailConfirmation(receiver, receiverCC,
								receiverBCC, subject, message, prio, Constants.EMAIL,
								fileName);
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.EMAIL_NOT_VALID);
					}
				}
			}
		};

		return sendButtonListener;
	}
}
