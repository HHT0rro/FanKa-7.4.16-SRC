package com.jd.ad.sdk.jad_il;

import android.content.Context;
import android.os.Process;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    public static long jad_an;

    public static Boolean jad_an() {
        BufferedReader bufferedReader;
        String readLine;
        HashSet hashSet = new HashSet();
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("/proc/");
        jad_an2.append(Process.myPid());
        jad_an2.append("/maps");
        try {
            bufferedReader = new BufferedReader(new FileReader(jad_an2.toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                Iterator iterator2 = hashSet.iterator2();
                while (iterator2.hasNext()) {
                    String str = (String) iterator2.next();
                    if (!str.contains("com.saurik.substrate") && !str.contains("XposedBridge.jar")) {
                    }
                    return Boolean.TRUE;
                }
                bufferedReader.close();
                return Boolean.FALSE;
            }
            if (readLine.endsWith(".jar") || readLine.endsWith(".so")) {
                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
            }
        } while (!readLine.toLowerCase().contains("frida"));
        return Boolean.TRUE;
    }

    public static Boolean jad_an(Context context) {
        try {
            throw new Exception("Deteck hook");
        } catch (Exception e2) {
            int i10 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoke".equals(stackTraceElement.getMethodName())) || ((an.f35798b.equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) || (an.f35798b.equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())))) {
                    return Boolean.TRUE;
                }
                if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName()) && (i10 = i10 + 1) == 2) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }
}
