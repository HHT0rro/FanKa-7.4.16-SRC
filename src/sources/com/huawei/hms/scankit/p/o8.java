package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* compiled from: Zoom.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o8 {
    public static float a(int i10, int i11, u6[] u6VarArr) {
        float abs;
        float abs2;
        float f10 = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        int i12 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var.d()) {
                i12++;
            }
        }
        if (r3.f31446a && !r3.f31447b && i12 < 2) {
            return 1.0f;
        }
        float b4 = u6VarArr[0].b();
        float b10 = u6VarArr[1].b();
        float b11 = u6VarArr[2].b();
        float c4 = u6VarArr[0].c();
        float c10 = u6VarArr[1].c();
        float c11 = u6VarArr[2].c();
        u6 a10 = a(b4, c4, b10, c10, b11, c11);
        float b12 = a10.b();
        float c12 = a10.c();
        float max = Math.max(Math.max(Math.max(b4, b10), b11), b12);
        float min = Math.min(Math.min(Math.min(b4, b10), b11), b12);
        float max2 = Math.max(Math.max(Math.max(c4, c10), c11), c12);
        float min2 = Math.min(Math.min(Math.min(c4, c10), c11), c12);
        int min3 = (int) (Math.min(i11, i10) * 0.85f);
        int i13 = (i10 - min3) / 2;
        int i14 = (i11 - min3) / 2;
        Rect rect = new Rect(i13, i14, min3 + i13, min3 + i14);
        if (min < rect.left && min2 < rect.top && max > rect.right && max2 > rect.bottom) {
            return 1.0f;
        }
        float abs3 = Math.abs(min2 - rect.top);
        float abs4 = Math.abs(min - rect.left);
        float abs5 = Math.abs(max - rect.right);
        float abs6 = Math.abs(max2 - rect.bottom);
        float f11 = (rect.left + rect.right) / 2.0f;
        float f12 = (rect.top + rect.bottom) / 2.0f;
        float min4 = Math.min(Math.min(Math.min(abs4, abs5), abs3), abs6);
        if (0.01f > Math.abs(abs4 - min4)) {
            abs = Math.abs(f11 - rect.left) * 1.0f;
            abs2 = Math.abs(f11 - min);
        } else if (0.01f > Math.abs(abs5 - min4)) {
            abs = Math.abs(f11 - rect.right) * 1.0f;
            abs2 = Math.abs(f11 - max);
        } else if (0.01f > Math.abs(abs3 - min4)) {
            abs = Math.abs(f12 - rect.top) * 1.0f;
            abs2 = Math.abs(f12 - min2);
        } else {
            if (0.01f > Math.abs(abs6 - min4)) {
                abs = Math.abs(f12 - rect.bottom) * 1.0f;
                abs2 = Math.abs(f12 - max2);
            }
            return Math.min(f10, 2.0f) * 0.9f;
        }
        f10 = abs / abs2;
        return Math.min(f10, 2.0f) * 0.9f;
    }

    public static float b(int i10, int i11, u6[] u6VarArr) {
        float abs;
        float abs2;
        float f10 = 1.0f;
        if (u6VarArr.length < 3) {
            return 1.0f;
        }
        float b4 = u6VarArr[0].b();
        float b10 = u6VarArr[1].b();
        float b11 = u6VarArr[2].b();
        float c4 = u6VarArr[0].c();
        float c10 = u6VarArr[1].c();
        float c11 = u6VarArr[2].c();
        float max = Math.max(Math.max(b4, b10), b11);
        float min = Math.min(Math.min(b4, b10), b11);
        float max2 = Math.max(Math.max(c4, c10), c11);
        float min2 = Math.min(Math.min(c4, c10), c11);
        int min3 = (int) (Math.min(i11, i10) * 0.1f);
        Rect rect = new Rect(min3, min3, i10 - min3, i11 - min3);
        if (min < rect.left && min2 < rect.top && max > rect.right && max2 > rect.bottom) {
            return 1.0f;
        }
        float abs3 = Math.abs(max - rect.right);
        float abs4 = Math.abs(max2 - rect.bottom);
        float abs5 = Math.abs(min2 - rect.top);
        float abs6 = Math.abs(min - rect.left);
        float f11 = (rect.left + rect.right) / 2.0f;
        float f12 = (rect.top + rect.bottom) / 2.0f;
        float min4 = Math.min(Math.min(Math.min(abs6, abs3), abs5), abs4);
        if (0.01f > Math.abs(abs6 - min4)) {
            abs = Math.abs(f11 - rect.left);
            abs2 = Math.abs(f11 - min);
        } else if (0.01f > Math.abs(abs3 - min4)) {
            abs = Math.abs(f11 - rect.right);
            abs2 = Math.abs(f11 - max);
        } else if (0.01f > Math.abs(abs5 - min4)) {
            abs = Math.abs(f12 - rect.top);
            abs2 = Math.abs(f12 - min2);
        } else {
            if (0.01f > Math.abs(abs4 - min4)) {
                abs = Math.abs(f12 - rect.bottom);
                abs2 = Math.abs(f12 - max2);
            }
            return Math.min(f10, 2.0f) * 0.9f;
        }
        f10 = abs / abs2;
        return Math.min(f10, 2.0f) * 0.9f;
    }

    private static u6 a(float f10, float f11, float f12, float f13, float f14, float f15) {
        return new u6((f10 + f14) - f12, (f11 + f15) - f13);
    }
}
