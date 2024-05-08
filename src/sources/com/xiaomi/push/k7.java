package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k7 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47927b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f47928c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f47929d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j7 f47930e;

    public k7(j7 j7Var, String str, String str2, String str3) {
        this.f47930e = j7Var;
        this.f47927b = str;
        this.f47928c = str2;
        this.f47929d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f47930e.f47846a;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.f47927b, 4).edit();
        edit.putString(this.f47928c, this.f47929d);
        edit.commit();
    }
}
