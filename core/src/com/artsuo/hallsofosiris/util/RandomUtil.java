package com.artsuo.hallsofosiris.util;

import java.util.Random;

public class RandomUtil {

	private static final Random rnd = new Random(System.currentTimeMillis());
	
	public static int randomInt(int max) {
		return rnd.nextInt(max);
	}
}
