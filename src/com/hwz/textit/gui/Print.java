package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.hwz.textit.lib.Constants;

public class Print extends Message {

	@Override
	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JLabel printerLabel = new JLabel(Constants.PRINTER);
		JLabel messageLabel = new JLabel(Constants.TEXT);
		JTextArea messageInput = new JTextArea();
		JButton chooseButton = new JButton(Constants.CHOOSE);
		JButton cancelButton = new JButton(Constants.CANCEL);
		JButton sendButton = new JButton(Constants.PRINT);
		JButton endButton = new JButton(Constants.END);

		// set properties of elements
		printerLabel.setBounds(10, 10, 100, 25);
		chooseButton.setBounds(100, 10, 100, 25);
		cancelButton.setBounds(220, 10, 100, 25);
		messageLabel.setBounds(10, 240, 80, 25);
		messageInput.setBounds(100, 240, 250, 250);
		sendButton.setBounds(100, 550, 100, 25);
		endButton.setBounds(400, 550, 100, 25);

		// add to panel
		panel.add(printerLabel);
		panel.add(chooseButton);
		panel.add(messageLabel);
		panel.add(messageInput);
		panel.add(sendButton);
		panel.add(cancelButton);
		panel.add(endButton);

		sendButton
				.addActionListener(setSendButtonListener(frame, messageInput));
		chooseButton.addActionListener(setChooseButtonListener(frame));
		cancelButton.addActionListener(setCancelButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));

		frame.add(panel);
	}

	private static ActionListener setChooseButtonListener(JFrame frameverInput) {
		ActionListener chooseButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// method to call the printer dialog
				PrinterJob pj = PrinterJob.getPrinterJob();
				if (pj.printDialog()) {
					try {
						pj.print();
					} catch (PrinterException exc) {
						System.out.println(exc);
					}
				}

			}

		};

		return chooseButtonListener;
	}

	private static ActionListener setSendButtonListener(JFrame frame,
			JTextArea messageInput) {
		ActionListener sendButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = messageInput.getText();

				new Confirmation("", message, Constants.PRINTED, "");

			}

		};

		return sendButtonListener;
	}
}
