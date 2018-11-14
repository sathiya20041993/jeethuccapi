package com.app.coacingcenter.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConvertor {

	// public static void main(String[] args) {

	// 	System.out.println(CurrencyConvertor.convertToINR(100000));
	// }

	public static String convertToINR(double amount) {
		String inr = " Rs 0.0 ";
		if (amount != 0.0) {
			inr = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(amount);
		}
		return inr;
	}
}
