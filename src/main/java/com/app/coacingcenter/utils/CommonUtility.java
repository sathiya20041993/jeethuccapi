package com.app.coacingcenter.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.HashMap;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class CommonUtility {

	private static final Logger logger = LoggerFactory.getLogger(CommonUtility.class);

	private CommonUtility() {
	}

	public static int getPageIndex(int first, int rows) {
		int pageNo = 0;
		if (first != 0) {
			pageNo = first / rows;
		}
		return pageNo;
	}

	/**
	 * Check for a valid String.
	 * 
	 * @param value
	 * @return
	 */
	public static boolean validString(String value) {
		if (value != null && !value.isEmpty())
			return true;
		return false;
	}

	/**
	 * Checks the given string array contains the given string.
	 * 
	 * @param targetValue
	 * @param valueArr
	 * @return true , false if not contains.
	 */
	public static boolean isArrayContainsThisString(String targetValue, String[] valueArr) {

		for (String value : valueArr) {
			if (targetValue.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isLimitExceeds(Float target, Float limit) {

		if (target == null || limit == null) {
			return false;
		}
		if (target > limit) {
			return true;
		}
		return false;
	}

	/**
	 * Method to convert object to String If value is null, return as dot
	 * 
	 * @param value
	 *            Object
	 * @return String
	 */
	public static String isStringEmpty(Object value) {
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return value.toString();
	}

	/**
	 * Method to return zero for null and negative values
	 * 
	 * @param value
	 *            Integer
	 * @return Integer
	 */
	public static Integer isIntegerLessThanZero(Integer value) {
		if (value == null || value < 0) {
			return (new Integer(0));
		}
		return value;
	}

	/**
	 * Method to convert Object type to Double If value is null, Double will return
	 * as Zero
	 * 
	 * @param value
	 *            Object
	 * @return Double
	 */
	public static Double isDoubleLessThanZero(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Integer && (Integer) value > 0) {
			return Double.valueOf((Integer) value);
		} else if (value instanceof Double && (Double) value > 0) {
			return (Double) value;
		} else if (value instanceof BigDecimal && ((BigDecimal) value).doubleValue() > 0) {
			return ((BigDecimal) value).doubleValue();
		} else if (value instanceof Float && ((Float) value > 0)) {
			return Math.round((Float) value * 100.0) / 100.0;
		}
		return Double.valueOf(0);
	}

	/**
	 * Creates invoice number
	 * 
	 * @param cairId
	 * @param number
	 * @return
	 */
	public static String createInvoiceNumber(String cairId, String number) {

		String result = null;
		if (cairId != null && number != null) {
			if (number.length() < 2) {
				number = "0" + number;
			}
			result = String.format("%s%s%s%s", cairId.trim(), CommonConstants.HYPHEN, number,
					CommonConstants.CAIR_NUMBER_PREFIX);
		}
		return result;
	}

	/**
	 * Checks whether the given target lies between the given min and max.
	 * 
	 * 
	 * @param target
	 * @param min
	 *            should not be null
	 * @param max
	 *            should not be null
	 * @return boolean true ,false
	 */
	public static boolean isBetween(Float target, Float min, Float max) {

		boolean result = false;
		if ((min < target && target < max)) {
			result = true;
		}
		return result;
	}

	/**
	 * Method to validate integer when it is null
	 * 
	 * @param value
	 * @return
	 */
	public static Integer validateInteger(String value) {

		if (value != null) {
			return Integer.parseInt(value);
		} else {
			return 0;
		}
	}

	public static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024 * 1024;
		byte[] buf = new byte[size];
		;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			// len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			if (bos.size() < size) {
				while ((len = is.read(buf, 0, size)) != -1)
					bos.write(buf, 0, len);
				buf = bos.toByteArray();
			}
		}
		return buf;
	}

	/**
	 * Method to get valid string in array from input strings
	 * 
	 * @param stringInputs-
	 *            string inputs
	 * @return
	 */
	public static String[] getValidStringArrayFromInputStrings(String... stringInputs) {
		String[] stringArray = new String[stringInputs.length];
		int i = 0;
		for (String string : stringInputs) {
			if (!StringUtils.isEmpty(string)) {
				stringArray[i] = string;
				i++;
			}
		}
		return stringArray;
	}

	public static String returnEmptyStringIfNull(String stringValue) {

		return !StringUtils.isEmpty(stringValue) ? stringValue.trim() : "  ";
	}

	public static String getPhoneExt(String phone) {
		if (StringUtils.isEmpty(phone)) {
			return null;
		}
		return phone.substring(0, 3);

	}

	public static Integer getLastTwoDigit(Integer value) {
		Integer lastTwoDigit;
		if (value != null && value.toString().length() > 2)
			lastTwoDigit = value % 100;
		else {
			lastTwoDigit = value;
		}
		return lastTwoDigit;
	}

	public static String getFixedLengthString(String string, int length) {
		if (!StringUtils.isEmpty(string) && string.length() > length) {
			return string.substring(0, length);
		} else {
			return string;
		}
	}

	public static String replaceNullWithHyphen(String value) {
		if (value == null || value == "null") {
			value = CommonConstants.HYPHEN;
		}
		return value;
	}

	/**
	 * This method will return a sql aggregation function SUM(col_name)
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getSqlSumQuery(String columnName) {
		return CommonConstants.SQL_FUNC_SUM.replace(CommonConstants.COLUMN_NAME_PLACEHOLDER, columnName);
	}

	/**
	 * This method will return a sql null check function COALESCE(col_name)
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getSqlCoalesceQuery(String columnName) {
		return CommonConstants.SQL_FUNC_COALESCE.replace(CommonConstants.COLUMN_NAME_PLACEHOLDER, columnName);
	}

	/**
	 * This method will return a sql GROUP BY class with given column name
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getSqlGroupBy(String columnName) {
		return CommonConstants.SQL_GROUP_BY.replace(CommonConstants.COLUMN_NAME_PLACEHOLDER, columnName);
	}

	/**
	 * This method will return a sql ORDER BY class with given column name
	 * 
	 * @param columnName
	 * @return
	 */
	public static String getSqlOrderBy(String columnName) {
		return CommonConstants.SQL_ORDER_BY.replace(CommonConstants.COLUMN_NAME_PLACEHOLDER, columnName);
	}

	/**
	 * converts Y for input true/TRUE/Y/y , false for false/FALSE/N/n to N, returns
	 * null for any other input
	 * 
	 * @param input
	 * @return
	 */
	public static String reaqChangeTrueFalseToYAndN(String input) {
		if (StringUtils.hasText(input)) {
			if ("true".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input) || "Y".equalsIgnoreCase(input)) {
				return "Y";
			} else if ("false".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input) || "N".equalsIgnoreCase(input)) {
				return "N";
			} else {
				return null;
			}
		}
		return null;
	}

	/**
	 * returns substring from index 0 to maxLength-1 for input.
	 * 
	 * @param input
	 * @param maxLength
	 * @return
	 */
	public static String reaqTruncateString(String input, int maxLength) {
		if (StringUtils.hasText(input) && input.length() > maxLength) {
			return input.substring(0, maxLength);
		}
		return input;

	}

	/**
	 * Generic Method to replace a value if null or returns the same value
	 * 
	 * @param valueToBeChecked
	 *            - value to be checked for null
	 * @param nullReplaceValue
	 *            - Value to be replaced if the valueToBeChecked is null
	 * @return
	 */
	public static <T> T replaceNull(T valueToBeChecked, T nullReplaceValue) {

		T value = valueToBeChecked;
		if (valueToBeChecked == null || ("null").equals(valueToBeChecked) || ("").equals(valueToBeChecked)) {
			value = nullReplaceValue;
		}
		return value;

	}

	/**
	 * Method to trim value
	 * 
	 * @param value
	 * @return String
	 */
	public static String trim(String value) {
		if (value != null) {
			return value.trim();
		}
		return null;
	}

	/**
	 * truncate the string to fit the size of sedtran db columns
	 * 
	 * @param input
	 * @param maxLength
	 * @return
	 */
	public static String sedtranTruncateString(String input, int maxLength) {
		if (StringUtils.hasText(input) && input.length() > maxLength) {
			return input.substring(0, maxLength);
		} else if (StringUtils.hasText(input) && input.length() <= maxLength) {
			return input;
		}
		return CommonConstants.EMPTY_STRING;

	}

	/**
	 * 
	 * @description:Method to remove space from string
	 * @param string
	 * @return
	 */
	public static String getStringWithoutSpace(String string) {
		if (!StringUtils.isEmpty(string)) {
			return string.replace(" ", "");
		} else {
			return string;
		}
	}

	/**
	 * 
	 * @description:
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Method to roundoff value
	 * 
	 * @param value
	 * @param places
	 * @return double
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * Returns code details A-Auction D-Dealer O-Other
	 * 
	 * @param vhclCode
	 * @return
	 */
	public static String getVehicleLocation(String vhclCode) {
		String vehicleLoc = CommonConstants.HYPHEN;

		if ("A".equals(vhclCode)) {
			vehicleLoc = "Auction";
		} else if ("D".equals(vhclCode)) {
			vehicleLoc = "Dealer";
		} else if ("O".equals(vhclCode)) {
			vehicleLoc = "Other";
		}
		return vehicleLoc;
	}

	/**
	 * Returns code for name Auction - A Dealer-D Other - O
	 * 
	 * @param vhclCode
	 * @return
	 */
	public static String getVehicleLocationCode(String vehicleLoc) {
		String vhclCode = CommonConstants.HYPHEN;
		vehicleLoc = vehicleLoc.toLowerCase();
		if ("auction".contains(vehicleLoc)) {
			vhclCode = "A";
		} else if ("dealer".contains(vehicleLoc)) {
			vhclCode = "D";
		} else if ("other".contains(vehicleLoc)) {
			vhclCode = "O";
		}
		return vhclCode;
	}

	/**
	 * Method used for execute native query
	 * 
	 * @param entityManager
	 * @param query
	 * @return Query
	 */
	public static Query getJPAQuery(EntityManager entityManager, String query) {

		Query queryObj = entityManager.createNativeQuery(query);
		return queryObj;
	}

	public static String getExceptionMessage(Throwable e) {
		if (e != null)
			return e.getMessage();
		else
			return null;
	}

	/**
	 * Subtract check amount from buyback amount
	 * 
	 * @param buybackAmt
	 * @param checkAmount
	 * @return
	 */
	public static BigDecimal subtractBuybackAmount(BigDecimal buybackAmt, BigDecimal checkAmount) {
		BigDecimal newAmt = buybackAmt != null ? buybackAmt : BigDecimal.valueOf(0);
		if (checkAmount != null && buybackAmt != null) {
			newAmt = buybackAmt.subtract(checkAmount);
		}
		BigDecimal zero = BigDecimal.valueOf(0);
		if (newAmt.compareTo(zero) < 0) {
			newAmt = zero;
		}
		return newAmt;
	}

	public static Integer objectToInteger(Object value) {
		if (value != null) {
			return (Integer) value;
		} else {
			return 0;
		}
	}

	public static BigDecimal objectToBigDecimal(Object value) {
		if (value != null) {
			return new BigDecimal(value.toString());
		} else {
			return null;
		}
	}

	/**
	 * Email ID validation
	 * 
	 * @param email
	 * @return boolean
	 */
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
	/*
	 * public static void main(String[] args) { String unescapedText =
	 * "<script>alert(\"You've been attacked!\")</script>";
	 * System.out.println(escapeHtml(unescapedText)); }
	 */

	public static String escapeHtml(String inputString) {
		StringBuilder builder = new StringBuilder();
		char[] charArray = inputString.toCharArray();
		for (char nextChar : charArray) {
			String entityName = charMap.get((int) nextChar);
			if (entityName == null) {
				if (nextChar > 0x7F)
					builder.append("&#").append(Integer.toString(nextChar, 10)).append(";");
				else
					builder.append(nextChar);
			} else
				builder.append(entityName);
		}
		return builder.toString();
	}

	protected static final HashMap<Integer, String> charMap = new HashMap<Integer, String>();

	static {
		charMap.put(34, "&quot;"); // double quote
		charMap.put(35, "&#35;"); // hash mark (no HTML named entity)
		charMap.put(38, "&amp;"); // ampersand
		charMap.put(39, "&apos;"); // apostrophe, aka single quote
		charMap.put(60, "&lt;"); // less than
		charMap.put(62, "&gt;"); // greater than
	}

	public static String stringToUTF8(String content) {
		byte[] byteText = content.getBytes(Charset.forName("UTF-8"));
		try {
			// To get original string from byte.
			content = new String(byteText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("Exception while accessing stringToUTF8 {}", e);
		}
		return content;
	}

	public static Integer getRandomFifty() {
		return (int) (Math.random() * 50);
	}

}
