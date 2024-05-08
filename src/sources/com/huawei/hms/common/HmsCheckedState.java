package com.huawei.hms.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* renamed from: a, reason: collision with root package name */
    private final int f29634a;

    HmsCheckedState(int i10) {
        this.f29634a = i10;
    }

    public int getState() {
        return this.f29634a;
    }
}
