package com.inno.innosdk.pb;

import android.os.Build;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.inno.innosdk.a.c;
import com.inno.innosdk.b.a;
import com.inno.innosdk.utils.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Js2native {
    @JavascriptInterface
    public String getOs() {
        return "android$" + Build.VERSION.RELEASE;
    }

    @JavascriptInterface
    public String getjsdata(String str) {
        try {
            return a.a(str);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "";
        }
    }

    @JavascriptInterface
    public String loadInfo() {
        return InnoMain.loadInfo(c.k());
    }

    @JavascriptInterface
    public void recaptchaOnceResult(String str) {
        try {
            if (com.inno.innosdk.utils.a.f35558b.get() == null) {
                return;
            }
            new Handler(com.inno.innosdk.utils.a.f35558b.get().getMainLooper()).post(new Runnable() { // from class: com.inno.innosdk.pb.Js2native.2
                @Override // java.lang.Runnable
                public void run() {
                    b.a().e();
                }
            });
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @JavascriptInterface
    public void recaptchaResult(String str) {
        try {
            if (com.inno.innosdk.utils.a.f35558b.get() == null) {
                return;
            }
            new Handler(com.inno.innosdk.utils.a.f35558b.get().getMainLooper()).post(new Runnable() { // from class: com.inno.innosdk.pb.Js2native.1
                @Override // java.lang.Runnable
                public void run() {
                    b.a().d();
                }
            });
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @JavascriptInterface
    public String setjsdata(String str, String str2) {
        try {
            a.a(str, str2);
            return "1";
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "0";
        }
    }
}
