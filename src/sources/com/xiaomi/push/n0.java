package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n0 {
    public static String a(String str) {
        try {
            return String.valueOf(m0.e(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | Exception e2) {
            fc.c.j("CloudCoder.hash4SHA1 ", e2);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String b(String str, String str2, Map<String, String> map, String str3) {
        if (TextUtils.isEmpty(str3)) {
            throw new InvalidParameterException("security is not nullable");
        }
        ArrayList<String> arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str.toUpperCase());
        }
        if (str2 != null) {
            arrayList.add(Uri.parse(str2).getEncodedPath());
        }
        boolean z10 = true;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : new TreeMap(map).entrySet()) {
                arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
        }
        arrayList.add(str3);
        StringBuilder sb2 = new StringBuilder();
        for (String str4 : arrayList) {
            if (!z10) {
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
            }
            sb2.append(str4);
            z10 = false;
        }
        return a(sb2.toString());
    }
}
