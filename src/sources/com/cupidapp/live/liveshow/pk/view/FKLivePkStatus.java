package com.cupidapp.live.liveshow.pk.view;

/* compiled from: FKLivePkWarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FKLivePkStatus {
    LivePkInitialize(0),
    LivePkMatching(1),
    LivePkStart(2),
    LivePkInProgress(3),
    LivePkInteractive(4),
    LivePkEnd(5);

    private final int value;

    FKLivePkStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
