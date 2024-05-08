package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.huawei.openalliance.ad.constant.as;
import java.util.HashMap;
import z.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TMNTokenClient {

    /* renamed from: a, reason: collision with root package name */
    private static TMNTokenClient f4335a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4336b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface InitResultListener {
        void onResult(String str, int i10);
    }

    private TMNTokenClient(Context context) {
        this.f4336b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.f4336b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f4335a == null) {
            synchronized (TMNTokenClient.class) {
                if (f4335a == null) {
                    f4335a = new TMNTokenClient(context);
                }
            }
        }
        return f4335a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.d(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.d(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.f4545g, UtdidWrapper.getUtdid(this.f4336b));
        hashMap.put("tid", "");
        hashMap.put(as.f32242q, "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int a10 = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.f4336b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (a10 != 0) {
                    initResultListener2.onResult("", a10);
                } else {
                    initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.f4336b, str), 0);
                }
            }
        });
    }
}
