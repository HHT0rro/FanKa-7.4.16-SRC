package com.ss.android.socialbase.appdownloader.n;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    public static String m(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(DownloadUtils.hexToString(str), 0);
        int length = str2.length();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (byte b4 : decode) {
            if (i10 >= length) {
                i10 %= length;
            }
            sb2.append((char) (b4 ^ str2.charAt(i10)));
            i10++;
        }
        return sb2.toString();
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(DownloadUtils.hexToString(str), 0));
    }
}
