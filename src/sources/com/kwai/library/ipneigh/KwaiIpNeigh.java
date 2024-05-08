package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
    }

    private static boolean aB(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i10);

    private static native int getARPTableFromJni2(int i10);

    public static String i(String str, boolean z10) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int detachFd;
        String readLine;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            detachFd = parcelFileDescriptor2.detachFd();
        } catch (Throwable th) {
            th.printStackTrace();
            new StringBuilder("getARPResult exception:").append(th.getMessage());
        }
        if ((z10 ? getARPTableFromJni2(detachFd) : getARPTableFromJni(detachFd)) != 0) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!aB(readLine, str));
        return readLine;
    }
}
