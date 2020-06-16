package com.spring.springbootintegrated1.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * RSA Util
 * </p>
 *
 * @author yanglin
 * @date 2020-06-16 19:31:03
 */
public class RSAUtil {

    public static final String RSA_ALGORITHM = "RSA";

    /**
     * <p>
     * Create Keys
     * </p>
     *
     * @param keySize Key Size
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author yanglin
     * @date 2020-06-16 19:31:32
     */
    public static Map<String, String> createKeys(int keySize) {
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_ALGORITHM + "]");
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<String, String>();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);

        return keyPairMap;
    }

    /**
     * <p>
     * Acquire Public Key
     * </p>
     *
     * @param publicKey publicKey
     * @return java.security.interfaces.RSAPublicKey
     * @author yanglin
     * @date 2020-06-16 19:40:11
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * <p>
     * Acquire Private Key
     * </p>
     *
     * @param privateKey privateKey
     * @return java.security.interfaces.RSAPrivateKey
     * @author yanglin
     * @date 2020-06-16 19:38:53
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * <p>
     * Public Key Encrypt
     * </p>
     *
     * @param data      data
     * @param publicKey publicKey
     * @return java.lang.String
     * @author yanglin
     * @date 2020-06-16 19:38:04
     */
    public static String publicEncrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(
                    cipher,
                    Cipher.ENCRYPT_MODE,
                    data.getBytes(StandardCharsets.UTF_8.name()),
                    publicKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <p>
     * Private Key Decrypt
     * </p>
     *
     * @param data       data
     * @param privateKey privateKey
     * @return java.lang.String
     * @author yanglin
     * @date 2020-06-16 19:37:15
     */
    public static String privateDecrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(rsaSplitCodec(
                    cipher,
                    Cipher.DECRYPT_MODE,
                    Base64.decodeBase64(data),
                    privateKey.getModulus().bitLength()), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <p>
     * Private Key Encrypt
     * </p>
     *
     * @param data       data
     * @param privateKey privateKey
     * @return java.lang.String
     * @author yanglin
     * @date 2020-06-16 19:36:16
     */
    public static String privateEncrypt(String data, RSAPrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return Base64.encodeBase64URLSafeString(rsaSplitCodec(
                    cipher,
                    Cipher.ENCRYPT_MODE,
                    data.getBytes(StandardCharsets.UTF_8.name()),
                    privateKey.getModulus().bitLength()));
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <p>
     * Public Key Decrypt
     * </p>
     *
     * @param data      data
     * @param publicKey publicKey
     * @return java.lang.String
     * @author yanglin
     * @date 2020-06-16 19:35:35
     */
    public static String publicDecrypt(String data, RSAPublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data), publicKey.getModulus().bitLength()), StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <p>
     * RSA Split Codec
     * </p>
     *
     * @param cipher  cipher
     * @param opmode  opmode
     * @param datas   datas
     * @param keySize byte[]
     * @return byte[]
     * @author yanglin
     * @date 2020-06-16 19:33:57
     */
    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        IOUtils.closeQuietly(out);
        return resultDatas;
    }

    /**
     * <p>
     * main
     * </p>
     *
     * @param args args
     * @author yanglin
     * @date 2020-06-16 19:33:21
     */
    public static void main(String[] args) throws Exception {
        Map<String, String> keyMap = RSAUtil.createKeys(1024);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("公钥： \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);

        System.out.println("公钥加密——私钥解密");
        String str = "code_cayden";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RSAUtil.publicEncrypt(str, RSAUtil.getPublicKey(publicKey));
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RSAUtil.privateDecrypt(encodedData, RSAUtil.getPrivateKey(privateKey));
        System.out.println("解密后文字: \r\n" + decodedData);
    }

}
