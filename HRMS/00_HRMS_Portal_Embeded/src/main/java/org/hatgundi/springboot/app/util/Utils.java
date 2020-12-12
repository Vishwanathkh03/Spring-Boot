/**
 * 
 */
package org.hatgundi.springboot.app.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Vishwanath Hatgundi
 *
 */
@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();

	public String generateUserId(long length) {
		return getUserId(length);
	}

	private String getUserId(long length) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String NUMBERS = simpleDateFormat.format(new Date());

		StringBuilder returnValue = new StringBuilder("EMP");
		for (int i = 0; i < length; i++) {
			returnValue.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
		}
		return returnValue.toString();
	}

	public static void main(String[] args) {
//		String generateUserId = generateUserId(5);
//		System.out.println("UserId : " + generateUserId);
	}
}
