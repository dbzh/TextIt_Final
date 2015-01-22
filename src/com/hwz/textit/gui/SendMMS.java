package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

public class SendMMS extends Message {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JLabel receiverLabel = new JLabel(Constants.RECEIVER);
		JLabel adressBookLabel = new JLabel(Constants.ADRESSBOOK);
		JTextField receiverInput = new JTextField();
		JComboBox adressBook = new JComboBox();
		JLabel messageLabel = new JLabel(Constants.TEXT);
		JTextArea messageInput = new JTextArea();
		JButton selectFileButton = new JButton(Constants.CHOOSE_IMAGE);
		JLabel fileNameLabel = new JLabel("");
		JButton sendButton = new JButton(Constants.SEND);
		JButton cancelButton = new JButton(Constants.CANCEL);
		JButton endButton = new JButton(Constants.END);

		int count = 3;

		for (int i = 0; i < 3; i++)
			adressBook.addItem(users[count++]);

		adressBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receiverInput.setText((String) ((JComboBox) e.getSource())
						.getSelectedItem());
			}
		});

		messageInput.setLineWrap(true);
		messageInput.setWrapStyleWord(false);

		// set properties of elements
		receiverLabel.setBounds(10, 10, 80, 25);
		receiverInput.setBounds(100, 10, 160, 25);
		adressBook.setBounds(100, 40, 160, 25);
		messageLabel.setBounds(10, 80, 80, 25);
		messageInput.setBounds(100, 80, 250, 150);
		selectFileButton.setBounds(100, 250, 100, 25);
		fileNameLabel.setBounds(210, 250, 200, 25);
		sendButton.setBounds(100, 300, 80, 25);
		cancelButton.setBounds(200, 300, 100, 25);
		endButton.setBounds(400, 300, 100, 25);
		// add panels to gui
		panel.add(receiverLabel);
		panel.add(receiverInput);
		panel.add(adressBookLabel);
		panel.add(adressBook);
		panel.add(messageLabel);
		panel.add(messageInput);
		panel.add(selectFileButton);
		panel.add(fileNameLabel);
		panel.add(sendButton);
		panel.add(cancelButton);
		panel.add(endButton);

		selectFileButton.addActionListener(setSelectFileButtonListener(frame,
				fileNameLabel));
		sendButton.addActionListener(setSendButtonListener(frame,
				receiverInput, messageInput, fileNameLabel));
		cancelButton.addActionListener(setCancelButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));
		frame.add(panel);

	}

	// Select picture from local lib
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

	// pass information from SendMMS to Confirmation
	private static ActionListener setSendButtonListener(JFrame frame,
			JTextField receiverInput, JTextArea messageInput,
			JLabel fileNameInput) {
		ActionListener sendButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String receiver = receiverInput.getText();
				String message = messageInput.getText();
				String fileName = fileNameInput.getText();
				//Check if the entered msg is valid
				if (Validation.isMMSValid(message)) {
					//check if the entered number is valid
					if (Validation.isNumberFormatValid(receiver)) {
						frame.dispose();
						new Confirmation(receiver, message, Constants.MMS,
								fileName);
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.NUMBER_NOT_VALID);
					}
				} else {
					JOptionPane
							.showMessageDialog(null, Constants.MMS_NOT_VALID);

				}
			}

		};

		return sendButtonListener;
	}

}
