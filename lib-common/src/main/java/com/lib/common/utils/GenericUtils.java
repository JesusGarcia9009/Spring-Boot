/**
 * 
 */
package com.lib.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@Slf4j
public class GenericUtils {

	private GenericUtils() {
	}

	@SuppressWarnings("deprecation")
	public static Date getDateCLT() {
		Date result = null;
		Date now = new Date();
		try {
			now.setHours(12);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(now);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone(ConstantesUtil.TIME_ZONE));

			String dateString = sdf.format(calendar.getTime());
			result = sdf.parse(dateString);
			result.setHours(12);
			
		} catch (ParseException e) {
			log.error("[getDateCLT]::ERROR error parse");
			result = null;
		}

		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static Date getSetTimeZone(Date date) {
		Date result = null;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone(ConstantesUtil.TIME_ZONE));

			String dateString = sdf.format(calendar.getTime());
			result = sdf.parse(dateString);
			result.setHours(12);
			
		} catch (ParseException e) {
			log.error("[getSetTimeZone]::ERROR error parse");
			result = null;
		}

		return result;
	}
	
	public static String formatNumberCLT(String number) {
		Locale locale  = new Locale("es", "CLT");
		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);

		String format = decimalFormat.format(Integer.valueOf(number));
		
		return format;
	}
	
	
	public static String ifNullisBlank(Object object) {
		String result = "";
		try {
			result = object == null ? "" : object.toString();
		}catch (Exception e) {
			log.error("[ifNullisBlank]::ERROR error parse");
		}
		return result;
	}
	
	public static BigDecimal ifNullisCero(Object object) {
		return object == null ? new BigDecimal(0) : new BigDecimal(object.toString());
	}
	
	public static Date ifNullisDate(Object object) {
		Date result = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			result = object == null ? null : GenericUtils.getSetTimeZone(formatter.parse(object.toString()));
		} catch (ParseException e) {
			log.error("[GenericUtils::ifNullisDate]::ERROR error parse");
		}
		return result;
	}
	
	
	public static Date ifNotNullParseDate(Object object) {
		Date result = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");

			result = object == null ? null : GenericUtils.getSetTimeZone(formatter.parse(object.toString()));
		} catch (ParseException e) {
			log.error("[GenericUtils::ifNullisDate]::ERROR error parse");
		}
		return result;
	}
	
}
