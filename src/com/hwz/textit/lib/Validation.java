package com.hwz.textit.lib;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

//general validations
public class Validation {

	// checks lenght of MMS is not longer than 160 characters

	public static boolean isSMSValid(String text) {

		if (text.length() <= 160) {
			return true;
		} else {
			return false;
		}
	}

	// checks if a real email address is entered
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);

			emailAddr.validate();

		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// checks if a real email address is entered
	public static boolean isValidEmailAddressCC(String email, String receiverCC) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			InternetAddress emailAddrCC = new InternetAddress(receiverCC);

			emailAddr.validate();
			emailAddrCC.validate();

		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// checks if a real email address is entered
	public static boolean isValidEmailAddressBCC(String email,
			String receiverCC, String receiverBCC) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			InternetAddress emailAddrCC = new InternetAddress(receiverCC);
			InternetAddress emailAddrBCC = new InternetAddress(receiverBCC);

			emailAddr.validate();
			emailAddrCC.validate();
			emailAddrBCC.validate();

		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// checks lenght of MMS is not longer than 1000 characters
	public static boolean isMMSValid(String text) {

		if (text.length() <= 1000) {
			return true;
		} else {
			return false;
		}
	}

	// checks lenght of a tweet is not longer than 140 characters

	public static boolean isTweetValid(String text) {

		if (text.length() <= 140) {
			return true;
		} else {
			return false;
		}
	}

	// proofs the format of the entered number
	public static boolean isNumberFormatValid(String number) {
		number = number.replaceAll(" ", "");

		if (number.startsWith("+") && number.length() == 12) {
			return true;
		} else if (!number.startsWith("+") && number.length() == 10) {
			return true;
		}

		return false;
	}
}
