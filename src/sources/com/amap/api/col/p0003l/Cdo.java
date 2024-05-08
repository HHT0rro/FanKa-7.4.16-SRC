package com.amap.api.col.p0003l;

import android.graphics.Bitmap;

/* compiled from: PureScreenCheckTool.java */
/* renamed from: com.amap.api.col.3l.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Cdo {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5362a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5363b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5364c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5365d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f5366e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f5367f = 20;

    public static void a(boolean z10) {
        f5362a = z10;
    }

    public static void b(boolean z10) {
        f5363b = z10;
    }

    public static void c(boolean z10) {
        f5364c = z10;
    }

    public static void g() {
        gy.b(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean d() {
        return this.f5365d;
    }

    public final void e() {
        this.f5366e++;
    }

    public final boolean f() {
        return this.f5366e >= this.f5367f;
    }

    public static boolean a() {
        return f5362a;
    }

    public static boolean b() {
        return f5363b;
    }

    public static boolean c() {
        return f5364c;
    }

    public final boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i10 = -1;
                for (int i11 = (int) (width / 4.0f); i11 < (width * 3) / 4.0f; i11++) {
                    for (int i12 = (int) (height / 4.0f); i12 < (height * 3) / 4.0f; i12++) {
                        int pixel = bitmap.getPixel(i11, i12);
                        if (i10 == -1) {
                            i10 = pixel;
                        }
                        if (pixel != i10) {
                            return false;
                        }
                        if (pixel != -16777216) {
                            return false;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return true;
    }
}
