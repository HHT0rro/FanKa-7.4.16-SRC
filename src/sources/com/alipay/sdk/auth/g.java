package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4485a = "com.eg.android.AlipayGphone";

    /* renamed from: b, reason: collision with root package name */
    private static final int f4486b = 65;

    /* renamed from: c, reason: collision with root package name */
    private static com.alipay.sdk.widget.a f4487c;

    /* renamed from: d, reason: collision with root package name */
    private static String f4488d;

    private static void c(Activity activity, APAuthInfo aPAuthInfo) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f4775a);
                    f4487c = aVar;
                    aVar.b();
                }
            } catch (Exception unused) {
                f4487c = null;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("app_id=");
        sb2.append(aPAuthInfo.getAppId());
        sb2.append("&partner=");
        sb2.append(aPAuthInfo.getPid());
        sb2.append("&scope=kuaijie");
        sb2.append("&login_goal=auth");
        sb2.append("&redirect_url=");
        sb2.append(aPAuthInfo.getRedirectUri());
        sb2.append("&view=wap");
        sb2.append("&prod_code=");
        sb2.append(aPAuthInfo.getProductId());
        new Thread(new h(activity, sb2, aPAuthInfo)).start();
    }

    private static void b(Activity activity, APAuthInfo aPAuthInfo) {
        a(activity, "alipayauth://platformapi/startapp?appId=20000122&approveType=005&scope=kuaijie&productId=" + aPAuthInfo.getProductId() + "&thirdpartyId=" + aPAuthInfo.getAppId() + "&redirectUri=" + aPAuthInfo.getRedirectUri());
    }

    private static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 65;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Activity activity, APAuthInfo aPAuthInfo) {
        com.alipay.sdk.sys.b.a().a(activity, com.alipay.sdk.data.c.b());
        if (a(activity)) {
            b(activity, aPAuthInfo);
        } else {
            c(activity, aPAuthInfo);
        }
    }

    public static void a(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
