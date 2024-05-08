package f1;

import android.content.Context;
import android.webkit.WebSettings;

/* compiled from: UserAgentUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f49112a;

    public static String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt >= 127) {
                sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static String b() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        String b4;
        String str = f49112a;
        if (str != null && !str.isEmpty()) {
            return f49112a;
        }
        try {
            b4 = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            b4 = b();
        }
        if (b4 == null || b4.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = b4.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = b4.charAt(i10);
            if (charAt <= 31 || charAt >= 127) {
                sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb2.append(charAt);
            }
        }
        String sb3 = sb2.toString();
        f49112a = sb3;
        return sb3;
    }
}
