package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.huawei.openalliance.ad.constant.as;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class APSecuritySdk {

    /* renamed from: a, reason: collision with root package name */
    private static APSecuritySdk f4328a;

    /* renamed from: c, reason: collision with root package name */
    private static Object f4329c = new Object();

    /* renamed from: b, reason: collision with root package name */
    private Context f4330b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    private APSecuritySdk(Context context) {
        this.f4330b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f4328a == null) {
            synchronized (f4329c) {
                if (f4328a == null) {
                    f4328a = new APSecuritySdk(context);
                }
            }
        }
        return f4328a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a10 = a.a(this.f4330b, "");
        if (z.a.d(a10)) {
            initToken(0, new HashMap(), null);
        }
        return a10;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAY";
    }

    public String getSdkVersion() {
        return "3.2.2-20180331";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f4330b, "");
            tokenResult.clientKey = h.f(this.f4330b);
            tokenResult.apdid = a.a(this.f4330b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f4330b);
            if (z.a.d(tokenResult.apdid) || z.a.d(tokenResult.apdidToken) || z.a.d(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i10, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i10);
        String b4 = h.b(this.f4330b);
        String c4 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (z.a.g(b4) && !z.a.e(b4, c4)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f4330b);
            d.a(this.f4330b);
            g.a(this.f4330b);
            i.h();
        }
        if (!z.a.e(b4, c4)) {
            h.c(this.f4330b, c4);
        }
        String c10 = z.a.c(map, b.f4545g, "");
        String c11 = z.a.c(map, "tid", "");
        String c12 = z.a.c(map, as.f32242q, "");
        if (z.a.d(c10)) {
            c10 = UtdidWrapper.getUtdid(this.f4330b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.f4545g, c10);
        hashMap.put("tid", c11);
        hashMap.put(as.f32242q, c12);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f4330b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
