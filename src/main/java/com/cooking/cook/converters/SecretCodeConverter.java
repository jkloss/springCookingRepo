package com.cooking.cook.converters;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.security.Key;

@Converter
public class SecretCodeConverter implements AttributeConverter<String, String> {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY = "MySecretKey".getBytes();

    @Override
    public String convertToDatabaseColumn(String s) {
        Key key = new SecretKeySpec(KEY, "AES");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64Utils.encodeToString(cipher.doFinal(s.getBytes()));
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }

    @Override
    public String convertToEntityAttribute(String s) {
        Key key = new SecretKeySpec(KEY, "AES");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64Utils.decode(s.getBytes())));
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}
