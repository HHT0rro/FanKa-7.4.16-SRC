package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BasicLBSRestHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class f<T, V> extends e<T, V> {
    public f(Context context, T t2) {
        super(context, t2);
    }

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            n.a(e2, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e10) {
            n.a(e10, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String c(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(e(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String e(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            n.a(e2, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e10) {
            n.a(e10, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.s.e
    public abstract V a(String str) throws AMapException;

    @Override // com.amap.api.col.s.e
    public abstract String a_();

    @Override // com.amap.api.col.s.e, com.amap.api.col.s.dz
    public Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.e, com.amap.api.col.s.dz
    public Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 9.7.0");
        hashMap.put("X-INFO", bz.a(((e) this).f7863e));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.7.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public byte[] h() {
        try {
            String a_ = a_();
            StringBuffer stringBuffer = new StringBuffer();
            if (a_ != null) {
                stringBuffer.append(a_);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c4 = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a10 = bz.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a10)));
            stringBuffer3.append("&scode=" + bz.a(((e) this).f7863e, a10, c4));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            n.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
