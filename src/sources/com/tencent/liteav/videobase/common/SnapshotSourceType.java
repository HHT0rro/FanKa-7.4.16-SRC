package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum SnapshotSourceType {
    STREAM(0),
    VIEW(1);


    /* renamed from: c, reason: collision with root package name */
    private static final SnapshotSourceType[] f43372c = values();
    public final int mValue;

    SnapshotSourceType(int i10) {
        this.mValue = i10;
    }

    public static SnapshotSourceType a(int i10) {
        for (SnapshotSourceType snapshotSourceType : f43372c) {
            if (i10 == snapshotSourceType.mValue) {
                return snapshotSourceType;
            }
        }
        return VIEW;
    }
}
