package com.cupidapp.live.base.utils;

/* compiled from: SystemPushSetting.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PushPermissionType {
    Urgent(0),
    High(1),
    Medium(2),
    Low(3),
    Off(4),
    Unapplied(5),
    On(6);

    private final int type;

    PushPermissionType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
