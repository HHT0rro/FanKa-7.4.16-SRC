package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WifiResultParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k8 extends t6 {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31215b = Pattern.compile("WIFI:[^:]", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f31216c = new String[0];

    public static String[] a(String str, String str2, char c4, boolean z10) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < length) {
            int indexOf = str2.indexOf(str, i10);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z11 = true;
            int i11 = length2;
            while (z11) {
                int indexOf2 = str2.indexOf(c4, i11);
                if (indexOf2 < 0) {
                    i11 = str2.length();
                } else if (a(str2, indexOf2) % 2 != 0) {
                    i11 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String b4 = t6.b(str2.substring(length2, indexOf2));
                    if (z10) {
                        b4 = b4.trim();
                    }
                    arrayList2.add(b4);
                    i11 = indexOf2 + 1;
                }
                z11 = false;
            }
            i10 = i11;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(f31216c);
    }

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        return str.equalsIgnoreCase("SAE") ? 3 : 0;
    }

    @Override // com.huawei.hms.scankit.p.t6
    public HmsScan b(s6 s6Var) {
        String str;
        String a10 = t6.a(s6Var);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        Matcher matcher = f31215b.matcher(a10);
        if (matcher.find() && matcher.start() == 0) {
            String substring = a10.substring(5);
            if (!substring.endsWith(";")) {
                substring = substring + ";";
            }
            String b4 = b("S:", substring, ';', false);
            if (b4 != null && !b4.isEmpty()) {
                String b10 = b("P:", substring, ';', false);
                String b11 = b("T:", substring, ';', false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b4);
                if (b10 == null || b10.isEmpty()) {
                    str = "";
                } else {
                    str = " " + b10;
                }
                sb2.append(str);
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), sb2.toString(), HmsScan.WIFI_CONNECT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), null, new z6(new HmsScan.WiFiConnectionInfo(b4, b10, c(b11))));
            }
        }
        return null;
    }

    private static int a(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (int i12 = i10 - 1; i12 >= 0 && charSequence.charAt(i12) == '\\'; i12--) {
            i11++;
        }
        return i11;
    }

    private String b(String str, String str2, char c4, boolean z10) {
        String[] a10 = a(str, str2, c4, z10);
        return (a10 == null || a10.length == 0 || a10[0] == null) ? "" : a10[0];
    }
}
