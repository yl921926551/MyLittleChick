package cn.ly.mlc.util;

import org.testng.annotations.Test;

public class SerialNoGenerateUtilTest {

	@Test
	public void generateSerialNo() {
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
		debug(SerialNoGenerateUtil.generateSerialNo("01"));
	}
	
	private void debug(String msg) {
		System.out.println(msg);
	}
}
