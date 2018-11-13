/*
 * Copyright 2018 Shastore Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.example.yosef.shastore.model.connectors;

import android.util.Log;
import android.widget.Toast;

import com.example.yosef.shastore.model.components.EncryptedFile;
import com.example.yosef.shastore.model.components.RegularFile;
import com.example.yosef.shastore.model.components.SecureFile;

import java.io.FileInputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;

public class GenericFileCryptoMachine extends FileCryptoMachine {
    private static final String TAG = "In FileCrypto";

    @Override
    public EncryptedFile encryptFile(RegularFile regularFile, SecretKey fileKey) {
        Cipher cipher;
        try{
            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, fileKey);
            byte[] encrypt = cipher.doFinal(regularFile.getContent());
        } catch (Exception e){
            Log.e(TAG, "cipher error: " + e.toString());
            return null;
        }

        return null;
    }

    @Override
    public SecureFile secureFile(EncryptedFile encryptedFile, SecretKey deviceKey) {
        return null;
    }

    @Override
    public EncryptedFile unsecureFile(SecureFile secureFile, SecretKey deviceKey) {
        return null;
    }

    @Override
    public RegularFile decryptFile(EncryptedFile encryptedFile, SecretKey fileKey) {
        return null;
    }
}