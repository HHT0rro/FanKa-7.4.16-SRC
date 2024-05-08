package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: MediaCodecParameterStorage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ak {

    /* renamed from: d, reason: collision with root package name */
    private static final String f2634d = "libstreaming-encode-";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2635e = "encodeName";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2636f = "colorFormat";

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2637a;

    /* renamed from: b, reason: collision with root package name */
    public String f2638b;

    /* renamed from: c, reason: collision with root package name */
    public int f2639c;

    /* renamed from: g, reason: collision with root package name */
    private final Context f2640g;

    public ak(Context context) {
        this.f2640g = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f2637a = defaultSharedPreferences;
        this.f2638b = defaultSharedPreferences.getString("libstreaming-encode-encodeName", "");
        this.f2639c = defaultSharedPreferences.getInt("libstreaming-encode-colorFormat", -1);
    }

    private String a() {
        return this.f2638b;
    }

    private int b() {
        return this.f2639c;
    }

    private void a(String str) {
        this.f2638b = str;
    }

    private void b(String str) {
        this.f2638b = str;
        SharedPreferences.Editor edit = this.f2637a.edit();
        edit.putString("libstreaming-encode-encodeName", str);
        edit.apply();
    }

    private void a(int i10) {
        this.f2639c = i10;
    }

    private void b(int i10) {
        this.f2639c = i10;
        SharedPreferences.Editor edit = this.f2637a.edit();
        edit.putInt("libstreaming-encode-colorFormat", i10);
        edit.apply();
    }
}
