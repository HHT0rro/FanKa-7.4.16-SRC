package com.huawei.hms.scankit.p;

import android.graphics.Point;

/* compiled from: CameraConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private int f30905a;

    /* renamed from: b, reason: collision with root package name */
    private int f30906b;

    /* renamed from: c, reason: collision with root package name */
    private String f30907c;

    /* renamed from: d, reason: collision with root package name */
    private Point f30908d;

    /* renamed from: e, reason: collision with root package name */
    private int f30909e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f30910f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f30911g;

    /* compiled from: CameraConfig.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: e, reason: collision with root package name */
        private Point f30916e;

        /* renamed from: a, reason: collision with root package name */
        private int f30912a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f30913b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f30914c = 0;

        /* renamed from: d, reason: collision with root package name */
        private String f30915d = "off";

        /* renamed from: f, reason: collision with root package name */
        private boolean f30917f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f30918g = false;

        public b a(int i10) {
            this.f30913b = i10;
            return this;
        }

        public b b(int i10) {
            this.f30914c = i10;
            return this;
        }

        public b a(Point point) {
            this.f30916e = point;
            return this;
        }

        public b b(boolean z10) {
            this.f30917f = z10;
            return this;
        }

        public b a(boolean z10) {
            this.f30918g = z10;
            return this;
        }

        public e0 a() {
            return new e0(this.f30912a, this.f30913b, this.f30914c, this.f30915d, this.f30916e, this.f30917f).a(this.f30918g);
        }
    }

    public int b() {
        return this.f30905a;
    }

    public int c() {
        return this.f30906b;
    }

    public int d() {
        return this.f30909e;
    }

    public boolean e() {
        return this.f30910f;
    }

    public String f() {
        return this.f30907c;
    }

    private e0(int i10, int i11, int i12, String str, Point point, boolean z10) {
        this.f30905a = i10;
        this.f30906b = i11;
        this.f30909e = i12;
        this.f30907c = str;
        this.f30908d = point;
        this.f30910f = z10;
    }

    public void a(int i10) {
        this.f30909e = i10;
    }

    public Point a() {
        return this.f30908d;
    }

    public void a(Point point) {
        this.f30908d = point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e0 a(boolean z10) {
        this.f30911g = z10;
        return this;
    }
}
