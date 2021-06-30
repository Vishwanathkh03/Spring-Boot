package org.vishwa.springboot.employeeportal.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmpUtils {

	private final Random RANDOM = new SecureRandom();

	public String generateUserId(long length) {
		return getUserId(length);
	}

	private String getUserId(long length) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyyHHmmss");
		String NUMBERS = dateFormat.format(new Date());
		StringBuilder returnValue = new StringBuilder("EMP_"+Calendar.YEAR);
		for (int i = 0; i < length; i++) {
			returnValue.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
		}
		return returnValue.toString();
	}
}
