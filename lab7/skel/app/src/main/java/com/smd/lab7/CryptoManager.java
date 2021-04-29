package com.smd.lab7;

import java.security.KeyPair;
import java.security.KeyStore;
import javax.crypto.Cipher;

public class CryptoManager {
    private static final String MY_KEY = "MY_KEY";
    private KeyStore keyStore;
    private Cipher cipher;

    public void init() throws Exception {

        // TODO Create or get KeyStore for holding the keys and generate keys

        // class used for encryption and decryption
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    }

    private KeyStore createAndroidKeyStore() {
        KeyStore keyStore = null;
        // TODO Create Keystore
        return keyStore;
    }

    private KeyPair createAsymmetricKey(String alias) {

        // TODO Create Asymmetric key pair
        // use KeyPairGenerator like in the lab example
        // parameters:
        // purposes: ENCRYPT, DECRYPT
        // RSA
        // key size 2048
        // encryption paddings: RSA_PCKS1 (use setEncryptionPaddings)

        return null;
    }

    public String encrypt(String pin) throws Exception {
        // TODO encrypt the given string
        // obtain public key from keystore
        // init Chipher
        // encode string

        return "";
    }

    public String decrypt(String encryptedPin) throws Exception {
        // TODO decrypt the given string
        // obtain private key from keystore
        // init Cipher
        // decode string
        return "";
    }
}
