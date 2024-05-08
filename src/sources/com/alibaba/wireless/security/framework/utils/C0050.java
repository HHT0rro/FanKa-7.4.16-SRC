package com.alibaba.wireless.security.framework.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* renamed from: com.alibaba.wireless.security.framework.utils.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0050 {
    /* renamed from: а, reason: contains not printable characters */
    public static String m1826(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (Exception unused2) {
            if (bufferedReader == null) {
                return null;
            }
            try {
                bufferedReader.close();
                return null;
            } catch (Exception unused3) {
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static boolean m1827(File file, String str) {
        BufferedWriter bufferedWriter;
        if (file == null || str == null) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        BufferedWriter bufferedWriter2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file2, false));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            return file2.renameTo(file);
        } catch (Exception unused2) {
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 == null) {
                return false;
            }
            try {
                bufferedWriter2.close();
                return false;
            } catch (Exception unused3) {
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static boolean m1828(String str) {
        return (str.contains("..") || str.contains("\\") || str.contains("%")) ? false : true;
    }
}
