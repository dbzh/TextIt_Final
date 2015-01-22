package com.hwz.textit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hwz.textit.lib.Constants;

public class StartGUI {
	public StartGUI() {
		showSartGUI();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StartGUI();
			}
		});
	}

	private void showSartGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame(Constants.TEXTIT);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buildOverviewPanel(frame);

		// Display the window.
		frame.setVisible(true);
	}

	private void buildOverviewPanel(JFrame frame) {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		// Create Elements
		JButton emailButton = new JButton(Constants.EMAIL);
		JButton smsButton = new JButton(Constants.SMS);
		JButton mmsButton = new JButton(Constants.MMS);
		JButton printerButton = new JButton(Constants.PRINTER);
		JButton tweetButton = new JButton(Constants.TWEET);
		JButton endButton = new JButton(Constants.END);

		// set properties of elements
		emailButton.setBounds(10, 10, 100, 25);
		smsButton.setBounds(10, 40, 100, 25);
		mmsButton.setBounds(10, 80, 100, 25);
		printerButton.setBounds(10, 120, 100, 25);
		tweetButton.setBounds(10, 160, 100, 25);
		endButton.setBounds(10, 400, 100, 25);
		aboutButton.setBounds(150, 400, 100, 25);

		// add to panel
		panel.add(emailButton);
		panel.add(smsButton);
		panel.add(mmsButton);
		panel.add(printerButton);
		panel.add(tweetButton);
		panel.add(endButton);

		// ActionListeners for buttons
		emailButton.addActionListener(setEmailButtonListener(frame));
		smsButton.addActionListener(setSMSButtonListener(frame));
		mmsButton.addActionListener(setMMSButtonListener(frame));
		printerButton.addActionListener(setPrinterButtonListener(frame));
		tweetButton.addActionListener(setTweetButtonListener(frame));
		endButton.addActionListener(setEndButtonListener(frame));
		frame.add(panel);
	}

	/*
	 * ActionListeners
	 */

	private static ActionListener setEmailButtonListener(JFrame frame) {
		ActionListener emailButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SendEmail();
				frame.dispose();
			}
		};

		return emailButtonListener;
	}

	private static ActionListener setSMSButtonListener(JFrame frame) {
		ActionListener smsButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SendSMS();
				frame.dispose();
			}
		};

		return smsButtonListener;
	}

	private static ActionListener setMMSButtonListener(JFrame frame) {
		ActionListener mmsButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SendMMS();
				frame.dispose();
			}
		};

		return mmsButtonListener;
	}

	private static ActionListener setPrinterButtonListener(JFrame frame) {
		ActionListener printerButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Print();
				frame.dispose();
			}
		};

		return printerButtonListener;
	}

	private static ActionListener setTweetButtonListener(JFrame frame) {
		ActionListener tweetButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SendTweet();
				frame.dispose();
			}
		};

		return tweetButtonListener;
	}

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

	public static ActionListener setEndButtonListener(JFrame frame) {
		ActionListener endButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};
		return endButtonListener;

	}


}
