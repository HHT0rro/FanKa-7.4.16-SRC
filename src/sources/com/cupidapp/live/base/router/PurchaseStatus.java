package com.cupidapp.live.base.router;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PurchaseStatus {
    CLOSED(1),
    WAITING_FOR_COMFIRM(3),
    SUCCESS(0),
    UNPAID(2);

    private final int value;

    PurchaseStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
