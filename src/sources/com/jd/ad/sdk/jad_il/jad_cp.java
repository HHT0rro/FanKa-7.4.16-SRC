package com.jd.ad.sdk.jad_il;

import android.content.Context;
import android.net.LocalServerSocket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp {
    public static long jad_an;
    public static LocalServerSocket jad_bo;
    public static String[] jad_cp = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "com.dual.dualgenius", "com.jiubang.commerce.gomultiple"};

    public static boolean jad_an() {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/self/maps"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            bufferedReader2.close();
                            break;
                        }
                        for (String str : jad_cp) {
                            if (readLine.contains(str)) {
                                try {
                                    bufferedReader2.close();
                                    return true;
                                } catch (IOException unused) {
                                    return true;
                                }
                            }
                        }
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused5) {
        }
        return false;
    }

    public static boolean jad_an(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName + "/files";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/data/user/0/");
        sb2.append(packageName);
        sb2.append("/files");
        return (str.equals(absolutePath) || sb2.toString().equals(absolutePath)) ? false : true;
    }
}
