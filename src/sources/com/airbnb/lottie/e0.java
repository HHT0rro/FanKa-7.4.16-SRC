package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieImageAsset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f1898a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1899b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1900c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1901d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1902e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Bitmap f1903f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e0(int i10, int i11, String str, String str2, String str3) {
        this.f1898a = i10;
        this.f1899b = i11;
        this.f1900c = str;
        this.f1901d = str2;
        this.f1902e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f1903f;
    }

    public String b() {
        return this.f1901d;
    }

    public int c() {
        return this.f1899b;
    }

    public String d() {
        return this.f1900c;
    }

    public int e() {
        return this.f1898a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.f1903f = bitmap;
    }
}
