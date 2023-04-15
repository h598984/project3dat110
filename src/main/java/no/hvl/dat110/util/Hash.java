package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static BigInteger hashOf(String entity) {

		BigInteger hashint = null;

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		try {

			// we use MD5 with 128 bits digest
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			// compute the hash of the input 'entity'
			byte[] entityBytes = messageDigest.digest(entity.getBytes());

			// convert the hash into hex format
			String hex = toHex(entityBytes);

			// convert the hex into BigInteger
			hashint = new BigInteger(hex, 16);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// return the BigInteger

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// compute the number of bits = bitSize()

		// compute the address size = 2 ^ number of bits
		BigInteger b = new BigInteger("2");

		return b.pow(bitSize());
	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length
		MessageDigest messageDigest = null;

		try {

			messageDigest = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		digestlen = messageDigest.getDigestLength();

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
