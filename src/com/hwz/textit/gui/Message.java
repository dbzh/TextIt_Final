package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Superclass for all the Send subclasses containing information regarding window size, the, for now, static addressbook and globally used buttons such as cancle, back and end
 */
public class Message {

	// Adressbook with static users
	public static String[] users = { "simon@hwz.ch", "mauro@hwz.ch",
			"luca@hwz.ch", "0761234576", "0783215489", "0793218954" };

	// Cancle button redirectes to StartGui

	public static ActionListener setCancelButtonListener(JFrame frame) {
		ActionListener cancelButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StartGUI();
			}

		};

		return cancelButtonListener;
	}

	// Backbutton Brings closes current frame and reopens StartGUI
	public static ActionListener setBackButtonListener(JFrame frame) {
		ActionListener backButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StartGUI();
			}

		};

		return backButtonListener;
	}

	// endbutton closes the frame
	public static ActionListener setEndButtonListener(JFrame frame) {
		ActionListener endButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};
		return endButtonListener;

	}

	public Message() {
		showMessageGUI();
	}
	
	private void showMessageGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TextIt");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildMSGPanel(frame);

		// Display the window.
		frame.setVisible(true);
	}

	protected void buildMSGPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		frame.add(panel);

	}

	protected ActionListener setSendButtonListener(JFrame frame,
			JTextField receiverInput, JTextField receiverCCInput,
			JTextField receiverBCCInput, JTextArea messageInput) {
		// TODO Auto-generated method stub
		return null;
	}
}
