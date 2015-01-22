package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.hwz.textit.lib.Constants;
import com.hwz.textit.lib.Validation;

public class SendTweet extends Message {

	@Override
	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements used for the SWING GUI
		JLabel messageLabel = new JLabel(Constants.TEXT);
		JTextArea messageInput = new JTextArea();
		JButton sendButton = new JButton(Constants.SEND);
		JButton cancelButton = new JButton(Constants.CANCEL);
		JButton endButton = new JButton(Constants.END);

		messageInput.setLineWrap(true);
		messageInput.setWrapStyleWord(false);

		// set properties of elements

		messageLabel.setBounds(10, 10, 80, 25);
		messageInput.setBounds(100, 10, 250, 150);
		sendButton.setBounds(100, 300, 80, 25);
		cancelButton.setBounds(200, 300, 100, 25);
		endButton.setBounds(400, 300, 100, 25);

		// add items to the frame

		panel.add(messageLabel);
		panel.add(messageInput);
		panel.add(sendButton);
		panel.add(cancelButton);
		panel.add(endButton);

		sendButton
				.addActionListener(setSendButtonListener(frame, messageInput));
		cancelButton.addActionListener(setCancelButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));
		frame.add(panel);

	}

	// send message, check if it's valid and go to

	private static ActionListener setSendButtonListener(JFrame frame,
			JTextArea messageInput) {
		ActionListener sendButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = messageInput.getText();

				if (Validation.isTweetValid(message)) {

					new Confirmation("", message, Constants.TWEET, "");
					{

					}
				} else {
					JOptionPane.showMessageDialog(null,
							Constants.TWEET_NOT_VALID);

				}
			}

		};

		return sendButtonListener;
	}

}
