package com.amap.api.col.s;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: AutoTSignatureUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d {
    private static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20").replace(StringUtils.NO_PRINT_CODE, "%2A").replace("%7E", "~");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static byte[] a(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "UTF-8"));
        return mac.doFinal(str2.getBytes("UTF-8"));
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static String a(String str, String str2, String str3) throws Exception {
        return a(a(str3 + "&", str.toUpperCase() + "&%2F&" + a(str2))).replace("=", "%3D");
    }

    public static String a(Map<String, String> map, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("AccessKeyId", str);
        treeMap.put("SignatureMethod", "HMAC-SHA1");
        treeMap.put("SignatureVersion", "1.0");
        treeMap.put("SignatureNonce", UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        treeMap.put("Timestamp", simpleDateFormat.format(date));
        treeMap.putAll(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + a((String) entry.getValue()));
        }
        StringBuilder sb2 = new StringBuilder("");
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            sb2.append((String) iterator2.next());
            sb2.append("&");
        }
        return sb2.toString().substring(0, r3.length() - 1);
    }
}
