package com.learnapp.shortener.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HashHelper {

	private static Log log = LogFactory.getLog(HashHelper.class);

	private HashHelper() {}
	
	public static String getHash(String url) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(url.getBytes());
            BigInteger no = new BigInteger(1, digest);

			String hashFullText = no.toString(16);
			hash = hashFullText.substring(0, 5);
		} catch (NoSuchAlgorithmException e) {
			log.error("MD5 did not work:", e);
		}
		return hash;
	}
}
