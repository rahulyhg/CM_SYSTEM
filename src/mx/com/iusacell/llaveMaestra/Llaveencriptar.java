package mx.com.iusacell.llaveMaestra;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class Llaveencriptar {
	
	
    private final static String alg = "AES";
	private final static String cI = "AES/CBC/PKCS5Padding";

	public String cutKey(String keyValue) {
		if (keyValue.length() > 16) {
			keyValue = keyValue.substring(0, 16);
		}
		return keyValue;
	}

	public static String encrypt(String x, byte[] KeyValue) throws Exception,
			NoSuchPaddingException {
		Cipher cipher = Cipher.getInstance(cI);
		IvParameterSpec ivSpec = new IvParameterSpec(KeyValue);
		SecretKeySpec keySpec = new SecretKeySpec(KeyValue, alg);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		byte[] encrypted = cipher.doFinal(x.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encrypted);
		return encryptedValue;
	}

	public static String decrypt(String encryptedData, byte[] KeyValue)
			throws Exception {
		Cipher cipher = Cipher.getInstance(cI);
		IvParameterSpec ivSpec = new IvParameterSpec(KeyValue);
		SecretKeySpec keySpec = new SecretKeySpec(KeyValue, alg);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = cipher.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}	
/*
    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";


    public static String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64(encrypted));
    }


    public static String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
*/

}	

