package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cp {

    /* renamed from: a, reason: collision with root package name */
    private static volatile cp f10104a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10105b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10106c;

    private cp() {
    }

    public static cp a() {
        if (f10104a == null) {
            synchronized (cp.class) {
                if (f10104a == null) {
                    f10104a = new cp();
                }
            }
        }
        return f10104a;
    }

    public boolean b() {
        return this.f10106c;
    }

    public String c(String str) {
        return (this.f10105b && a(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public Boolean d(String str) {
        return Boolean.valueOf(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    public String e(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public boolean f(String str) {
        return TextUtils.isEmpty(str) || !str.contains("/thefatherofsalmon.com");
    }

    public String g(String str) {
        if (str == null) {
            return null;
        }
        return (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public String h(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (a(str).booleanValue() || b(str).booleanValue()) ? str.split("\\?") : null;
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public void i(String str) {
        new an(str).b();
    }

    public void b(boolean z10) {
        this.f10105b = z10;
    }

    public Boolean b(String str) {
        return a(str, "https:");
    }

    public void a(boolean z10) {
        this.f10106c = z10;
    }

    public Boolean a(String str) {
        return a(str, "http:");
    }

    private Boolean a(String str, String str2) {
        boolean z10 = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    public HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb2 = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb2.append(SymbolValues.QUESTION_EN_SYMBOL);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(entry.getValue());
                    sb2.append("&");
                } catch (Exception e2) {
                    bs.a().c(e2);
                }
            }
            return sb2.toString().substring(0, r3.length() - 1);
        }
        return sb2.toString();
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }
}
