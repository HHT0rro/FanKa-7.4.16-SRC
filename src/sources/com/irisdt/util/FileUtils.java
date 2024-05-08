package com.irisdt.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FileUtils {
    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String md5(String str) {
        try {
            return printHexBinary(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String printHexBinary(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            char[] cArr = hexCode;
            sb2.append(cArr[(b4 >> 4) & 15]);
            sb2.append(cArr[b4 & 15]);
        }
        return sb2.toString();
    }

    public static String readFile(File file) {
        try {
            char[] cArr = new char[(int) file.length()];
            FileReader fileReader = new FileReader(file);
            fileReader.read(cArr);
            fileReader.close();
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void writeFile(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception unused) {
        }
    }
}
