package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DevTools {

    /* renamed from: a, reason: collision with root package name */
    private String f38275a;

    public String getDemoGameUrl() {
        String str = this.f38275a;
        this.f38275a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f38275a = str;
        }
    }
}
