package com.app.coacingcenter.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author : Daniel Devadoss
 * @Description : Common conversion
 * @Created_On : Mar 2, 2017
 */
public class CommonConversions {

	/**
	 * @Method_Description :Method to convert String to Integer
	 * @Created_By : Daniel Devadoss
	 * @Created_On : Mar 2, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param intval
	 * @return
	 */
	private static final Logger logger = LoggerFactory.getLogger(CommonConversions.class);

	private CommonConversions() {

	}

	/**
	 * @Method_Description : method to Convert Y Or N to Boolean
	 * @Created_By : Daniel Devadoss
	 * @Created_On : Mar 2, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param val
	 * @return
	 */
	public static boolean ynToBoolean(String val) {

		return "Y".equals(val);
	}

	/**
	 * @Method_Description : Method to convert TimeStamp to ddmmyyyy format
	 *                     string date
	 * @Created_By : Daniel Devadoss
	 * @Created_On : Mar 2, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param timestamp
	 * @return
	 */
	public static String timeStampToDDMMYYYY(Timestamp timestamp) {
		if (timestamp != null) {

			SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.UI_DATE_FORMAT);
			Date date = DateTimeUtil.timeStampToDate(timestamp);
			return dateFormat.format(date);
		} else {
			return null;
		}
	}

	/**
	 * @Method_Description :
	 * @Created_By : Daniel Devadoss
	 * @Created_On : Mar 2, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param date
	 * @return
	 */
	public static Timestamp ddmmyyyyToTimeStamp(String date) {
		if (date != null) {
			if (date.length() > 0) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				Date parsedDate;
				try {
					parsedDate = dateFormat.parse(date);
					return DateTimeUtil.dateToTimeStamp(parsedDate);

				} catch (ParseException e) {
					return null;
				}
			}
		}
		return null;

	}

	public static Timestamp mmddyyyyToTimeStamp(String date) {
		if (date != null) {
			if (date.length() > 0) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date parsedDate;
				try {
					parsedDate = dateFormat.parse(date);
					return DateTimeUtil.dateToTimeStamp(parsedDate);

				} catch (ParseException e) {
					return null;
				}
			}
		}
		return null;

	}

	/**
	 * 
	 * @Method_Description :
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 9, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @return
	 */
	public static Timestamp getNowTimeStamp() {

		return DateTimeUtil.getCurrentTimeStamp();
	}

	/**
	 * 
	 * @Method_Description : Method to convert Integer to big decimal
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 9, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param value
	 * @return
	 */
	public static BigDecimal intToBigdecimal(Integer value) {

		if (value != null) {
			return new BigDecimal(value);
		} else {
			return null;
		}
	}

	public static String intToString(Integer value) {

		if (value != null) {
			return value.toString();
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @description:method to convert integer string value to Integer, for
	 *                     unparsable values null is returned
	 * @param value
	 * @return
	 */
	public static Integer stringToInt(String value) {
		logger.info("entering stringToInt with value={} ", value);
		if (value != null && !StringUtils.isEmpty(value.trim())) {
			try {
				logger.info("parsing string value to integer");
				return Integer.parseInt(value.trim());
			} catch (Exception e) {
				logger.error("unable to parse string={}  , exception={}", value, CommonUtility.getExceptionMessage(e));
				return null;
			}

		} else {
			logger.info("leaving stringToInt with null");
			return null;
		}
	}

	/**
	 * 
	 * @Method_Description : method to CONVERT BIGDECIMAL to INT
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param digDecimalValue
	 * @return
	 */
	public static Integer bigdecimalToInt(BigDecimal digDecimalValue) {

		if (digDecimalValue != null) {
			return digDecimalValue.intValue();
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @Method_Description : method to convert Y/N To Boolean
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 10, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param string
	 * @return
	 */
	public static Boolean ynToBooleanConversion(String string) {
		if (string != null) {
			if (string.equals("Y") || string.equals("A")) {
				return true;
			} else if (string.equals("N") || string.equals("I")) {
				return false;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @Method_Description : method to convert boolean To Y/N
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 10, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param booleanValue
	 * @return
	 */
	public static String booleanToYnConversion(Boolean booleanValue) {
		if (booleanValue != null) {
			if (booleanValue) {
				return "Y";
			} else {
				return "N";
			}
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @Method_Description : method to convert String Array To String
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 10, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param array
	 * @return
	 */
	public static String stringArrayToStringConversion(String[] array) {
		if (array != null) {
			StringBuilder output = new StringBuilder();
			for (String val : array) {
				output.append(val + ",");
			}
			return output.toString();
		}
		return null;
	}

	/**
	 * @Method_Description : method to convert convert comma seperated string to
	 *                     array - only use oppiste to
	 *                     stringArrayToStringConversion() method
	 * @Created_By : Daniel Devadoss
	 * @Created_On : May 10, 2017
	 * @Edited_By :
	 * @Edit_Description :
	 * @Edited_On :
	 * @param string
	 * @return
	 */
	public static String[] stringToStringArray(String string) {
		if (string != null) {

			return string.split(",");
		} else {
			return null;
		}

	}

	public static Timestamp isoToTimeStamp(String dateString) {

		if (dateString != null && dateString.trim() != "") {

			if (dateString.contains("/")) {
				return mmddyyyyToTimeStamp(dateString);
			} else {
				Date parsedDate = DateTimeUtil.getDate(dateString, CommonConstants.ISO_DATE_FORMAT);
				return DateTimeUtil.dateToTimeStamp(parsedDate);
			}

		} else {
			return null;
		}

	}

	public static Date isoToDate(String dateString) {

		if (dateString != null && dateString.trim() != "") {

			if (dateString.contains("/")) {
				return DateTimeUtil.getDate(dateString, CommonConstants.DATE_FORMAT_MMDDYYYY);
			} else {
				return DateTimeUtil.getDate(dateString, CommonConstants.ISO_DATE_FORMAT);
			}

		} else {
			return null;
		}

	}

	/**
	 * Converts float to Bigdecimal
	 * 
	 * @author nishanthd
	 * @param value
	 * @return
	 */
	public static BigDecimal floatToBigDecimal(Float value) {
		if (value != null) {
			return BigDecimal.valueOf(value);
		}
		return null;
	}

	/**
	 * Converts Bigdecimal to float
	 * 
	 * @author nishanthd
	 * @param value
	 * @return
	 */
	public static Float bigDecimalToFloat(BigDecimal value) {
		if (value != null) {
			return value.floatValue();
		}
		return null;
	}

	/**
	 * 
	 * @description:
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMMDDYYYYFromYYYMMDDHHMMSSS(String date) {
		logger.info("entering getMMDDYYYYFromYYYMMDDHHMMSSS with date ={}", date);
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			SimpleDateFormat requiredDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			return requiredDateFormat.format(currentDateFormat.parse(date));
		} catch (Exception e) {
			logger.error("leaving with error e={}", e);
			return null;
		}
	}

	public static String getMMDDYYYYFromYYYMMDD(String date) {
		logger.info("entering getMMDDYYYYFromYYYMMDDHHMMSSS with date ={}", date);
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			SimpleDateFormat currentDateFormat = new SimpleDateFormat(CommonConstants.DB_DATE_FORMAT);
			SimpleDateFormat requiredDateFormat = new SimpleDateFormat(CommonConstants.UI_DATE_FORMAT);
			return requiredDateFormat.format(currentDateFormat.parse(date));
		} catch (Exception e) {
			logger.error("leaving with error e={}", e);
			return null;
		}
	}

	public static String dateToString(Date date) {
		if (date != null) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			return df.format(date);
		} else {
			return null;
		}
	}

	public static String doubleToString(Double value) {

		if (value != null) {
			return value.toString();
		} else {
			return null;
		}

	}

	public static String bigDecimalToString(BigDecimal value) {

		if (value != null) {
			return "$" + value.toString();
		} else {
			return null;
		}

	}

	public static String bigDecimalToFormatString(BigDecimal value) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		if (value != null) {
			return "$" + decimalFormat.format(new BigDecimal(value.toString()).floatValue());
		} else {
			return null;
		}

	}

	public static String getYYYYMMDDHHMMSSFromDate(Date date) {
		if (date != null) {
			DateFormat df = new SimpleDateFormat(CommonConstants.AUDIT_TRIAL_DATE_SEARCH_FORMAT);
			return df.format(date);
		} else {
			return null;
		}
	}

	public static String toDecimalFormat(Double value) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		if (value != null) {
			return formatter.format(value);
		} else {
			return "-";
		}
	}

	/**
	 * method to format phone number
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static String formatPhone(String phoneNumber) {
		if (phoneNumber != null) {
			phoneNumber = phoneNumber.trim();
			if (phoneNumber.length() == 10) {
				phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
			} else if (phoneNumber.length() == 14)
				phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3 X$4");
		} else {
			phoneNumber = "";
		}
		return phoneNumber;
	}

	/**
	 * method to format zip code
	 * 
	 * @param zipCode
	 * @return
	 */
	public static String formatZipCode(String zipCode) {
		if (zipCode != null) {
			zipCode = zipCode.trim();
			if (zipCode.length() > 5) {
				zipCode = zipCode.replaceFirst("(\\d{5})(\\d+)", "$1-$2");
			}
		} else {
			zipCode = "";
		}
		return zipCode;
	}

	/**
	 * remove hyphen and truncate zip for create cair service
	 * 
	 * @param input
	 * @param maxLength
	 * @return
	 */
	public static String zipCodeFormatter(String input, int maxLength) {
		String returnString = input;
		if (StringUtils.hasText(input)) {
			if (input.contains(CommonConstants.HYPHEN)) {
				returnString = input.replaceAll(CommonConstants.HYPHEN, CommonConstants.EMPTY_STRING);
			}
			if (returnString.length() > maxLength) {
				return returnString.substring(0, maxLength);
			}
		}
		return returnString;
	}

	/**
	 * method to format mileage
	 * 
	 * @param mileage
	 * @return
	 */
	public static String formatMileage(Integer mileage) {
		String mileageStr = "";
		if (mileage != null) {
			DecimalFormat formatter = new DecimalFormat("#,###,###");
			mileageStr = formatter.format(mileage);
		}
		return mileageStr;
	}

	/**
	 * Method to prepend zero for dealer code
	 * 
	 * @param dealerCode
	 * @return String
	 */
	public static String formatDealerCode(String dealerCode) {

		String zero = "";
		String formattedDealer = dealerCode;

		if (!StringUtils.isEmpty(dealerCode) && dealerCode.length() < 5) {
			int zeroAppendLength = 5 - dealerCode.length();
			for (int index = 0; index < zeroAppendLength; index++) {
				zero = zero + "0";
			}
			return zero + formattedDealer;
		}
		return formattedDealer;
	}

	public static String getNumbersFromString(String str) {

		if (!StringUtils.isEmpty(str)) {
			String numberOnly = str.replaceAll("[^0-9]", "");
			return numberOnly;
		} else {
			return null;
		}

	}

	public static String formatToProperHtmlString(String htmlString) {
		htmlString = htmlString.replace(CommonConstants.HTML_NBSP, CommonConstants.SPACE_ASCII);
		htmlString = htmlString.replace(CommonConstants.BR_TAG, CommonConstants.EMPTY_STRING);
		htmlString = htmlString.replaceAll("&(?!#|quot;)", "&amp;");
		htmlString = CommonConstants.DIV_STYLE_WIDTH_755PX + htmlString + CommonConstants.DIV_CLOSING_TAG;

		// below regex will replace all self ending html tags with
		// proper closing tag.
		htmlString = htmlString.replaceAll(CommonConstants.SELF_ENDING_TAG_REGEX, CommonConstants.REGEX_BACK_REFERENCE);
		return htmlString;
	}

	/**
	 * converts string to bigdecimal. returns null if there is
	 * NumberFormatException
	 * 
	 * @param amountString
	 * @return
	 */
	public static BigDecimal stringToBigDecimal(String amountString) {
		String amountStringNew = amountString.replaceAll(CommonConstants.SEDTRAN_COMMA_SEPARATOR,
				CommonConstants.EMPTY_STRING);
		BigDecimal amount = null;
		try {
			amount = new BigDecimal(amountStringNew);
		} catch (NumberFormatException e) {
			logger.error("error parsing {}", amountString, " ,exception-{},", e);
		}
		return amount;
	}

	/**
	 * Method to convert Object type to Double If value is null, Double will
	 * return as Zero
	 * 
	 * @param value
	 *            Object
	 * @return Double
	 */
	public static double convertTodouble(Object value) {
		if (value == null) {
			return 0.00;
		}
		if (value instanceof Integer) {
			return CommonUtility.round(((double) value), 2);
		} else if (value instanceof Double) {
			return CommonUtility.round(((double) value), 2);
		} else if (value instanceof BigDecimal && ((BigDecimal) value).doubleValue() > 0) {
			return CommonUtility.round(((BigDecimal) value).doubleValue(), 2);
		}
		return 0.00;
	}

	/**
	 * This method converts string to fixed length string based on the length
	 * 
	 * @param stringValue
	 * @param length
	 * @return
	 */
	public static String convertStringToFixedLength(String stringValue, int length) {
		String returnString;
		String formattedString = stringValue == null || stringValue.contains("null") ? CommonConstants.EMPTY_STRING
				: stringValue;
		if (formattedString.length() <= length) {
			String format = "%-" + length + "s";
			returnString = String.format(format, formattedString);
		} else {
			returnString = formattedString.substring(0, length);
		}
		return returnString;
	}

	/**
	 * This method converts decimal value to string prefixing zeros
	 * 
	 * @param decimalValue
	 * @param length
	 * @return
	 */
	public static String convertDecimalToString(BigDecimal decimalValue, int length) {

		String formattedString = decimalValue != null ? decimalValue.toString().replace(".", "") : "";

		String format = "%1$" + length + "s";
		formattedString = String.format(format, formattedString).replace(' ', '0');
		return formattedString;
	}

	/**
	 * Method to convert Stack trace to string
	 * 
	 * @param ex
	 * @return
	 */
	public static String stackTraceToString(Exception ex) {
		String regex = "\\r\\n[\\tat]*";
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();
		stackTrace = stackTrace.replaceAll(regex, "");
		return stackTrace;
	}

	/**
	 * Checks if given string equals 'A'.
	 * 
	 * @param target
	 * @return true if equals else false.
	 */
	public static Boolean aiToBoolean(String target) {
		return !StringUtils.isEmpty(target) && target.equals(CommonConstants.ACTIVE);
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> queryToObjectList(Query query) {
		List<Object[]> queryList = null;
		try {

			if (query != null) {
				query.setFirstResult(0);
				query.setMaxResults(100);
				queryList = query.getResultList();
			}
		} catch (Exception e) {
			logger.error(" Exception while occuring queryToObjectList : ", e);
		}
		return queryList;
	}

	/**
	 * Creates invoice number for cash and keep when reopen
	 * 
	 * @param cairId
	 *            String
	 * @param number
	 *            String
	 * @param toIncrement
	 *            Boolean
	 * @return result String
	 */
	public static String createInvoiceNumberForCashAndKeep(String cairId, String invoiceNumber, Boolean toIncrement) {

		String result = null;
		if (invoiceNumber != null) {
			if (toIncrement) {
				String[] splittedInvoice = StringUtils.split(invoiceNumber, "-");
				Integer invoiceValue = Integer.parseInt(splittedInvoice[1].substring(0, 2));
				invoiceValue++;
				result = String.format("%s%s%s%s", cairId.trim(), CommonConstants.HYPHEN,
						String.format("%02d", invoiceValue), CommonConstants.CAIR_NUMBER_PREFIX);
			} else {
				result = invoiceNumber;
			}
		} else {
			result = String.format("%s%s%s%s", cairId.trim(), CommonConstants.HYPHEN,
					CommonConstants.CASH_AND_KEEP_INVOICE, CommonConstants.CAIR_NUMBER_PREFIX);
		}
		return result;
	}

	public static String replaceQueryStrings(String value) {
		String regex = "'|\\?";
		return value.replaceAll(regex, "");
	}

}
