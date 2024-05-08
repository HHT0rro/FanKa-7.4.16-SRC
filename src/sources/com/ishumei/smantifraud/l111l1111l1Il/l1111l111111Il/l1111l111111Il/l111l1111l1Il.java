package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import android.text.TextUtils;
import com.ishumei.smantifraud.l1111l111111Il.l11l111l11Il;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111l1Il extends l1111l111111Il {
    private static final int l1111l111111Il = 4096;
    private l111l11111I1l l111l11111lIl = new l111l11111I1l(4096);

    private static String l1111l111111Il(int i10) {
        if (i10 == 0) {
            return "GET";
        }
        if (i10 == 1) {
            return "POST";
        }
        throw new IllegalStateException("Unknown method type.");
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l1111l111111Il
    public final l11l111l11Il l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l, Map<String, String> map) {
        AutoCloseable autoCloseable;
        HttpURLConnection httpURLConnection;
        String str;
        byte[] l1111l111111Il2 = l111l1111li1l.l1111l111111Il();
        if ((l111l1111li1l.l111l11111I1l() == 1 && l1111l111111Il2 == null) || com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l1111l1Il) {
            throw new IllegalArgumentException("body is null");
        }
        String l111l1111lI1l = l111l1111li1l.l111l1111lI1l();
        if (l111l1111li1l.l111l1111llIl() && !TextUtils.isEmpty(l111l1111li1l.l111l1111lIl())) {
            l111l1111lI1l = l111l1111li1l.l111l1111lIl();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(l111l1111li1l.l111l11111lIl());
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(l111l1111lI1l).openConnection();
        } catch (Throwable th) {
            th = th;
            autoCloseable = null;
        }
        try {
            for (String str2 : hashMap.h()) {
                httpURLConnection.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            int l11l1111Il1l = l111l1111li1l.l11l1111Il1l();
            httpURLConnection.setConnectTimeout(l11l1111Il1l);
            httpURLConnection.setReadTimeout(l11l1111Il1l);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            int l111l11111I1l = l111l1111li1l.l111l11111I1l();
            if (l111l11111I1l == 0) {
                str = "GET";
            } else {
                if (l111l11111I1l != 1) {
                    throw new IllegalStateException("Unknown method type.");
                }
                str = "POST";
            }
            httpURLConnection.setRequestMethod(str);
            if (l1111l111111Il2 != null) {
                httpURLConnection.setFixedLengthStreamingMode(l1111l111111Il2.length);
            }
            httpURLConnection.connect();
            if (l1111l111111Il2 != null) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(l1111l111111Il2);
                outputStream.flush();
            }
            l11l111l11Il l11l111l11il = new l11l111l11Il(httpURLConnection.getResponseCode(), l111l1111lI1l.l1111l111111Il(httpURLConnection.getInputStream(), httpURLConnection.getContentLength(), this.l111l11111lIl));
            try {
                httpURLConnection.disconnect();
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception unused) {
            }
            return l11l111l11il;
        } catch (Throwable th2) {
            th = th2;
            autoCloseable = null;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Exception unused2) {
                    throw th;
                }
            }
            if (autoCloseable != null) {
                autoCloseable.close();
            }
            throw th;
        }
    }
}
