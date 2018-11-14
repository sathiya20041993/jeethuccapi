package com.app.coacingcenter.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

	private DateTimeUtil() {
	}

	public static Date getDate(String strDate, String format) {
		SimpleDateFormat sdFormatFrom = new SimpleDateFormat(format);
		try {
			return sdFormatFrom.parse(strDate);
		} catch (ParseException e) {
			logger.error("Exception occur while fetching getDate method ", e);
			return null;
		}
	}

	public static String switchDateFormat(String strDate, String formatFrom, String formatTo) {
		SimpleDateFormat sdFormatFrom = new SimpleDateFormat(formatFrom);
		SimpleDateFormat sdFormatTo = new SimpleDateFormat(formatTo);
		try {
			return sdFormatTo.format(sdFormatFrom.parse(strDate));
		} catch (ParseException e) {
			logger.error("Exception occur while fetching switchDateFormat method ", e);
			return null;
		}
	}

	public static String switchDateFormatPreviousYear(String strDate, String formatFrom, String formatTo) {
		DateFormat outputFormat = new SimpleDateFormat(formatTo);
		DateFormat inputFormat = new SimpleDateFormat(formatFrom);

		String inputText = strDate;
		Date date;
		try {
			date = inputFormat.parse(inputText);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.YEAR, -1);
			Date previouseYearDate = c.getTime();
			String outputText = outputFormat.format(previouseYearDate);
			return outputText;
		} catch (ParseException e) {
			logger.error("Exception occured in switchDateFormatPreviousYear method ", e);
			return null;
		}

	}

	/**
	 * Date to String format.
	 * 
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String dateToString(Date date, String format) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(format).format(date);
		}
		return dateStr;

	}

	/**
	 * This method is used to convert from date to timestamp.
	 * 
	 * @param Date
	 *            fromDate
	 * @return Timestamp
	 */
	public static Timestamp dateToTimeStamp(Date fromDate) {

		Timestamp timestamp = null;
		if (fromDate != null && getDateToMilliSeconds(fromDate) > -1) {
			timestamp = new Timestamp(getDateToMilliSeconds(fromDate));
		}
		return timestamp;

	}

	/**
	 * This method is used to convert from timestamp to date.
	 * 
	 * @param Timestamp
	 *            fromDate
	 * @return Date
	 */
	public static Date timeStampToDate(Timestamp fromDate) {

		Date date = null;
		if (fromDate != null && getDateToMilliSeconds(fromDate) > -1) {
			date = new Date(getDateToMilliSeconds(fromDate));
		}
		return date;

	}

	public static String dateStrFromTimeStamp(Timestamp timestamp, String toDateFormat) {
		if (timestamp != null) {
			return new SimpleDateFormat(toDateFormat).format(timestamp);
		} else {
			return "";
		}
	}

	/**
	 * @Method_Description : get current time as timestamp object
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp() {

		return new Timestamp(getDateToMilliSeconds(Calendar.getInstance().getTime()));
	}

	/**
	 * @Method_Description : get current time as timestamp object
	 * @return
	 */
	public static String getCurrentTimeStampAsString() {

		return String.valueOf(getCurrentTimeStamp());
	}

	/**
	 * @Method_Description : get current time as timestamp object
	 * @return
	 */
	public static String getStringForTimeStamp(Timestamp t) {

		return String.valueOf(t);
	}

	/**
	 * @Method_Description : get current date as date object
	 * @return
	 */
	public static Date getCurrentDate() {

		return new Date();
	}

	/**
	 * 
	 * @Method_Description : Method to format xmlGregorianCalendar date to MMDDYYYY
	 *                     String
	 * @param xmlGregorianCalendar
	 * @return
	 */
	public static String xMLGregorianCalendarToMMDDYYYY(XMLGregorianCalendar xmlGregorianCalendar) {
		logger.info("Entering xMLGregorianCalendarToMMDDYYYY() ={}", xmlGregorianCalendar);
		if (xmlGregorianCalendar != null) {
			XMLGregorianCalendar xmlDate = xmlGregorianCalendar;

			SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT_MMDDYYYY);
			logger.info("Leaving xMLGregorianCalendarToMMDDYYYY()");
			return dateFormat.format(xmlDate.toGregorianCalendar().getTime());
		} else {
			return null;
		}
	}

	public static XMLGregorianCalendar timeStampToXmlGregorian(Object value) throws DatatypeConfigurationException {

		if (value != null) {
			Timestamp timestamp = null;
			if (value instanceof String) {

				timestamp = new Timestamp((new Long((String) value)));
			} else if (value instanceof Timestamp) {
				timestamp = (Timestamp) value;
			} else {
				return null;
			}
			Date date = timeStampToDate(timestamp);
			DateFormat format = new SimpleDateFormat(CommonConstants.XML_GREGORIAN_CALENDAR_CONVERSION_FORMAT);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(date));
		}
		return null;
	}

	/**
	 * @Method_Description : Method to format Date string from one format to another
	 *                     format
	 * @param date
	 * @param initDateFormat
	 * @param endDateFormat
	 * @return
	 */
	public static String formatDateStringFromOneFormatToAnother(String date, String initDateFormat,
			String endDateFormat) {
		logger.info("Entering formatDate() with date={} , initDateFormat={}, endDateFormat={}", date, initDateFormat,
				endDateFormat);
		Date initDate;
		try {
			initDate = new SimpleDateFormat(initDateFormat).parse(date);
			SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
			logger.info("Leaving formatDate()");
			return formatter.format(initDate);
		} catch (ParseException e) {
			logger.error("Unable to parse date", e);
			return null;
		}
	}

	/**
	 * This method will convert the Sting which is in Date Format(yyyy-MM-dd
	 * HH:mm:ss) to Time Stamp
	 * 
	 * @return Timestamp
	 */
	public static Timestamp stringToTimeStamp(String inputString) {
		Timestamp timestamp = null;
		if (inputString != null && !inputString.equals("")) {
			SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				format.parse(inputString);
				timestamp = Timestamp.valueOf(inputString);
			} catch (ParseException e) {
				logger.error("Exception while access stringToTimeStamp : {}", e);
			}
		}
		return timestamp;
	}

	/**
	 * Method to get current time in milliseconds
	 * 
	 * @return
	 */
	public static long getCurrentTimeMillis() {
		return getDateToMilliSeconds(getCurrentDate());
	}

	/**
	 * Method to get current time in milliseconds
	 * 
	 * @return
	 */
	public static long getDateToMilliSeconds(Date date) {
		return date.getTime();
	}

	/**
	 * Method to get current date in EST
	 * 
	 * @param dateFormat
	 * @return
	 */

	public static String getCurrentDateInEST(String dateFormat) {
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE_EST));
		return formatter.format(getCurrentDate());
	}

	public static Date longToDate(Long date) {
		if (date != null) {
			return timeStampToDate(new Timestamp(date));
		} else {
			return null;
		}
	}

	/**
	 * convert timestamp to String
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String convertTimestampToString(Timestamp timestamp, String dateFormat) {
		if (timestamp == null) {
			return null;
		}
		Date date = timeStampToDate(timestamp);
		return dateToString(date, dateFormat);
	}

	/**
	 * convert date string to timestamp
	 * 
	 * @param dateString
	 * @param dateFormat
	 * @return
	 */
	public static Timestamp convertDateStringToTimestamp(String dateString, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		Timestamp timestamp = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			logger.error("Exception while parsing date string {}", dateString);
		}
		if (date != null) {
			timestamp = dateToTimeStamp(date);
		}
		return timestamp;
	}

	public static int convertDateToYear(Date date) {

		Integer year = 0;
		if (date != null) {
			String fromDate = switchDateFormat(date.toString(), CommonConstants.CONVERSION_DATE_FORMAT,
					CommonConstants.DB_DATE_FORMAT);
			if (fromDate != null) {
				year = Integer.parseInt((String) fromDate.subSequence(0, 4));
			}
		} else {
			year = 0;
		}
		return year;
	}

	/**
	 * Convert Time in millis to date String.
	 * 
	 * @param timeInMillies
	 * @return String
	 */
	public static String convertTimeInMillisToDateString(Long timeInMillies) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeInMillies);
		return calendar.getTime().toString();
	}

	public static String getFirstDateOfMonth(Date date) {
		String dateFormat = CommonConstants.DB_DATE_FORMAT;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

		DateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE_EST));
		return formatter.format(cal.getTime());

	}

	public static String getFirstDateOfYear(Date date) {
		String dateFormat = CommonConstants.DB_DATE_FORMAT;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		DateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE_EST));
		return formatter.format(cal.getTime());

	}

	public static String getOneYearPrior(Date date) {
		String dateFormat = CommonConstants.DB_DATE_FORMAT;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.YEAR, -1);

		DateFormat formatter = new SimpleDateFormat(dateFormat);
		formatter.setTimeZone(TimeZone.getTimeZone(CommonConstants.TIME_ZONE_EST));
		return formatter.format(cal.getTime());

	}

	public static Date beginOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date endOfDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	/**
	 * This method is to get previous month start date
	 * 
	 * @return
	 */
	public static Date getPrevMonthStartDate() {
		Calendar prevMonthStartCalendar = Calendar.getInstance();
		prevMonthStartCalendar.add(Calendar.MONTH, -1);
		prevMonthStartCalendar.set(Calendar.DAY_OF_MONTH, 1);
		prevMonthStartCalendar.set(Calendar.HOUR_OF_DAY, 0);
		prevMonthStartCalendar.set(Calendar.MINUTE, 0);
		prevMonthStartCalendar.set(Calendar.SECOND, 0);
		prevMonthStartCalendar.set(Calendar.MILLISECOND, 000);
		return prevMonthStartCalendar.getTime();
	}

	/**
	 * This method is to get previous month end date
	 * 
	 * @return
	 */
	public static Date getPrevMonthEndDate() {
		Calendar prevMonthEndCalendar = Calendar.getInstance();
		prevMonthEndCalendar.add(Calendar.MONTH, -1);
		prevMonthEndCalendar.set(Calendar.DAY_OF_MONTH, prevMonthEndCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		prevMonthEndCalendar.set(Calendar.HOUR_OF_DAY, 23);
		prevMonthEndCalendar.set(Calendar.MINUTE, 59);
		prevMonthEndCalendar.set(Calendar.SECOND, 59);
		prevMonthEndCalendar.set(Calendar.MILLISECOND, 999);
		return prevMonthEndCalendar.getTime();
	}

	/**
	 * Append end time as end of day for given date.
	 * 
	 * @param toDate
	 * @return
	 */
	public static Date appendEndTime(Date toDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * Append start time as day start for given date.
	 * 
	 * @param fromDate
	 * @return Date
	 */
	public static Date appendStartTime(Date fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}

	public static int getFromMonth(Date date) {

		int fromMonth = getMonth(date) + 1;
		return fromMonth;
	}

	public static DateFormatSymbols getDateFormatSymbols() {
		return new DateFormatSymbols();
	}

	public static int getMonth(Date date) {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
		Integer month = Integer.parseInt(simpleDateformat.format(date));
		return month;
	}

	/**
	 * add days to date in java
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * subtract days to date in java
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);

		return cal.getTime();
	}

}
