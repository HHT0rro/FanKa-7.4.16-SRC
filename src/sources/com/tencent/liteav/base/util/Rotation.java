package com.tencent.liteav.base.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum Rotation {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);


    /* renamed from: e, reason: collision with root package name */
    private static final Rotation[] f42870e = values();
    public final int mValue;

    Rotation(int i10) {
        this.mValue = i10;
    }

    public static Rotation a(int i10) {
        for (Rotation rotation : f42870e) {
            if (rotation.mValue == i10) {
                return rotation;
            }
        }
        return NORMAL;
    }

    public static boolean b(int i10) {
        return i10 == 0 || i10 == 90 || i10 == 180 || i10 == 270;
    }

    public static int a(Rotation rotation) {
        if (rotation != null) {
            return rotation.mValue;
        }
        return NORMAL.mValue;
    }
}
