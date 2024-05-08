package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* compiled from: CameraMeteringData.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private int f31194a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f31195b;

    /* compiled from: CameraMeteringData.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Rect f31196a;

        /* renamed from: b, reason: collision with root package name */
        public int f31197b;

        public a(Rect rect, int i10) {
            this.f31196a = rect;
            this.f31197b = i10;
        }
    }

    public k0(int i10, Rect rect) {
        this.f31194a = i10;
        this.f31195b = new Rect(rect);
    }

    public int a() {
        return this.f31194a;
    }

    public Rect b() {
        return this.f31195b;
    }
}
