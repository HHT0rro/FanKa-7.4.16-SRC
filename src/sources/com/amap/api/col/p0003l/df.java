package com.amap.api.col.p0003l;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* compiled from: BaseTileRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class df extends db {
    public df() {
        setProxy(ft.a(ab.f4885a));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    private static String a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(b(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            gy.b(e2, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e10) {
            gy.b(e10, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public String appendTsScode(String str) {
        String a10 = a(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a11 = fl.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a11)));
        stringBuffer.append("&scode=" + fl.a(ab.f4885a, a11, a10));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.id
    public String getIPV6URL() {
        String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : dx.a(url);
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.f6964c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.8.3", "3dmap"));
        hashtable.put("x-INFO", fl.a(ab.f4885a));
        hashtable.put("key", fj.f(ab.f4885a));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.id
    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
