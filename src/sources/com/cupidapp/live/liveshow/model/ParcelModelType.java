package com.cupidapp.live.liveshow.model;

import kotlin.d;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ParcelModelType {
    ParcelGiftType(1),
    PropCardType(2),
    GiftFragments(3);

    private final int type;

    ParcelModelType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
