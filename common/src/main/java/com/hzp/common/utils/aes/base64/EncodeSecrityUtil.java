package com.hzp.common.utils.aes.base64;

public class EncodeSecrityUtil {

	public static String toEncryption(String content) {

		String skey = "qwertyuiopasdfgh";
		String estr = "";
		try {
			// 加密
			byte[] encryptResultStr = BackAES.encrypt(content, skey, 0);
			estr = new String(encryptResultStr);
			// System.out.println("方法-加密后："+new String(encryptResultStr));
			// String decryptString = BackAES.decrypt(new
			// String(encryptResultStr), skey, 0);
			// System.out.println("方法-解密后：" + decryptString);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return estr == null ? "" : estr;
	}
	
}
