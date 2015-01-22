package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hwz.textit.lib.Constants;
import com.hwz.textit.lib.Validation;

public class SendSMS extends Message {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements used for the SWING GUI
		JLabel receiverLabel = new JLabel(Constants.RECEIVER);
		JLabel adressBookLabel = new JLabel(Constants.ADRESSBOOK);
		JTextField receiverInput = new JTextField();
		JComboBox adressBook = new JComboBox();
		JLabel messageLabel = new JLabel(Constants.TEXT);
		JTextArea messageInput = new JTextArea();
		JButton sendButton = new JButton(Constants.SEND);
		JButton cancelButton = new JButton(Constants.CANCEL);
		JButton endButton = new JButton(Constants.END);

		// Create JComboBox dropdown menu for adressbook
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
		sendButton.setBounds(100, 300, 80, 25);
		cancelButton.setBounds(200, 300, 100, 25);
		endButton.setBounds(400, 300, 100, 25);

		// add items to the frame
		panel.add(receiverLabel);
		panel.add(receiverInput);
		panel.add(adressBookLabel);
		panel.add(adressBook);
		panel.add(messageLabel);
		panel.add(messageInput);
		panel.add(sendButton);
		panel.add(cancelButton);
		panel.add(endButton);

		sendButton.addActionListener(setSendButtonListener(frame,
				receiverInput, messageInput));
		cancelButton.addActionListener(setCancelButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));
		frame.add(panel);

	}

	// send message, check if it's valid and go to

	private static ActionListener setSendButtonListener(JFrame frame,
			JTextField receiverInput, JTextArea messageInput) {
		ActionListener sendButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String receiver = receiverInput.getText();
				String message = messageInput.getText();

				if (Validation.isSMSValid(message)) {
					if (Validation.isNumberFormatValid(receiver)) {
						frame.dispose();
						new Confirmation(receiver, message, Constants.SMS, "");
					} else {
						JOptionPane.showMessageDialog(null,
								Constants.NUMBER_NOT_VALID);
					}
				} else {
					JOptionPane
							.showMessageDialog(null, Constants.SMS_NOT_VALID);

				}
			}

		};

		return sendButtonListener;
	}

}
