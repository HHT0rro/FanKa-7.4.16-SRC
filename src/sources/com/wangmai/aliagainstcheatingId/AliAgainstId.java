package com.wangmai.aliagainstcheatingId;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AliAgainstId {
    static {
        System.loadLibrary("wmAliAgainstId");
    }

    public static String getBoot() {
        BufferedReader bufferedReader;
        String str = "";
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/sys/kernel/random/boot_id")));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.toString();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    th3.toString();
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th5.toString();
        }
        return str;
    }

    public static native String getUpdate();
}
