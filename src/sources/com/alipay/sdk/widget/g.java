package com.alipay.sdk.widget;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.FrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class g extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public Activity f4792a;

    public g(Activity activity) {
        super(activity);
        this.f4792a = activity;
    }

    public abstract void a();

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f4792a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();
}
