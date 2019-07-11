package com.account.config;

import java.util.UUID;


public class RandomKeyGenerator {

	
	public static String generateAccountNumber() {
		String bankcode = "78";
		UUID uuid = UUID.randomUUID();
		String numericUUID = Long.toString(uuid.getMostSignificantBits())+
				Long.toString(uuid.getLeastSignificantBits());
		numericUUID = numericUUID.replaceAll("-", "").substring(0,9);
		return bankcode.concat(numericUUID);
		
	}
	

}

