package com.pdr.common.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.pdr.common.exception.ValidacionException;

public class UtilDecimal {
	
	public static final double THRESHOLD = 0.000001;
	public static final String MSG_ERROR_VALOR_NUMERICO_INVALIDO = "valor numerico invalido";
	
	public static boolean isEqual(BigDecimal decimal1, BigDecimal decimal2) {
		BigDecimal difference;
		BigDecimal theshold;

		if (decimal1 == null && decimal2 == null) {
			return true;
		} else if (decimal1 == null) {
			return false;
		} else if (decimal2 == null) {
			return false;
		}

		theshold = BigDecimal.valueOf(THRESHOLD);
		difference = decimal1.subtract(decimal2).abs();

		return difference.compareTo(theshold) < 0;
	}
	
	/**
	 * Validacion de montos si son altos y le aumenta la precision y evitar los
	 * exponenciales en string
	 *
	 * @param attr
	 */
	public static String conviertNumeroString(String attr) {

		MathContext mc = new MathContext(13, RoundingMode.HALF_UP);
		String cast = new BigDecimal(attr, mc).setScale(2).stripTrailingZeros().toPlainString();
		attr = (cast);
		return attr;
	}

	/**
	 * convierte un valor a bigdecimal.
	 * 
	 * @param attr
	 * @return
	 */
	public static BigDecimal conviertStringToBigdecimal(String attr) throws ValidacionException {
		String cleanBg = CleanBigDecimal(attr);
		if (cleanBg.contains("E")) {
			conviertStringToBigdecimal(stringToPrecisionBigDecimalString(attr));
		} else if (!cleanBg.matches("^[0-9]+([.][0-9]+)?$")) {
			ValidacionException.createWith(MSG_ERROR_VALOR_NUMERICO_INVALIDO);
		}

		MathContext mc = new MathContext(cleanBg.length(), RoundingMode.UNNECESSARY);
		BigDecimal cast = new BigDecimal(cleanBg, mc).setScale(100, RoundingMode.UNNECESSARY).stripTrailingZeros();
		return cast;
	}
	
	/**
	 * String to bigDecimal con precision
	 * 
	 * @param value
	 * @return
	 */
	public static String stringToPrecisionBigDecimalString(String value) {
		MathContext mc = new MathContext(value.length(), RoundingMode.UNNECESSARY);
		BigDecimal cast = new BigDecimal(value, mc).setScale(100, RoundingMode.UNNECESSARY).stripTrailingZeros();
		return cast.toPlainString();
	}
	
	
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String CleanBigDecimal(String value) {

		String validaCerosIzq = (value.length() >= 1) ? value.substring(0, 1) : "";
		String castVal = value.replace(" ", "");

		castVal = (castVal.contains(".")) ? castVal.replace(".", "") : castVal;
		castVal = (castVal.contains(",")) ? castVal.replace(",", ".") : castVal;
		castVal = (castVal.contains(" ")) ? castVal.replace(" ", "") : castVal;

		if (!validaCerosIzq.equals("0")) {
			// para valores numericos con decimales.
			if (castVal.matches("^[0-9]+([.][0-9]+)?$")) {
				value = stringToPrecisionBigDecimalString(castVal);
			}

			if (castVal.contains("E")) {
				value = stringToPrecisionBigDecimalString(castVal);
			}
		}
		return castVal;
	}


}
