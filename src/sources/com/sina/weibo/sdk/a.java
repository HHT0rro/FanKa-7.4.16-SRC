package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import bc.d;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.openapi.SdkConfig;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.weibo.ssosdk.WeiboSsoSdk;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f38329a;

    /* renamed from: b, reason: collision with root package name */
    private static AuthInfo f38330b;
    private static String mAid;

    public static AuthInfo b() {
        a();
        return f38330b;
    }

    public static /* synthetic */ boolean c() {
        f38329a = true;
        return true;
    }

    public static String getAid() {
        a();
        return mAid;
    }

    public static void a(Context context, AuthInfo authInfo, final SdkListener sdkListener, SdkConfig sdkConfig) {
        boolean z10;
        if (f38329a) {
            return;
        }
        if (authInfo != null) {
            f38330b = authInfo;
            boolean z11 = false;
            if (sdkConfig != null) {
                z11 = sdkConfig.isUserAgree();
                z10 = sdkConfig.isUserAgreeWifiInfo();
            } else {
                z10 = false;
            }
            String appKey = authInfo.getAppKey();
            d dVar = new d();
            dVar.n(context.getApplicationContext());
            dVar.m(appKey);
            dVar.o("1478195010");
            dVar.r("1000_0001");
            dVar.q(z11);
            dVar.p(z10);
            WeiboSsoSdk.j(dVar);
            try {
                WeiboSsoSdk.i().m(new com.weibo.ssosdk.a() { // from class: com.sina.weibo.sdk.a.1
                    @Override // com.weibo.ssosdk.a
                    public final void handler(WeiboSsoSdk.d dVar2) {
                        if (dVar2 != null) {
                            try {
                                String unused = a.mAid = dVar2.a();
                                a.c();
                                SdkListener sdkListener2 = SdkListener.this;
                                if (sdkListener2 != null) {
                                    sdkListener2.onInitSuccess();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                SdkListener sdkListener3 = SdkListener.this;
                                if (sdkListener3 != null) {
                                    sdkListener3.onInitFailure(e2);
                                }
                            }
                        }
                    }
                });
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (sdkListener != null) {
                    sdkListener.onInitFailure(e2);
                    return;
                }
                return;
            }
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public static boolean b(Context context) {
        a.C0571a e2;
        return a(context) && (e2 = com.sina.weibo.sdk.b.a.e(context)) != null && e2.af >= 10772;
    }

    private static void a() {
        if (!f38329a) {
            throw new RuntimeException("please init sdk before use it. Wb.install()");
        }
    }

    public static boolean a(Context context) {
        List<ResolveInfo> queryIntentServices;
        String[] strArr = {"com.sina.weibo", "com.sina.weibog3"};
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
